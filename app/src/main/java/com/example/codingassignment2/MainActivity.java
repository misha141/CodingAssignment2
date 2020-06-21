package com.example.codingassignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    private FirebaseAuth firebaseAuth;


    Button createEvent,SlotListButton;
    TextView UserName;
    TextView emailId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createEvent =(Button)findViewById(R.id.create_event);
        SlotListButton=(Button)findViewById(R.id.slot_list_btn);
        UserName = findViewById(R.id.user_name);
        emailId = findViewById(R.id.user_email);

        UserName.setText("Misha Kumari");
        emailId.setText("mishasingh141");

        firebaseAuth = FirebaseAuth.getInstance();

        createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser currentUser = firebaseAuth.getCurrentUser();
                if(currentUser == null){
                    Toast.makeText(MainActivity.this, "Sorry! you need to login before Defining Slots", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MainActivity.this, DefineSlotsActivitiy.class);
                    startActivity(intent);
                }
            }
        });

        SlotListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser currentUser = firebaseAuth.getCurrentUser();
                if(currentUser == null){
                    Toast.makeText(MainActivity.this, "Sorry! you need to login before Defining Slots", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MainActivity.this, AvailableSlotCrud.class);
                    startActivity(intent);
                }
            }
        });

    }

}
