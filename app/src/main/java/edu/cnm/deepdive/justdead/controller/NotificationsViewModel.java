package edu.cnm.deepdive.justdead.controller;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import edu.cnm.deepdive.justdead.model.entity.Notification;
import edu.cnm.deepdive.justdead.model.pojo.Contact;
import edu.cnm.deepdive.justdead.model.repository.ContactRepository;
import edu.cnm.deepdive.justdead.model.repository.NotificationRepository;
import edu.cnm.deepdive.justdead.service.GoogleSignInRepository;
import edu.cnm.deepdive.justdead.service.JustDatabase;
import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NotificationsViewModel extends AndroidViewModel implements LifecycleObserver {

  private final Context context;
  private final ContactRepository contactRepository;
  private final NotificationRepository notificationRepository;
  private final MutableLiveData<List<Contact>> contacts;
  private final MutableLiveData<Contact> contact;
  private final MutableLiveData<Long> notificationId;
  private final LiveData<Notification> notification;
  private final MutableLiveData<Throwable> throwable;
  private final JustDatabase database;
  private final MutableLiveData<Set<String>> permissions;
  private CompositeDisposable pending;
  // TODO Add Live data fields for locations.

  public NotificationsViewModel(@NonNull Application application) {
    super(application);
    this.context = application;
    database = JustDatabase.getInstance();
    contactRepository = new ContactRepository(application);
    notificationRepository = new NotificationRepository(application);
    contacts = new MutableLiveData<>();
    contact = new MutableLiveData<>();
    notificationId = new MutableLiveData<>();
    notification = Transformations
        .switchMap(notificationId, (id) -> database.getNotificationDao().select(id));
    throwable = new MutableLiveData<>();
    permissions = new MutableLiveData<>(new HashSet<>());
    pending = new CompositeDisposable();
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
    return notificationRepository.getAll();
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  public MutableLiveData<Set<String>> getPermissions() {
    return permissions;
  }

  public void grantPermission(String permission) {
    Set<String> permissions = this.permissions.getValue();
    if (permissions.add(permission)) {
      this.permissions.setValue(permissions);
    }
  }

  public void revokePermission(String permission) {
    Set<String> permissions = this.permissions.getValue();
    if (permissions.remove(permission)) {
      this.permissions.setValue(permissions);
    }
  }

  public void refreshContacts() {
    pending.add(
        contactRepository.getAll()
            .subscribe(
                contacts::postValue,
                throwable::postValue
            )
    );
  }

  public void setContactUri(Uri uri) {
    pending.add(
        contactRepository.get(uri)
            .subscribe(
                contact::postValue,
                throwable::postValue
            )
    );
  }

  public void setNotificationId(long id) {
    notificationId.setValue(id);
  }

  public LiveData<Notification> getNotification() {
    return notification;
  }

  public void save(Notification notification) {
    throwable.setValue(null);
    pending.add(
        notificationRepository.save(notification)
            .subscribe(
                () -> {
                },
                throwable::postValue
            )
    );

  }

  public void remove(Notification notification) {
    throwable.setValue(null);
    pending.add(
        notificationRepository.remove(notification)
            .subscribe(
                () -> {
                },
                throwable::postValue
            )
    );
  }

  // TODO Add methods for locations

}
