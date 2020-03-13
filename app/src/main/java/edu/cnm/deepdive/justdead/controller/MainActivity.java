package edu.cnm.deepdive.justdead.controller;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import edu.cnm.deepdive.justdead.R;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  private static final int PERMISSION_REQUEST_CODE = 1;

  ListView listView ;
  ArrayList<String> contactsArray ;
  ArrayAdapter<String> arrayAdapter ;
  Button contactsButton;
  Button callButton;
  Cursor cursor ;
  String name, contactNumber ;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    if (Build.VERSION.SDK_INT >= 23) {
      if (checkPermission()) {
        Log.e("permission", "Permission already granted.");
      } else {
        requestPermission();
      }
    }
    setContentView(R.layout.activity_main);
    BottomNavigationView navView = findViewById(R.id.nav_view);
    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
        R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
        .build();
    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    NavigationUI.setupWithNavController(navView, navController);

    listView = (ListView)findViewById(R.id.listview);
    contactsArray = new ArrayList<String>();
    contactsButton = (Button)findViewById(R.id.contacts);
    contactsButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {

        AddContactstoArray();

//Initialize ArrayAdapter and declare that we’re converting Strings into Views//

        arrayAdapter = new ArrayAdapter<String>(
            MainActivity.this,

//Specify the XML file where you’ve defined the layout for each item//

            R.layout.contact_listview, R.id.textView,

//The array of data//

            contactsArray
        );

//Set the Adapter to the ListView, using setAdapter()//

        listView.setAdapter(arrayAdapter);

      }

    });

  }

  public void AddContactstoArray(){

//Query the phone number table using the URI stored in CONTENT_URI//

    cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null, null, null);

    while (cursor.moveToNext()) {

//Get the display name for each contact//

      name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

//Get the phone number for each contact//

      contactNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

//Add each display name and phone number to the Array//

      contactsArray.add(name + " " + ":" + " " + contactNumber);
    }

    cursor.close();

  }

  public boolean checkPermission() {

    int CallPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE);
    int ContactPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS);

    return CallPermissionResult == PackageManager.PERMISSION_GRANTED &&
        ContactPermissionResult == PackageManager.PERMISSION_GRANTED;

  }

  private void requestPermission() {

    ActivityCompat.requestPermissions(MainActivity.this, new String[]
        {
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.CALL_PHONE
        }, PERMISSION_REQUEST_CODE);

  }

  @Override
  public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
    switch (requestCode) {

      case PERMISSION_REQUEST_CODE:
        callButton = (Button)findViewById(R.id.call);

        if (grantResults.length > 0) {

          boolean CallPermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;
          boolean ReadContactsPermission = grantResults[1] == PackageManager.PERMISSION_GRANTED;

          if (CallPermission && ReadContactsPermission) {

            Toast.makeText(MainActivity.this,
                "Permission accepted", Toast.LENGTH_LONG).show();

//If permission is denied...//

          } else {
            Toast.makeText(MainActivity.this,
                "Permission denied", Toast.LENGTH_LONG).show();

//....disable the Call and Contacts buttons//

            callButton.setEnabled(false);
            contactsButton.setEnabled(false);

          }
          break;
        }
    }
  }

  public void call(View view)
  {
    final EditText phoneNumber = (EditText) findViewById(R.id.phoneNumber);
    String phoneNum = phoneNumber.getText().toString();
    if(!TextUtils.isEmpty(phoneNum)) {
      String dial = "tel:" + phoneNum;
      startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
    }else {
      Toast.makeText(MainActivity.this, "Please enter a valid telephone number", Toast.LENGTH_SHORT).show();
    }

  }

  public void launchSMS(View view) {
    Intent intent = new Intent(MainActivity.this, SMSActivity.class);
    startActivity(intent);
  }
}