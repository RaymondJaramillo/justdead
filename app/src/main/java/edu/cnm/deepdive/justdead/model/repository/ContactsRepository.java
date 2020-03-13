package edu.cnm.deepdive.justdead.model.repository;


import android.provider.ContactsContract.Contacts;
import edu.cnm.deepdive.justdead.JustdeadApplication;
import edu.cnm.deepdive.justdead.service.JustDatabase;
import edu.cnm.deepdive.justdead.service.JustDatabase.InstanceHolder;
import java.util.List;


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

  public List<Contacts> getLocalContacts(Location )
