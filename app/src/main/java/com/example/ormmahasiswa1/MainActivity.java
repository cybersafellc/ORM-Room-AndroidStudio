package com.example.ormmahasiswa1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ormmahasiswa1.AppDatabase;
import com.example.ormmahasiswa1.Mahasiswa;

public class MainActivity extends AppCompatActivity {

    private EditText namaEditText, nimEditText, alamatEditText, asalSekolahEditText;
    private Button simpanButton;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namaEditText = findViewById(R.id.namaEditText);
        nimEditText = findViewById(R.id.nimEditText);
        alamatEditText = findViewById(R.id.alamatEditText);
        asalSekolahEditText = findViewById(R.id.asalSekolahEditText);
        simpanButton = findViewById(R.id.simpanButton);

        database = AppDatabase.getInstance(this);

        simpanButton.setOnClickListener(v -> {
            String nama = namaEditText.getText().toString();
            String nim = nimEditText.getText().toString();
            String alamat = alamatEditText.getText().toString();
            String asalSekolah = asalSekolahEditText.getText().toString();

            if (!nama.isEmpty() && !nim.isEmpty() && !alamat.isEmpty() && !asalSekolah.isEmpty()) {
                Mahasiswa mahasiswa = new Mahasiswa(nama, nim, alamat, asalSekolah);

                new Thread(() -> {
                    database.mahasiswaDao().insert(mahasiswa);
                    runOnUiThread(() -> Toast.makeText(MainActivity.this, "Data Mahasiswa Disimpan", Toast.LENGTH_SHORT).show());
                }).start();
            } else {
                Toast.makeText(MainActivity.this, "Semua kolom harus diisi", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
