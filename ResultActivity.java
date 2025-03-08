package com.example.kalkulator;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView tvHasil = findViewById(R.id.tvHasil);
        TextView tvNim = findViewById(R.id.tvNim);
        TextView tvNama = findViewById(R.id.tvNama);

        double hasil = getIntent().getDoubleExtra("hasil", 0);
        String nim = getIntent().getStringExtra("nim");
        String nama = getIntent().getStringExtra("nama");
        String operasi = getIntent().getStringExtra("operasi");

        tvHasil.setText("Hasil: " + hasil);
        tvNim.setText("NIM: " + nim);
        tvNama.setText("Nama: " + nama);
    }
}
