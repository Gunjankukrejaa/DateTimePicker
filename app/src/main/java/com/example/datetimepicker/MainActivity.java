package com.example.datetimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatePicker datePicker;
    Button button;
    TimePicker timePicker;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker=findViewById(R.id.datepicker);
        button=findViewById(R.id.button);
        timePicker=findViewById(R.id.timepicker);
        textView=findViewById(R.id.textview);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String day="Day = "+datePicker.getDayOfMonth();
                String month="Month = "+(datePicker.getMonth()+1);
                String year="Year = "+datePicker.getYear();
                Toast.makeText(getApplicationContext(),day + "\n" + month + "\n" + year,Toast.LENGTH_LONG).show();

                //For time picker
                timePicker.setIs24HourView(false);
                timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker timePicker, int hourOfDay, int minute) {
                        Toast.makeText(getApplicationContext(),hourOfDay+" "+minute,Toast.LENGTH_LONG).show();
                        textView.setText("Time is:: "+hourOfDay+":"+minute);

                    }
                });
            }
        });
    }
}