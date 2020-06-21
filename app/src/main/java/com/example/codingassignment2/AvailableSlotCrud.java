package com.example.codingassignment2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class AvailableSlotCrud extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SlotAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_slot_crud);

        recyclerView= findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<AvailableSlotDetails> options =
                new FirebaseRecyclerOptions.Builder<AvailableSlotDetails>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Slots"),AvailableSlotDetails.class)
                .build();

        adapter = new SlotAdapter(options,this);
        recyclerView.setAdapter(adapter);

       }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
