package edu.cnm.deepdive.justdead.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.justdead.model.entity.Location;
import edu.cnm.deepdive.justdead.model.entity.Notification;
import java.util.List;

public class NotificationHistory extends Notification {

  @Relation(entity = Location.class, parentColumn = "notification_id", entityColumn = "notification_id")
  List<Location> locations;

  public List<Location> getLocations() {
    return locations;
  }

  public void setLocations(List<Location> locations) {
    this.locations = locations;
  }
}
