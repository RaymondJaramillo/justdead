package edu.cnm.deepdive.justdead;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.justdead.model.repository.LocationRepository;
import edu.cnm.deepdive.justdead.model.repository.NotificationRepository;
import edu.cnm.deepdive.justdead.service.GoogleSignInRepository;
import edu.cnm.deepdive.justdead.service.JustDatabase;
import io.reactivex.schedulers.Schedulers;

public class JustdeadApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    JustDatabase.setContext(this);
    JustDatabase.getInstance().getNotificationDao().delete().subscribeOn(Schedulers.io()).subscribe();

    GoogleSignInRepository.setContext(this);
    JustDatabase.setContext(this);
    // This is a manual dependency injection
  }

}
