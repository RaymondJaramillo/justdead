package edu.cnm.deepdive.justdead.model.repository;


import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.justdead.JustdeadApplication;
import edu.cnm.deepdive.justdead.model.dao.NotificationDao;
import edu.cnm.deepdive.justdead.model.entity.Notification;
import edu.cnm.deepdive.justdead.model.pojo.Contact;
import edu.cnm.deepdive.justdead.service.JustDatabase;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ContactRepository {

  private static final String[] CONTACT_FIELDS = {Contacts._ID, Contacts.LOOKUP_KEY, Contacts.DISPLAY_NAME_PRIMARY};


  private Context context;


   public ContactRepository(Context context) {
    this.context = context;
  }

  public Single<List<Contact>> getAll() {
    return Single.fromCallable(this::getContacts)
        .subscribeOn(Schedulers.io());
  }

  public Single<Contact> get(Uri uri) {
    return Single.fromCallable(() -> getContact(uri))
        .subscribeOn(Schedulers.io());
  }

  private Contact getContact(Uri uri) {
    ContentResolver resolver = context.getContentResolver();
    Cursor cursor = resolver
        .query(uri, CONTACT_FIELDS, null, null, null);
    if (cursor.moveToFirst()) {
      return createContact(resolver, cursor);
    } else {
      throw new NoSuchElementException(uri.toString());
    }
  }

  private List<Contact> getContacts() {
    ContentResolver resolver = context.getContentResolver();

    List<Contact> contacts = new ArrayList<>();

    Cursor cursor = resolver
        .query(Contacts.CONTENT_URI, CONTACT_FIELDS, null,  null, null); // TODO Set sort order in last parameter.
    while (cursor.moveToNext()) {

      Contact contact = createContact(resolver, cursor);
      contacts.add(contact);
    }
    return contacts;
  }

  private Contact createContact(ContentResolver resolver, Cursor cursor) {
    Contact contact = new Contact();
    String id = cursor.getString(cursor.getColumnIndex(Contacts._ID));
    String displayName = cursor.getString(cursor.getColumnIndex(Contacts.DISPLAY_NAME_PRIMARY));
    Uri uri = Uri.withAppendedPath(Contacts.CONTENT_URI, id);
    contact.setDisplayName(displayName);
    contact.setUri(uri);

    Cursor phones = resolver.query(Phone.CONTENT_URI, null,
        Phone.CONTACT_ID + " = " + id, null, null);
    while (phones.moveToNext()) {
      int type = phones.getInt(phones.getColumnIndex(Phone.TYPE));
      // TODO Using type to figure out which number for contact is mobile number.
      String number = phones.getString(phones.getColumnIndex(Phone.NUMBER));
      contact.setPhoneNumber(number);
    }
    return contact;
  }
}


