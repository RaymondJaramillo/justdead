package edu.cnm.deepdive.justdead.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.justdead.model.dao.LocationDao;
import edu.cnm.deepdive.justdead.model.dao.NotificationDao;
import edu.cnm.deepdive.justdead.model.entity.Location;
import edu.cnm.deepdive.justdead.model.entity.Notification;
import edu.cnm.deepdive.justdead.service.JustDatabase.Converters;
import java.util.Date;

@Database(
    entities = {Notification.class, Location.class},
    version = 1,
    exportSchema = true
)
@TypeConverters({Converters.class})
public abstract class JustDatabase extends RoomDatabase {

  private static final String DB_NAME = "just_dp";

  private static Application context;

  public static void setContext(Application context) {
    JustDatabase.context = context;
  }

  public static JustDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract NotificationDao getNotificationDao();

  public abstract LocationDao getLocationDao();

    private static class InstanceHolder {
      private static final JustDatabase INSTANCE = Room.databaseBuilder(
          context, JustDatabase.class, DB_NAME)
          .build();
    }

  public static class Converters {

    @TypeConverter
    public static Long fromDate(Date date) {
      return (date != null) ? date.getTime() : null;
    }

    @TypeConverter
    public static Date fromLong(Long value) {
      return (value != null) ? new Date(value) : null;
    }

  }
}
