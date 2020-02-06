package edu.cnm.deepdive.justdead;

import android.app.Application;
import com.facebook.stetho.Stetho;

public class JustdeadApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
  }
}
