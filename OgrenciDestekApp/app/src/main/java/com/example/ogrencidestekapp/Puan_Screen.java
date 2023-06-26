package com.example.ogrencidestekapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Puan_Screen extends AppCompatActivity {
    EditText turkce;
    EditText matematik;
    EditText obp;
    TextView puanSonucu;

    EditText matY;
    EditText turY;

    EditText matYazdir;

    EditText turYazdir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puan_screen);

        turkce = findViewById(R.id.tur);
        matematik = findViewById(R.id.mat);
        obp = findViewById(R.id.obp);
        puanSonucu = findViewById(R.id.puanSonucu);
        matY = findViewById(R.id.mat2);

        turY = findViewById(R.id.tur2);
        matYazdir = findViewById(R.id.mat3);
        turYazdir = findViewById(R.id.tur3);






        Button hesaplaButton = findViewById(R.id.hesapla_button);
        hesaplaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double turkceNet ;

                double matNet ;
                double obpDouble = Double.parseDouble(obp.getText().toString());

                double turkceDogru = Double.parseDouble(turkce.getText().toString());
                double matDogru = Double.parseDouble(matematik.getText().toString());



                double matYanlis = Double.parseDouble((matY.getText().toString()));
                double turYanlis = Double.parseDouble(turY.getText().toString());
                turkceNet = turkceDogru  - (turYanlis/4);
                matNet = matDogru - (matYanlis/4);

                double sayisalPuan = hesaplaSayisal(matNet, turkceNet, obpDouble);
                double sozelPuan = hesaplaSozel(matNet, turkceNet, obpDouble);
                double esitAgirlikPuan = hesaplaEsitAgirlik(matNet, turkceNet, obpDouble);

                puanSonucu.setText("Sayısal Puanı: " + sayisalPuan + "\nSözel Puanı: " + sozelPuan + "\nEşit Ağırlık Puanı: " + esitAgirlikPuan);

                String tnet = Double.toString(turkceNet);
                String mnet = Double.toString(matNet);
                matYazdir.setText(mnet);
                turYazdir.setText(tnet);

            }
        });
    }
    public static double tabanPuan = 127.703;
    public static double mtabanPuan = 145.703;
    public  static  double eaPuan = 136.564;
    public static double hesaplaSayisal(double matNet, double turkceNet, double obp) {
        double puan = (matNet * 2.905) + (turkceNet * 0.618) + (obp * 0.6)+mtabanPuan;
        return puan;
    }

    public static double hesaplaSozel(double matNet, double turkceNet, double obp) {
        double puan = matNet * 0.584 + turkceNet * 3.091 + obp * 0.6 + tabanPuan;
        return puan;
    }

    public static double hesaplaEsitAgirlik(double matNet, double turkceNet, double obp) {
        double puan = matNet * 1.747 + turkceNet * 1.855 + obp * 0.6 + eaPuan;
        return puan;
    }


}