package com.example.temadam;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Antrenament.class}, version = 1, exportSchema = false)
public abstract class DatabaseAntrenament extends RoomDatabase {

    public abstract AntrenamentDAO antrenamentDAO();
}
