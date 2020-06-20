package com.example.codingassignment2;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;

public class DefineSlotsActivitiy extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";

    private static final String KEY_DATE= "Date";
    private static final String KEY_TIME = "Time";

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference availableSlotref = db.collection("Available Slots");
    private DocumentReference slotref = db.document("Available Slots/Slot details");



    Button btnDatePicker, btnTimePicker,saveDateTime;
    TextView txtDate, txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_define_slots_activitiy);

        btnDatePicker = (Button) findViewById(R.id.choose_date);
        btnTimePicker = (Button) findViewById(R.id.choose_time);
        saveDateTime = (Button)findViewById(R.id.save_date_time);
        txtDate = (TextView) findViewById(R.id.dateView);
        txtTime = (TextView) findViewById(R.id.TimeView);

        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);
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

    public void saveNote(View v){

        String Date = txtDate.getText().toString();
        String time = txtTime.getText().toString();

        AvailableSlotDetails slots = new AvailableSlotDetails(Date,time);

        availableSlotref.add(slots);
    }
}
