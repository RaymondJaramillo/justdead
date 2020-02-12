package edu.cnm.deepdive.justdead.service;

import androidx.room.Database;
import edu.cnm.deepdive.justdead.model.entity.Location;
import edu.cnm.deepdive.justdead.model.entity.Notification;

@Database(
    entities = {Notification.class, Location.class},
    version = 1,
    exportSchema = true
)

public class NotificationDatabase {


}
