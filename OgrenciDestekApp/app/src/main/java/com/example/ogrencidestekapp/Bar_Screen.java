package com.example.ogrencidestekapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Bar_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_screen);

        Spinner spinner = findViewById(R.id.spinner);
        String[] items = {"Bölüm Seçiniz", "Bilgisayar Mühendisliği", "Bilgisayar ve Öğretim Teknolojileri Öğretmenliği",
                "Elektrik-Elektronik Mühendisliği","Makine Mühendisliği","Endüstri Mühendisliği"};

        Spinner spinner2 = findViewById(R.id.spinner2);
        String[] item = {"Üniversite Seçiniz", "Gazi Üniversitesi", "Boğaziçi Üniversitesi","Marmara Üniversitesi"
                ,"Yıldız Teknik Üniversitesi","İstanbul-Üniversitesi Cerrahpaşa"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedOption = items[position];
                String selectedOptions = item[spinner2.getSelectedItemPosition()];

                updateChart(selectedOption, selectedOptions);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Hiçbir şey seçilmediğinde yapılacaklar
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedOption = items[spinner.getSelectedItemPosition()];
                String selectedOptions = item[position];

                updateChart(selectedOption, selectedOptions);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Hiçbir şey seçilmediğinde yapılacaklar
            }
        });
    }

    private void updateChart(String selectedOption, String selectedOptions) {
        BarChart barChart = findViewById(R.id.barChart);
        ArrayList<BarEntry> visitors = new ArrayList<>();
        BarDataSet barDataSet;
        BarData barData;

        if (selectedOptions.equals("Gazi Üniversitesi")) {
            if (selectedOption.equals("Bilgisayar Mühendisliği")) {
                visitors.add(new BarEntry(0.5f, 317));
                visitors.add(new BarEntry(1.5f, 322));
                visitors.add(new BarEntry(2.5f, 336));

                barDataSet = new BarDataSet(visitors, "Bilgisayar Mühendisliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla

                barData = new BarData(barDataSet);
                barChart.getDescription().setText("Gazi Üniversitesi - Bilgisayar Mühendisliği");
            }
            else  if (selectedOption.equals("Bilgisayar ve Öğretim Teknolojileri Öğretmenliği")) {
                visitors.add(new BarEntry(0.5f, 279));
                visitors.add(new BarEntry(1.5f, 286));
                visitors.add(new BarEntry(2.5f, 289));

                barDataSet = new BarDataSet(visitors, "Bilgisayar ve Öğretim Teknolojileri Öğretmenliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla

                barData = new BarData(barDataSet);
                barChart.getDescription().setText("Gazi Üniversitesi - Bilgisayar ve Öğretim Teknolojileri Öğretmenliği");
            }
            else  if (selectedOption.equals("Elektrik-Elektronik Mühendisliği")) {
                visitors.add(new BarEntry(0.5f, 301));
                visitors.add(new BarEntry(1.5f, 307));
                visitors.add(new BarEntry(2.5f, 307));

                barDataSet = new BarDataSet(visitors, "Elektrik-Elektronik Mühendisliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla

                barData = new BarData(barDataSet);
                barChart.getDescription().setText("Gazi Üniversitesi - Elektrik-Elektronik Mühendisliği");
            }
            else  if (selectedOption.equals("Makine Mühendisliği")) {
                visitors.add(new BarEntry(0.5f, 296));
                visitors.add(new BarEntry(1.5f, 308));
                visitors.add(new BarEntry(2.5f, 309));

                barDataSet = new BarDataSet(visitors, "Makine Mühendisliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla


                barData = new BarData(barDataSet);
                barChart.getDescription().setText("Gazi Üniversitesi - Makine Mühendisliği");
            }
            else  if (selectedOption.equals("Endüstri Mühendisliği")) {
                visitors.add(new BarEntry(0.5f, 296));
                visitors.add(new BarEntry(1.5f, 305));
                visitors.add(new BarEntry(2.5f, 318));

                barDataSet = new BarDataSet(visitors, "Endüstri Mühendisliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla


                barData = new BarData(barDataSet);
                barChart.getDescription().setText("Gazi Üniversitesi - Endüstri Mühendisliği");
            }
            else {
                Toast.makeText(Bar_Screen.this, "Geçerli bir bölüm seçin", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        else if (selectedOptions.equals("Boğaziçi Üniversitesi")) {
            if (selectedOption.equals("Bilgisayar Mühendisliği")) {
                visitors.add(new BarEntry(0.5f, 351));
                visitors.add(new BarEntry(1.5f, 362));
                visitors.add(new BarEntry(2.5f, 355));

                barDataSet = new BarDataSet(visitors, "Bilgisayar Mühendisliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla

                barData = new BarData(barDataSet);
                barChart.getDescription().setText("Boğaziçi Üniversitesi - Bilgisayar Mühendisliği");
            }
            else  if (selectedOption.equals("Bilgisayar ve Öğretim Teknolojileri Öğretmenliği")) {
                visitors.add(new BarEntry(0.5f, 305));
                visitors.add(new BarEntry(1.5f, 322));
                visitors.add(new BarEntry(2.5f, 342));


                barDataSet = new BarDataSet(visitors, "Bilgisayar ve Öğretim Teknolojileri Öğretmenliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla

                barData = new BarData(barDataSet);
                barChart.getDescription().setText("Boğaziçi Üniversitesi - Bilgisayar ve Öğretim Teknolojileri Öğretmenliği");
            }
            else  if (selectedOption.equals("Elektrik-Elektronik Mühendisliği")) {
                visitors.add(new BarEntry(0.5f, 329));
                visitors.add(new BarEntry(1.5f, 339));
                visitors.add(new BarEntry(2.5f, 344));

                barDataSet = new BarDataSet(visitors, "Elektrik-Elektronik Mühendisliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla

                barData = new BarData(barDataSet);
                barChart.getDescription().setText("Boğaziçi Üniversitesi - Elektrik-Elektronik Mühendisliği");
            }
            else  if (selectedOption.equals("Makine Mühendisliği")) {
                visitors.add(new BarEntry(0.5f, 322));
                visitors.add(new BarEntry(1.5f, 336));
                visitors.add(new BarEntry(2.5f, 343));

                barDataSet = new BarDataSet(visitors, "Makine Mühendisliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla



                barData = new BarData(barDataSet);
                barChart.getDescription().setText("Boğaziçi Üniversitesi - Makine Mühendisliği");
            }
            else  if (selectedOption.equals("Endüstri Mühendisliği")) {
                visitors.add(new BarEntry(0.5f, 350));
                visitors.add(new BarEntry(1.5f, 347));
                visitors.add(new BarEntry(2.5f, 362));

                barDataSet = new BarDataSet(visitors, "Endüstri Mühendisliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla


                barData = new BarData(barDataSet);
                barChart.getDescription().setText("Boğaziçi Üniversitesi - Endüstri Mühendisliği");
            }
            else {
                Toast.makeText(Bar_Screen.this, "Geçerli bir bölüm seçin", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        else if (selectedOptions.equals("Marmara Üniversitesi")) {
            if (selectedOption.equals("Bilgisayar Mühendisliği")) {
                visitors.add(new BarEntry(0.5f, 326));
                visitors.add(new BarEntry(1.5f, 336));
                visitors.add(new BarEntry(2.5f, 338));

                barDataSet = new BarDataSet(visitors, "Bilgisayar Mühendisliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla


                barData = new BarData(barDataSet);
                barChart.getDescription().setText("Marmara Üniversitesi - Bilgisayar Mühendisliği");
            }
            else  if (selectedOption.equals("Bilgisayar ve Öğretim Teknolojileri Öğretmenliği")) {
                visitors.add(new BarEntry(0.5f, 281));
                visitors.add(new BarEntry(1.5f, 293));
                visitors.add(new BarEntry(2.5f, 296));

                barDataSet = new BarDataSet(visitors, "Bilgisayar ve Öğretim Teknolojileri Öğretmenliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla


                barData = new BarData(barDataSet);
                barChart.getDescription().setText("Marmara Üniversitesi - Bilgisayar ve Öğretim Teknolojileri Öğretmenliği");
            }
            else  if (selectedOption.equals("Elektrik-Elektronik Mühendisliği")) {
                visitors.add(new BarEntry(0.5f, 308));
                visitors.add(new BarEntry(1.5f, 315));
                visitors.add(new BarEntry(2.5f, 310));

                barDataSet = new BarDataSet(visitors, "Elektrik-Elektronik Mühendisliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla


                barData = new BarData(barDataSet);
                barChart.getDescription().setText("Marmara Üniversitesi - Elektrik-Elektronik Mühendisliği");
            }
            else  if (selectedOption.equals("Makine Mühendisliği")) {
                visitors.add(new BarEntry(0.5f, 300));
                visitors.add(new BarEntry(1.5f, 312));
                visitors.add(new BarEntry(2.5f, 306));

                barDataSet = new BarDataSet(visitors, "Makine Mühendisliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla


                barData = new BarData(barDataSet);
                barChart.getDescription().setText("Marmara Üniversitesi - Makine Mühendisliği");
            }
            else  if (selectedOption.equals("Endüstri Mühendisliği")) {
                visitors.add(new BarEntry(0.5f, 301));
                visitors.add(new BarEntry(1.5f, 314));
                visitors.add(new BarEntry(2.5f, 314));

                barDataSet = new BarDataSet(visitors, "Endüstri Mühendisliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla



                barData = new BarData(barDataSet);
                barChart.getDescription().setText("Marmara Üniversitesi - Endüstri Mühendisliği");
            }
            else {
                Toast.makeText(Bar_Screen.this, "Geçerli bir bölüm seçin", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        else if (selectedOptions.equals("Yıldız Teknik Üniversitesi")) {
            if (selectedOption.equals("Bilgisayar Mühendisliği")) {
                visitors.add(new BarEntry(0.5f, 327));
                visitors.add(new BarEntry(1.5f, 339));
                visitors.add(new BarEntry(2.5f, 343));

                barDataSet = new BarDataSet(visitors, "Bilgisayar Mühendisliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla



                barData = new BarData(barDataSet);
                barChart.getDescription().setText("Yıldız Teknik Üniversitesi - Bilgisayar Mühendisliği");
            }
            else  if (selectedOption.equals("Bilgisayar ve Öğretim Teknolojileri Öğretmenliği")) {
                visitors.add(new BarEntry(0.5f, 286));
                visitors.add(new BarEntry(1.5f, 310));
                visitors.add(new BarEntry(2.5f, 309));

                barDataSet = new BarDataSet(visitors, "Bilgisayar ve Öğretim Teknolojileri Öğretmenliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla



                barData = new BarData(barDataSet);
                barChart.getDescription().setText("Yıldız Teknik Üniversitesi - Bilgisayar ve Öğretim Teknolojileri Öğretmenliği");
            }
            else  if (selectedOption.equals("Elektrik-Elektronik Mühendisliği")) {
                visitors.add(new BarEntry(0.5f, 304));
                visitors.add(new BarEntry(1.5f, 311));
                visitors.add(new BarEntry(2.5f, 324));

                barDataSet = new BarDataSet(visitors, "Elektrik-Elektronik Mühendisliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla



                barData = new BarData(barDataSet);
                barChart.getDescription().setText("Yıldız Teknik Üniversitesi - Elektrik-Elektronik Mühendisliği");
            }
            else  if (selectedOption.equals("Makine Mühendisliği")) {
                visitors.add(new BarEntry(0.5f, 304));
                visitors.add(new BarEntry(1.5f, 315));
                visitors.add(new BarEntry(2.5f, 316));

                barDataSet = new BarDataSet(visitors, "Makine Mühendisliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla

                barData = new BarData(barDataSet);
                barChart.getDescription().setText("Yıldız Teknik Üniversitesi - Makine Mühendisliği");
            }
            else  if (selectedOption.equals("Endüstri Mühendisliği")) {
                visitors.add(new BarEntry(0.5f, 304));
                visitors.add(new BarEntry(1.5f, 320));
                visitors.add(new BarEntry(2.5f, 325));

                barDataSet = new BarDataSet(visitors, "Endüstri Mühendisliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);
                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla



                barData = new BarData(barDataSet);
                barChart.getDescription().setText("Yıldız Teknik Üniversitesi - Endüstri Mühendisliği");
            }
            else {
                Toast.makeText(Bar_Screen.this, "Geçerli bir bölüm seçin", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        else if (selectedOptions.equals("İstanbul-Üniversitesi Cerrahpaşa")) {
            if (selectedOption.equals("Bilgisayar Mühendisliği")) {
                visitors.add(new BarEntry(0.5f, 318));
                visitors.add(new BarEntry(1.5f, 327));
                visitors.add(new BarEntry(2.5f, 331));

                barDataSet = new BarDataSet(visitors, "Bilgisayar Mühendisliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla

                barData = new BarData(barDataSet);
                barChart.getDescription().setText("İstanbul-Üniversitesi Cerrahpaşa - Bilgisayar Mühendisliği");
            }
            else  if (selectedOption.equals("Bilgisayar ve Öğretim Teknolojileri Öğretmenliği")) {
                visitors.add(new BarEntry(0.5f, 281));
                visitors.add(new BarEntry(1.5f, 291));
                visitors.add(new BarEntry(2.5f, 293));

                barDataSet = new BarDataSet(visitors, "Bilgisayar ve Öğretim Teknolojileri Öğretmenliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla


                barData = new BarData(barDataSet);
                barChart.getDescription().setText("İstanbul-Üniversitesi Cerrahpaşa - Bilgisayar ve Öğretim Teknolojileri Öğretmenliği");
            }
            else  if (selectedOption.equals("Elektrik-Elektronik Mühendisliği")) {
                visitors.add(new BarEntry(0.5f, 295));
                visitors.add(new BarEntry(1.5f, 302));
                visitors.add(new BarEntry(2.5f, 304));

                barDataSet = new BarDataSet(visitors, "Elektrik-Elektronik Mühendisliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla


                barData = new BarData(barDataSet);
                barChart.getDescription().setText("İstanbul-Üniversitesi Cerrahpaşa - Elektrik-Elektronik Mühendisliği");
            }
            else  if (selectedOption.equals("Makine Mühendisliği")) {
                visitors.add(new BarEntry(0.5f, 296));
                visitors.add(new BarEntry(1.5f, 300));
                visitors.add(new BarEntry(2.5f, 302));

                barDataSet = new BarDataSet(visitors, "Makine Mühendisliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla

                barData = new BarData(barDataSet);
                barChart.getDescription().setText("İstanbul-Üniversitesi Cerrahpaşa - Makine Mühendisliği");
            }
            else  if (selectedOption.equals("Endüstri Mühendisliği")) {
                visitors.add(new BarEntry(0.5f, 296)); // 2020
                visitors.add(new BarEntry(1.5f, 308)); // 2021
                visitors.add(new BarEntry(2.5f, 305)); // 2022

                barDataSet = new BarDataSet(visitors, "Endüstri Mühendisliği");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                barData = new BarData(barDataSet);
                barData.setValueFormatter(new DefaultValueFormatter(0)); // Değerlerin tam sayı olarak görünmesini sağlar

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"2020", "2021", "2022"}));
                xAxis.setCenterAxisLabels(true); // Ekseni ortala
                xAxis.setGranularity(1f); // Birim değerleri arasında minimum mesafe ayarla
                xAxis.setAxisMinimum(0f); // Eksenin minimum değerini ayarla
                xAxis.setAxisMaximum(3f); // Eksenin maksimum değerini ayarla

                barChart.getDescription().setText("İstanbul-Üniversitesi Cerrahpaşa - Endüstri Mühendisliği");
                barChart.setData(barData);

            }
            else {
                Toast.makeText(Bar_Screen.this, "Geçerli bir bölüm seçin", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        else {
            Toast.makeText(Bar_Screen.this, "Geçerli bir seçenek seçin", Toast.LENGTH_SHORT).show();
            return;
        }
        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.animateY(2000);
    }
}

