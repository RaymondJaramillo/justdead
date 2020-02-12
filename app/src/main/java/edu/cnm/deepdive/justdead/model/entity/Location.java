package edu.cnm.deepdive.justdead.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = Notification.class,
            parentColumns = "notification_id",
            childColumns = "notification_id",
            onDelete = ForeignKey.CASCADE
        )
    }
)
public class Location {


  @ColumnInfo(name = "location_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @ColumnInfo(name = "notification_id")
  private long notificationId;

  @ColumnInfo(index = true)
  private double longitude;

  @ColumnInfo(index = true)
  private double latitude;

  @ColumnInfo(name = "time_stamp", index = true)
  private Date timeStamp;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getNotificationId() {
    return notificationId;
  }

  public void setNotificationId(long notificationId) {
    this.notificationId = notificationId;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public Date getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(Date timeStamp) {
    this.timeStamp = timeStamp;
  }
}
