package com.example.codingassignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button createEvent,SlotListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createEvent =(Button)findViewById(R.id.create_event);
        SlotListButton=(Button)findViewById(R.id.slot_list_btn);

        createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DefineSlotsActivitiy.class);
                startActivity(intent);
            }
        });

        SlotListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AvailableSlotCrud.class);
                startActivity(intent);
            }
        });

    }
}
