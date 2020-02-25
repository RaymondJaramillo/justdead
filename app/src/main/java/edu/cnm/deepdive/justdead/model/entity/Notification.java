package edu.cnm.deepdive.justdead.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    indices =  {
        @Index(value = "contact_name", unique = true),
        @Index(value = "message"),
        @Index(value = "text"),
        @Index(value = "battery")
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


  private int battery;

  @ColumnInfo(name = "contact_name", collate = ColumnInfo.NOCASE)
  private String contactName;

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

  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }
}
