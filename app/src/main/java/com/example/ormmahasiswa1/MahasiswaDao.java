package com.example.ormmahasiswa1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

    @Dao
    public interface MahasiswaDao {

        @Insert
        void insert(Mahasiswa mahasiswa);

        @Update
        void update(Mahasiswa mahasiswa);

        @Delete
        void delete(Mahasiswa mahasiswa);

        @Query("SELECT * FROM mahasiswa")
        List<Mahasiswa> getAllMahasiswa();

        @Query("SELECT * FROM mahasiswa WHERE nim = :nim")
        Mahasiswa getMahasiswaByNim(String nim);
    }


