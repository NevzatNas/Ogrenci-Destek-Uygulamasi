package com.example.ogrencidestekapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;

public class Deneme2023_Scren extends AppCompatActivity {
    private BarChart barChart;
    private EditText matNet1, matNet2, matNet3, turkNet1, turkNet2, turkNet3;
    private Button showChartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deneme2023_scren);

        barChart = findViewById(R.id.barChart2023);
        matNet1 = findViewById(R.id.matNet01);
        matNet2 = findViewById(R.id.matNet02);
        matNet3 = findViewById(R.id.matNet03);
        turkNet1 = findViewById(R.id.turkNet01);
        turkNet2 = findViewById(R.id.turkNet02);
        turkNet3 = findViewById(R.id.turkNet03);
        showChartButton = findViewById(R.id.showChartButton1);

        showChartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChart();
            }
        });
    }

    private void showChart() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        int matNet1Value = Integer.parseInt(matNet1.getText().toString());
        int matNet2Value = Integer.parseInt(matNet2.getText().toString());
        int matNet3Value = Integer.parseInt(matNet3.getText().toString());
        int turkNet1Value = Integer.parseInt(turkNet1.getText().toString());
        int turkNet2Value = Integer.parseInt(turkNet2.getText().toString());
        int turkNet3Value = Integer.parseInt(turkNet3.getText().toString());

        // Toplam değerlerin hesaplanması
        int netler1Toplam = matNet1Value + turkNet1Value;
        int netler2Toplam = matNet2Value + turkNet2Value;
        int netler3Toplam = matNet3Value + turkNet3Value;

        // Toplam netleri TextView'lere ekleme
        TextView tp1 = findViewById(R.id.tp1);
        TextView tp2 = findViewById(R.id.tp2);
        TextView tp3 = findViewById(R.id.tp3);

        tp1.setText("Toplam Net: " + netler1Toplam);
        tp2.setText("Toplam Net: " + netler2Toplam);
        tp3.setText("Toplam Net: " + netler3Toplam);

        entries.add(new BarEntry(1, new float[]{matNet1Value, turkNet1Value}));
        entries.add(new BarEntry(2, new float[]{matNet2Value, turkNet2Value}));
        entries.add(new BarEntry(3, new float[]{matNet3Value, turkNet3Value}));

        BarDataSet dataSet = new BarDataSet(entries, "Netler");
        dataSet.setStackLabels(new String[]{"Matematik", "Türkçe"});

        int[] colors = new int[]{Color.BLUE, Color.RED};
        dataSet.setColors(colors);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTypeface(Typeface.DEFAULT_BOLD);
        dataSet.setValueTextSize(12f);

        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSet);

        BarData data = new BarData(dataSets);

        barChart.setData(data);
        barChart.setFitBars(true);
        barChart.setDrawValueAboveBar(false); // Değerlerin barların üzerinde gösterilmemesi için

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"",  "1", "2", "3", ""}));
        xAxis.setTextSize(12f);

        YAxis yAxis = barChart.getAxisLeft();
        yAxis.setTextSize(12f);

        Legend legend = barChart.getLegend();
        legend.setCustom(getLegendEntries());
        legend.setTextSize(12f);

        barChart.getAxisRight().setEnabled(true);
        barChart.getDescription().setEnabled(true);

        barChart.invalidate();
    }
    private List<LegendEntry> getLegendEntries() {
        List<LegendEntry> legendEntries = new ArrayList<>();

        LegendEntry entry1 = new LegendEntry();
        entry1.label = "Matematik ";
        entry1.formColor = Color.BLUE;

        LegendEntry entry2 = new LegendEntry();
        entry2.label = "Türkçe";
        entry2.formColor = Color.RED;

        legendEntries.add(entry1);
        legendEntries.add(entry2);

        return legendEntries;
    }




}
