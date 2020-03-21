package edu.cnm.deepdive.justdead.controller;

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
import edu.cnm.deepdive.justdead.R;

public class NotificationsFragment extends Fragment {

  private RecyclerView notificationList;
  private NotificationsViewModel viewModel;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_contacts, container, false);
    notificationList = root.findViewById(R.id.notification_list);
    return root;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(getActivity()).get(NotificationsViewModel.class);
    viewModel.getNotifications().observe(getViewLifecycleOwner(), (notifications) -> {
      // TODO Create and poplutate RecyclerViewAdapter and attach it to notificationList.
    });
    viewModel.getContacts().observe(getViewLifecycleOwner(), (contacts) -> {
      Log.d(getClass().getName(), contacts.toString());

    });
  }
}
