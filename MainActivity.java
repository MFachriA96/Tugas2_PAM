package com.example.kalkulator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtNumber1, edtNumber2;
    RadioGroup radioGroup;
    Button btnHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumber1 = findViewById(R.id.edtNumber1);
        edtNumber2 = findViewById(R.id.edtNumber2);
        radioGroup = findViewById(R.id.radioGroup);
        btnHitung = findViewById(R.id.btnHitung);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = edtNumber1.getText().toString();
                String num2 = edtNumber2.getText().toString();

                if (num1.isEmpty() || num2.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Harap masukkan kedua angka!", Toast.LENGTH_SHORT).show();
                    return;
                }

                double angka1 = Double.parseDouble(num1);
                double angka2 = Double.parseDouble(num2);
                double hasil = 0;
                String operasi = "";

                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(MainActivity.this, "Pilih operasi terlebih dahulu!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (selectedId == R.id.rbTambah) {
                    hasil = angka1 + angka2;
                    operasi = "+";
                } else if (selectedId == R.id.rbKurang) {
                    hasil = angka1 - angka2;
                    operasi = "-";
                } else if (selectedId == R.id.rbKali) {
                    hasil = angka1 * angka2;
                    operasi = "×";
                } else if (selectedId == R.id.rbBagi) {
                    if (angka2 == 0) {
                        Toast.makeText(MainActivity.this, "Tidak bisa dibagi dengan nol!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    hasil = angka1 / angka2;
                    operasi = "÷";
                }

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("hasil", hasil);
                intent.putExtra("nim", "235150701111013");
                intent.putExtra("nama", "Muhammad Fachri Afrizal");
                intent.putExtra("operasi", operasi);
                startActivity(intent);
            }
        });
    }
}
