package edu.cnm.deepdive.justdead.model.repository;

import android.app.Application;
import edu.cnm.deepdive.justdead.model.entity.Notification;
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


}