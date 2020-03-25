package edu.cnm.deepdive.justdead.controller;

import static android.Manifest.permission.READ_CONTACTS;


import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import edu.cnm.deepdive.justdead.R;
import edu.cnm.deepdive.justdead.view.NotificationRecyclerAdapter;

public class NotificationsFragment extends Fragment {
  private static final int SCOPED_STORAGE_BUILD_VERSION = VERSION_CODES.Q;
  private RecyclerView notificationList;
  private NotificationsViewModel viewModel;
  private FloatingActionButton addNotification;
  private boolean showContacts = false;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_notifications, container, false);
    notificationList = root.findViewById(R.id.notification_list);
    addNotification = root.findViewById(R.id.add_notification);
    addNotification.setOnClickListener((v) -> editNotification(0));
    return root;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(getActivity()).get(NotificationsViewModel.class);
    viewModel.getNotifications().observe(getViewLifecycleOwner(), (notifications) -> {
      NotificationRecyclerAdapter adapter =
          new NotificationRecyclerAdapter(getContext(), notifications, (position, notification) -> editNotification(notification.getId()));
      notificationList.setAdapter(adapter);
    });
    viewModel.getContacts().observe(getViewLifecycleOwner(), (contacts) -> {
      Log.d(getClass().getName(), contacts.toString());

    });
  }

  private void editNotification(long notificationId) {
    Log.d(getClass().getName(), String.valueOf(notificationId));
    NotificationEditFragment fragment = NotificationEditFragment.newInstance(notificationId);
    fragment.show(getParentFragmentManager(), fragment.getClass().getName());
  }
}
