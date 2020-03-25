package edu.cnm.deepdive.justdead.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import edu.cnm.deepdive.justdead.model.entity.Notification;
import edu.cnm.deepdive.justdead.view.NotificationRecyclerAdapter.Holder;
import java.util.List;

public class NotificationRecyclerAdapter extends RecyclerView.Adapter<Holder> {

  private final Context context;
  private final List<Notification> notifications;
  private final OnNotificationClickListener listener;

  public NotificationRecyclerAdapter(Context context,
      List<Notification> notifications,
      OnNotificationClickListener listener) {
    this.context = context;
    this.notifications = notifications;
    this.listener = listener;
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View root = LayoutInflater.from(context).inflate(/* TODO Specify layout resource */, parent, false);
    return new Holder(root);
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position, notifications.get(position));
  }

  @Override
  public int getItemCount() {
    return notifications.size();
  }

  class Holder extends ViewHolder {

    // TODO Define fields for the views in the layout

    public Holder(@NonNull View itemView) {
      super(itemView);
      // TODO Get reference to views in item view
    }

    private void bind(int position, Notification notification) {
      // TODO Set contents of views from fields in notification.
      itemView.setOnClickListener((v) -> listener.onNotificationClick(position, notification));
    }
  }

  @FunctionalInterface
  public interface OnNotificationClickListener {
    void onNotificationClick(int position, Notification notification);
  }

}
