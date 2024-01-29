package org.chinh.baitapmoblile.sqlite;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    public int userId;

    public String userName;
}
