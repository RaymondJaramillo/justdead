package edu.cnm.deepdive.justdead.model.repository;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.justdead.model.dao.NotificationDao;
import edu.cnm.deepdive.justdead.model.entity.Notification;
import edu.cnm.deepdive.justdead.service.JustDatabase;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;


public class NotificationRepository {

    private final NotificationDao dao;

  private static Context context;

  public NotificationRepository(Context context) {
    JustDatabase database = JustDatabase.getInstance();
    dao = database.getNotificationDao();


  }
  public Completable save(Notification notification) {
    if (notification.getId() == 0) {
      return Completable.fromSingle(
          dao.insert(notification)
              .subscribeOn(Schedulers.io())
      );
    } else {
      return Completable.fromSingle(
          dao.update(notification)
              .subscribeOn(Schedulers.io())
      );
    }
  }

  public Completable remove(Notification notification) {
    return Completable.fromSingle(
        dao.delete(notification)
            .subscribeOn(Schedulers.io())
    );
  }

  public LiveData<List<Notification>> getAll() {
    return dao.selectAll();
  }

  public LiveData<Notification> get() {
    return dao.
        .subscribeOn(Schedulers.io());
  }
}