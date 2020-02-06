package edu.cnm.deepdive.justdead.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    indices =  {
        @Index(value = "contact_name", unique = true)
    }
)
public class Notification {

  @ColumnInfo(name = "notification_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @ColumnInfo(name = "message", collate = ColumnInfo.NOCASE)
  private String message;

  @ColumnInfo(name = "text", collate = ColumnInfo.NOCASE)
  private String text;

  @ColumnInfo(name = "battery", index = true)
  private int battery;

  @ColumnInfo(name = "contact_name", collate = ColumnInfo.NOCASE)
  private String contact_name;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public int getBattery() {
    return battery;
  }

  public void setBattery(int battery) {
    this.battery = battery;
  }

  public String getContact_name() {
    return contact_name;
  }

  public void setContact_name(String contact_name) {
    this.contact_name = contact_name;
  }
}
