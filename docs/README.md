## Description 

We all have a loved one who thinks the worst whenever we don't answer the 
phone. Justdead is an app that would let the people closest to you know that your phone 
is  Justdead, not you. Justdead would send a text and last known location to 
the people you have selected, before your phone dies. You can select a percentage, 
customized message and a list of people you would like your message to be sent to 
and then Justdead will automatically do the rest. 
Justdead will let your loved ones worry a little less.

## Intended users

* Parents who worry when children don't answer the phone.

* A spouse who wants to let loved ones know that their phone is close to dying.

### [User stories](user-stories.md)

## Design Documentation

### [Wireframe diagram](wireframe.md)

### [Entity-relationship diagram](erd.md)

## External services

### Google Map Services
* [Google API](https://developers.google.com/maps/documentation/embed/get-api-key)
* Justdead will take the current location, when a phone hits a certain percentage, and send it to selected contacts. 
* App will be able to still function with out location features if user selects. Locations services are also only needed when a certain percentage is hit, not constantly running. 

### Local Contacts 
* [developer.android.com](https://developer.android.com/training/contacts-provider/retrieve-names)
* Local contacts will be pulled from the users phone and messages will be sent to them.
* This will be a required service because the app would need this information to send messages. 

### Messenger
* [developer.android.com](https://developer.android.com/training/sharing/index.html)
* A message and location will be sent through Messenger to selected contacts. 
* This is another vital service for the functionality of the app.