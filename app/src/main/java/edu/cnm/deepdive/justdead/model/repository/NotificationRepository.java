package edu.cnm.deepdive.justdead.model.repository;

import android.app.Application;
import android.app.Notification;
import androidx.annotation.NonNull;
import edu.cnm.deepdive.justdead.service.JustDatabase;
import io.reactivex.Single;


public class NotificationRepository {

  private final JustDatabase database;

  private static Application context;

  private NotificationRepository() {
    if (context == null) {
      throw new IllegalStateException();
    }
    database = JustDatabase.getInstance();
  }

  public static void setContext(Application context) {
    NotificationRepository.context = context;
  }

  public static NotificationRepository getInstance() {
    return InstanceHolder.INSTANCE;
  }


  private static class InstanceHolder {

    private static final NotificationRepository INSTANCE = new NotificationRepository();

  }

}