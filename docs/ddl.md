# SQL data definition language (DDL)

```sqlite
CREATE TABLE IF NOT EXISTS `Notification`
(
    `notification_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `message`         TEXT COLLATE NOCASE,
    `text`            TEXT COLLATE NOCASE,
    `battery`         INTEGER                           NOT NULL,
    `contact_name`    TEXT COLLATE NOCASE
);
CREATE UNIQUE INDEX IF NOT EXISTS `index_Notification_contact_name` ON `Notification` (`contact_name`);
CREATE INDEX IF NOT EXISTS `index_Notification_battery` ON `Notification` (`battery`);
CREATE TABLE IF NOT EXISTS `Location`
(
    `location_id`     INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `notification_id` INTEGER                           NOT NULL,
    `longitude`       REAL                              NOT NULL,
    `latitude`        REAL                              NOT NULL,
    `time_stamp`      INTEGER,
    FOREIGN KEY (`notification_id`) REFERENCES `Notification` (`notification_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);
CREATE INDEX IF NOT EXISTS `index_Location_longitude` ON `Location` (`longitude`);
CREATE INDEX IF NOT EXISTS `index_Location_latitude` ON `Location` (`latitude`);
CREATE INDEX IF NOT EXISTS `index_Location_time_stamp` ON `Location` (`time_stamp`)
``` 

[Download](ddl.sql)