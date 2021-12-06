package com.example.temadam;

import android.content.Context;

import androidx.room.Room;

public class DatabaseAccess {
    private DatabaseAntrenament database;
    private static DatabaseAccess instance;

    private DatabaseAccess(Context context){
//        Thread thread=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                database= Room.databaseBuilder(context,DatabaseAntrenament.class,"Database_Antrenamente").build();
//            }
//        });
//        thread.start();

        database=Room.databaseBuilder(context,DatabaseAntrenament.class,"DB_Antrenamente").build();

    }

    public static DatabaseAccess getInstance(Context context){
        if(instance==null){
            instance=new DatabaseAccess(context);
        }
        return instance;
    }

    public DatabaseAntrenament getDatabase() { return database; }
}
