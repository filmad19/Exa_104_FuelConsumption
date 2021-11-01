package com.example.exa_104_fuelconsumption;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvFuel;
    private EditText etInputFuel;
    private TextView tvDistance;
    private EditText etInputDistance;
    private Button btCalculate;
    private TextView tvOutput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFuel = findViewById(R.id.tvFuel);
        etInputFuel = findViewById(R.id.etInputFuel);
        tvDistance = findViewById(R.id.tvDistance);
        etInputDistance = findViewById(R.id.etInputDistance);
        btCalculate = findViewById(R.id.btCalculate);
        tvOutput = findViewById(R.id.tvOutput);

        btCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCalcConsumption();
            }
        });
    }

    @SuppressLint("ResourceAsColor")
    public void onCalcConsumption(){
        //if input is invalid
        if(etInputFuel.getText().length() == 0 || etInputDistance.getText().length() == 0){
            tvOutput.setText(R.string.invalid_input);
            tvOutput.setTextColor(getColor(R.color.grey));
            return;
        }

        try {
            double fuel = Double.parseDouble(etInputFuel.getText().toString());
            double distance = Double.parseDouble(etInputDistance.getText().toString());
            //calculate the result
            double result = fuel/distance*100;

            //change color
            if(result < 10){
                tvOutput.setTextColor(getColor(R.color.green));
            }else{
                tvOutput.setTextColor(getColor(R.color.red));
            }

            //output
            tvOutput.setText(String.format(getString(R.string.output), result));
        }catch (Exception e){
            tvOutput.setText(R.string.invalid_input);
            tvOutput.setTextColor(getColor(R.color.grey));
        }
    }
}