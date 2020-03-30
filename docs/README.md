## Introduction 

In the connected world that we live in today people are always reachable by their phones. Most people that call you, (especially family and loved ones), expect you to answer. Even though are countless ways to make sure our phones are always charged, we still find them always being dead. Justdead would make sure that, even your phone is dead, loved ones will still know that you are okay. It would do this by sending out a notification to those people, automatically, before your phone dies.
 

## Description 
Developed in Java, Justdead is an Android app that can send a notification to loved one automatically if your cellphone battery gets too low. All you would have to do is go to the Notifications page, select the the + to add a new Notification, select a contact, prepare a message for the selected contact, and select a battery level that you would like the message sent out at. After this Justdead will do the rest automatically. You will be able to add multiple Notifications for different contacts and battery levels. 

## Intended users

* A Parent who worries when child doesn't answer the phone and they have no idea why or where their children are.

* A spouse who wants to let loved ones know that their phone is close to dying no matter how busy or where they are.


* A forgetful person, who lives alone, wants to make sure that loved ones and friends know that they are okay.

### [User stories](user-stories.md)

## Current State

The current state of Justdead is not deployable or ready for testing. The app is able to build and launch on a device, but there are some key elements that the app needs in order to be functional.

These are:

### Deficiencies

* Taking a message and sending it through the device that the app is on. 
* Viewing the current level of the battery and connecting a Notification to that battery level.
* Viewing the Notifications that have been made on the Home page.

### Aesthetics/Cosmetics

* Adding graphics/logo to home page. 
* Customizing color scheme of app

### Functional stretch goals

* Adding a location ping to a Notification when the selected battery level triggers.
* Adding the ability to add multiple contacts to one notification. 
* Adding the functionality to see the history of already sent alerts.

## Design Documentation


* [Wireframe diagram](wireframe.md)


* [Entity-relationship diagram](erd.md)

## Technical requirements & dependencies

### Hardware

* Testing: Samsung Galaxy s9,
* Currently the only orientation used is portrait.
* Android API: 29.0.2
* Minimum API: 21
* Grade 3.5.0

### Third Party Libraries

   * [Androidx](https://developer.android.com/jetpack/androidx)       
   * [Androidx Room](https://developer.android.com/jetpack/androidx/releases/room)       
   * [Google](https://developers.google.com/android)      
   * [Reactivex](https://github.com/ReactiveX)       
   * [Square Up](https://square.github.io/okhttp/)
       * [Retrofit2](https://square.github.io/retrofit/2.x/retrofit/)
           * [Retrofit](https://square.github.io/retrofit/)
   * [Facebook Stetho](https://facebook.github.io/stetho/)

### External services


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

## Instructions for cloning and running Justdead
1. Clone the repository using the green "Clone or Download" button (make sure to select SSH and then copy).  
2. Navigate to IDE and choose new project from version control using Git.
3. Paste the url that was copied at the repository. No matter how many time you are asked, do not open project.
4. After the repository is cloned select import project and select project to import (Justdead). 
5. Build with Gradle. Be sure to import any changes from Gradle.
6. When you first create a project, Intellij creates a default run/debug configuration for the main activity. 
7. if any errors occur the project might need to cleaned and rebuilt. 

# [Data Model Implementation](data-model.md)