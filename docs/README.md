## Description 

In connected world that we will in today people are always reachable by their phones. If someone calls you most, (especially family and loved ones), expect you to answer. We also live in a time where their are countless ways to make sure our phones are always charged, but we still find them being allways dead. the goal of this project was to make sure that, even if we are forgetful, our loved ones will still know that we are okay.
This is exactly what Justdead will provide. With justdead you can send a notification to loved one automatically if your cellphone battery get too low. All you would have to do is select a contact, prepare a message for the selected contact, and select a battery level 

## Intended users

* A Parent who worries when child doesn't answer the phone and they have no idea why or where their children are.

* A spouse who wants to let loved ones know that their phone is close to dying no matter how busy or where they are.

* A forgetful person, who lives alone, wants to make sure that loved ones and friends know that they are okay.

### [User stories](user-stories.md)

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

# [Data Model Implementation](data-model.md)