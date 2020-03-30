# SQL data definition language (DDL)

```sqlite
CREATE TABLE IF NOT EXISTS `${TABLE_NAME}`
(
    `notification_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `message`         TEXT COLLATE NOCASE,
    `text`            TEXT COLLATE NOCASE,
    `battery`         INTEGER                           NOT NULL,
    `contact_uri`     TEXT                              NOT NULL,
    `contact_name`    TEXT                              NOT NULL
);
CREATE UNIQUE INDEX IF NOT EXISTS `index_Notification_contact_name` ON `${TABLE_NAME}` (`contact_name`);
CREATE UNIQUE INDEX IF NOT EXISTS `index_Notification_contact_uri` ON `${TABLE_NAME}` (`contact_uri`);
CREATE INDEX IF NOT EXISTS `index_Notification_message` ON `${TABLE_NAME}` (`message`);
CREATE INDEX IF NOT EXISTS `index_Notification_text` ON `${TABLE_NAME}` (`text`);
CREATE INDEX IF NOT EXISTS `index_Notification_battery` ON `${TABLE_NAME}` (`battery`);
CREATE TABLE IF NOT EXISTS room_master_table
(
    id            INTEGER PRIMARY KEY,
    identity_hash TEXT
);
INSERT OR
REPLACE INTO room_master_table (id, identity_hash)
VALUES (42, '8beeebbaed7328f33cf28f5fbbd4caa7');
``` 

[Download](ddl.sql)