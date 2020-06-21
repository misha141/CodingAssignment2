package com.example.codingassignment2;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;

public class DefineSlotsActivitiy extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";
    private DatabaseReference post;
    private FirebaseAuth firebaseAuth;


    Button btnDatePicker, btnTimePicker,saveDateTime;
    TextView txtDate, txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_define_slots_activitiy);
        firebaseAuth = FirebaseAuth.getInstance();

        init();

        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);

        saveDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              save();
            }
        });
    }



    private void init() {
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        btnDatePicker = (Button) findViewById(R.id.choose_date);
        btnTimePicker = (Button) findViewById(R.id.choose_time);
        saveDateTime = (Button)findViewById(R.id.save_date_time);
        txtDate = (TextView) findViewById(R.id.dateView);
        txtTime = (TextView) findViewById(R.id.TimeView);
        post=FirebaseDatabase.getInstance().getReference().child("Slots");
    }

    private void save() {

        HashMap<String,Object> map = new HashMap<>();
        map.put("Date",txtDate.getText().toString());
        map.put("Time",txtTime.getText().toString());

        post.push()
                .setValue(map)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Log.i(TAG,"OnComplete");
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.i(TAG,"OnFailure: "+e.toString());
            }
        });
    }

    @Override
    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog


            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }
}
