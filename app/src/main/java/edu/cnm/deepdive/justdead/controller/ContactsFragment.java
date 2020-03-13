package edu.cnm.deepdive.justdead.controller;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.loader.app.LoaderManager;
import edu.cnm.deepdive.justdead.R;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.widget.AdapterView;


public class ContactsFragment extends Fragment implements
    LoaderManager.LoaderCallbacks<Cursor>.
    AdapterView.OnItemClickListener {

  @SuppressLint("InlinedApi")
  private final static String[] FROM_COLUMNS = {
      Build.VERSION.SDK_INT
          >= Build.VERSION_CODES.HONEYCOMB ?
          ContactsContract.Contacts.DISPLAY_NAME_PRIMARY :
          ContactsContract.Contacts.DISPLAY_NAME
      };




/*public class ContactsFragment extends Fragment {

  private ContactsViewModel contactsViewModel;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    contactsViewModel =
        ViewModelProviders.of(this).get(ContactsViewModel.class);
    View root = inflater.inflate(R.layout.fragment_contacts, container, false);
    final TextView textView = root.findViewById(R.id.text_contacts);
    contactsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textView.setText(s);
      }
    });
    return root;
  }*/


}