package edu.cnm.deepdive.justdead.controller;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.justdead.R;
import edu.cnm.deepdive.justdead.model.entity.Notification;
import edu.cnm.deepdive.justdead.model.pojo.Contact;
import java.util.List;

public class NotificationEditFragment extends DialogFragment {

  private static final String ID_KEY = "id";

  private long id;
  private View root;
  private NotificationsViewModel viewModel;
  private EditText messageText;
  private AutoCompleteTextView contactName;
  private List<Contact> contacts;
  private Notification notification;
  private SeekBar batteryLevel;


  public static NotificationEditFragment newInstance(long id) {
    NotificationEditFragment fragment = new NotificationEditFragment();
    Bundle args = new Bundle();
    args.putLong(ID_KEY, id);
    fragment.setArguments(args);
    return fragment;
  }

  @SuppressLint("InflateParams")
  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    if (getArguments() != null) {
      id = getArguments().getLong(ID_KEY, 0);
    } else {
      id = 0;
    }
    root = LayoutInflater.from(getContext())
        .inflate(R.layout.fragment_notification_edit, null, false);
    messageText = root.findViewById(R.id.message_text);
    contactName = root.findViewById(R.id.contact_name);
    batteryLevel = root.findViewById(R.id.battery_level);
    messageText.setText("");
    contactName.setText("");
    batteryLevel.setProgress(0);
    //noinspection ConstantConditions
    return new Builder(getContext())
        .setIcon(R.drawable.ic_message_black_24dp)
        .setTitle(R.string.notification_details_title)
        .setView(root)
        .setPositiveButton(android.R.string.ok, (dlg, which) -> save())
        .setNegativeButton(android.R.string.cancel, (dlg, which) -> {
        })
        .create();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return root;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(getActivity()).get(NotificationsViewModel.class);
    viewModel.getContacts().observe(getViewLifecycleOwner(), (contacts) -> {
      this.contacts = contacts;
      ArrayAdapter<Contact> adapter =
          new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line, contacts);
      contactName.setAdapter(adapter);
    });
    if (id != 0) {
      viewModel.getNotification().observe(getViewLifecycleOwner(), (notification) -> {
        if (notification != null) {
          messageText.setText(notification.getMessage());
          batteryLevel.setProgress(notification.getBattery());
          viewModel.getContact().observe(getViewLifecycleOwner(), (contact) -> {
            contactName.setText(contact.getDisplayName());
          });
          viewModel.setContactUri( Uri.parse(notification.getContactUri()));
        }
      });
      viewModel.setNotificationId(id);
    } else {
      notification = new Notification();
    }
  }

  private void save() {
    notification.setText(messageText.getText().toString().trim());
    notification.setBattery(batteryLevel.getProgress());
    Contact contact = null;
    String name = contactName.getText().toString().trim();
    if (!name.isEmpty()) {
      for (Contact c : contacts) {
        if (name.equalsIgnoreCase(c.getDisplayName())) {
          contact = c;
          break;
        }
      }
      if (contact == null) {
        // TODO deal with invalid contact.
      }
    }
    notification.setContactUri(contact.getUri().toString());
    notification.setContactName(contact.getDisplayName());
    viewModel.save(notification);
  }

}
