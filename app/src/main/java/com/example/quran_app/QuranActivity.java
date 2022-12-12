package com.example.quran_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class QuranActivity extends AppCompatActivity implements View.OnClickListener{

    /* Objects */
    public Button btnext;
    public Button btpre;
    public Button btsearch;

    public EditText txts;
    public EditText txta;

    public TextView txtresult;

    public int Ayat_num;

    public QDH theAyat;
    public QuranArabicText data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran);

        btnext = findViewById(R.id.btnnext);
        btpre = findViewById(R.id.btnprev);
        btsearch = findViewById(R.id.search);
        txtresult = findViewById(R.id.result);
        txta = findViewById(R.id.txt_a);
        txts = findViewById(R.id.txt_s);

        btsearch.setOnClickListener(this);
        btnext.setOnClickListener(this);
        btpre.setOnClickListener(this);


        theAyat = new QDH();
        data = new QuranArabicText();

    }

    @Override
    public void onClick(View view) {
        String AYAT;
        switch (view.getId()) {
            case R.id.search:
                int s =  Integer.parseInt(txts.getText().toString());
                int a =  Integer.parseInt(txta.getText().toString());
                Ayat_num = theAyat.getSurahStart(s-1);
                Ayat_num = Ayat_num + (a-1);

                AYAT = data.QuranArabicText[Ayat_num];
                txtresult.setText(AYAT.toString());
                break;
            case R.id.btnnext:
                Ayat_num = (Ayat_num + 1);
                Ayat_num = Ayat_num % 6000;
                AYAT = data.QuranArabicText[Ayat_num];
                txtresult.setText(AYAT.toString());
                break;
            case R.id.btnprev:
                Ayat_num = (Ayat_num - 1);
                if(Ayat_num == -1)
                {
                    Ayat_num = 6000;
                }
                AYAT = data.QuranArabicText[Ayat_num];
                txtresult.setText(AYAT.toString());
                break;

            default:
                txtresult.setText("HAYA KARR ..");
        }
    }
}