package org.chinh.baitapmoblile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import org.chinh.baitapmoblile.sqlite.AppDatabase;
import org.chinh.baitapmoblile.sqlite.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "doan.sqlite").build();

        List<User> users = db.userDao().getAllUsers();
    }
}