package edu.cnm.deepdive.justdead.model.repository;

import android.app.Application;
import android.content.Context;
import edu.cnm.deepdive.justdead.service.JustDatabase;


public class NotificationRepository {

  private final JustDatabase database;

  private static Context context;

  public NotificationRepository(Context context) {
    this.context = context;
    database = JustDatabase.getInstance();
  }

}