package com.example.temadam;

import static androidx.room.OnConflictStrategy.REPLACE;
import androidx.room.OnConflictStrategy;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AntrenamentDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Antrenament... antrenament);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertList(List<Antrenament> antrenamentList);

    @Delete
    void delete(Antrenament antrenament);

    @Query("SELECT * FROM ANTRENAMENTE")
    List<Antrenament> getAll();

    @Query("SELECT * FROM ANTRENAMENTE WHERE Durata=:durata")
    List<Antrenament> getAllWithTime(int durata);

    @Query("DELETE FROM ANTRENAMENTE")
    void deleteAll();

    @Query("DELETE FROM ANTRENAMENTE WHERE Denumire=:denumire AND Durata=:durata AND Echipament=:echipament")
    void deleteByProperties(String denumire, int durata, String echipament);
}
