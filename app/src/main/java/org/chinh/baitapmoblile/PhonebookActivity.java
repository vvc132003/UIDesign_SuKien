package org.chinh.baitapmoblile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class PhonebookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonebook);

        ListView listView = findViewById(R.id.contactListView);
        List<Contact> contactList = ContactRepository.getContactList();

        ArrayAdapter<Contact> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showDetailsForSelectedItem(position);
            }
        });
    }

    private void showDetailsForSelectedItem(int position) {
        List<Contact> contactList = ContactRepository.getContactList();
        if (position >= 0 && position < contactList.size()) {
            Contact selectedContact = contactList.get(position);
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("selectedContactName", selectedContact.getName());
            intent.putExtra("selectedContactPhoneNumber", selectedContact.getPhoneNumber());
            startActivity(intent);
        }
    }
}
