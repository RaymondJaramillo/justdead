## Description 

We all have a loved one who thinks the worst whenever we don't answer the 
phone. Justdead is an app that would let the people closest to you know that your phone 
is Justdead, not you. Justdead would send a text and last known location to 
the people you have selected, before your phone dies. You can select a percentage, 
customized message and a list of people you would like your message to be sent to 
and then Justdead will automatically do the rest. 
Justdead will let your loved ones worry a little less.

## Intended users

* A Parent who worries when child doesn't answer the phone and they have no idea why or where their children are.

* A spouse who wants to let loved ones know that their phone is close to dying no matter how busy or where they are.

* A forgetful person, who lives alone, wants to make sure that loved ones and friends know that they are okay.

#### [User stories](user-stories.md)

## Design Documentation


* [Wireframe diagram](wireframe.md)


* [Entity-relationship diagram](erd.md)


## External services


* Google Map Services
    * Site URL: <https://developers.google.com/maps/documentation/embed/get-api-key>
    * Description: Justdead will take the current location, when a phone hits a certain percentage, and send it to selected contacts. 
    * Required: App will be able to still function without location features, if user does not want to use location. Locations services are not constantly used, and only used when a specific battery percentage is hit. 

* Local Contacts 
    * Site URL: <https://developer.android.com/training/contacts-provider/retrieve-names>
    * Description: Local contacts will be pulled from the users phone and messages will be sent to them.
    * Required: This will be a required service because the app would need this information to send messages. 

* Messenger
    * Site URL: <https://developer.android.com/training/sharing/index.html>
    * Description: A message and location will be sent through Messenger to selected contacts. 
    * Required: This is another vital service for the functionality of the app, it will be the way that contacts are informed.

## Implementation

* [Data definition language (DDL)](ddl.md)

## Entity classes

* [Notification.java](https://github.com/RaymondJaramillo/justdead/blob/master/app/src/main/java/edu/cnm/deepdive/justdead/model/entity/Notification.java)
* [Location.java](https://github.com/RaymondJaramillo/justdead/blob/master/app/src/main/java/edu/cnm/deepdive/justdead/model/entity/Location.java)

## Data Access Object (DAO) Interfaces

* [NotificationDao.java](https://github.com/RaymondJaramillo/justdead/blob/master/app/src/main/java/edu/cnm/deepdive/justdead/model/dao/NotificationDao.java)
* [LocationDao.java](https://github.com/RaymondJaramillo/justdead/blob/master/app/src/main/java/edu/cnm/deepdive/justdead/model/dao/LocationDao.java)

## Database class

* [JustDatabase.java](https://github.com/RaymondJaramillo/justdead/blob/master/app/src/main/java/edu/cnm/deepdive/justdead/service/JustDatabase.java)

## Repository classes

* [NotificationRepository.java](https://github.com/RaymondJaramillo/justdead/blob/master/app/src/main/java/edu/cnm/deepdive/justdead/model/repository/NotificationRepository.java)