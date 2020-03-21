package edu.cnm.deepdive.justdead.controller;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import edu.cnm.deepdive.justdead.model.entity.Notification;
import edu.cnm.deepdive.justdead.model.pojo.Contact;
import edu.cnm.deepdive.justdead.model.repository.ContactRepository;
import edu.cnm.deepdive.justdead.model.repository.NotificationRepository;
import edu.cnm.deepdive.justdead.service.JustDatabase;
import java.net.URI;
import java.util.List;

public class NotificationsViewModel extends AndroidViewModel {

  private final Context context;
  private final ContactRepository contactRepository;
  private final NotificationRepository notificationRepository;
  private final MutableLiveData<List<Contact>> contacts;
  private final MutableLiveData<Contact> contact;
  private final MutableLiveData<List<Notification>> notifications;
  private final MutableLiveData<Long> notificationId;
  private final LiveData<Notification> notification;
  private final MutableLiveData<Throwable> throwable;
  private final JustDatabase database;
  // TODO Add Live data fields for locations.

  public NotificationsViewModel(@NonNull Application application) {
    super(application);
    this.context = application;
    database = JustDatabase.getInstance();
    contactRepository = new ContactRepository(application);
    notificationRepository = new NotificationRepository(application);
    contacts = new MutableLiveData<>();
    contact = new MutableLiveData<>();
    notifications = new MutableLiveData<>();
    notificationId = new MutableLiveData<>();
    notification = Transformations.switchMap(notificationId, (id) -> database.getNotificationDao().select(id));
    throwable = new MutableLiveData<>();
    // TODO Initialize live data fields for locations.
    refreshContacts();
  }

  public LiveData<List<Contact>> getContacts() {
    return contacts;
  }

  public LiveData<Contact> getContact() {
    return contact;
  }

  public LiveData<List<Notification>> getNotifications() {
    return notifications;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  public void refreshContacts() {
    contactRepository.getAll()
        .subscribe(
            contacts::postValue,
            throwable::postValue
        );
  }

  public void setContactUri(Uri uri) {
    contactRepository.get(uri)
        .subscribe(
            contact::postValue,
            throwable::postValue
        );
  }

  public void setNotificationId(long id) {
    notificationId.setValue(id);
  }

  public void save(Notification notification) {
    // TODO Invoke repository method.
  }

  public void remove(Notification notification) {
    // TODO Invoke repository method.
  }

  // TODO Add methods for locations

}
