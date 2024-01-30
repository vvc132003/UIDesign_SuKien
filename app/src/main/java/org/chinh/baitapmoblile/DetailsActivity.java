package org.chinh.baitapmoblile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        String selectedContactName = getIntent().getStringExtra("selectedContactName");
        String selectedContactPhoneNumber = getIntent().getStringExtra("selectedContactPhoneNumber");

        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView phoneTextView = findViewById(R.id.phoneTextView);

        nameTextView.setText("Name: " + selectedContactName);
        phoneTextView.setText("Phone Number: " + selectedContactPhoneNumber);
    }
}