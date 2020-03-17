package edu.cnm.deepdive.justdead.controller;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import androidx.appcompat.app.AppCompatActivity;
import edu.cnm.deepdive.justdead.R;

public class MainActivity extends AppCompatActivity {

  ListView 11;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    11 = (ListView)findViewById(R.id.listView);
  }
  public void get(View view) {
    Cursor cursor = getContentResolver().query(Phone.CONTENT_URI,null,null,null,null);
    startManagingCursor(cursor);

    String[] from = {Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER,
    Phone._ID};

    int[] to = {android.R.id.text1,android.R.id.text2};

    SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,cursor,from,to);
    11.setAdapter(simpleCursorAdapter);
    11.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
  }

  private void setChoiceMode(int choiceModeMultiple) {

  }

  private void setAdapter(SimpleCursorAdapter simpleCursorAdapter) {
  }
}