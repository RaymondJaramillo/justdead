package edu.cnm.deepdive.justdead.model.repository;


import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.location.Location;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredPostal;
import android.provider.ContactsContract.Contacts;
import edu.cnm.deepdive.justdead.JustdeadApplication;
import edu.cnm.deepdive.justdead.model.pojo.Contact;
import edu.cnm.deepdive.justdead.service.JustDatabase;
import edu.cnm.deepdive.justdead.service.JustDatabase.InstanceHolder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ContactsRepository {

  private final JustdeadApplication application;
  private final JustDatabase database;

  public ContactsRepository(JustdeadApplication application) {
    this.application = application;
    database = JustDatabase.getInstance();
  }

  public static  ContactsRepository getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public List<Contacts> getLocalContacts(Location 61)

