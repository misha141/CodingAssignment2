package com.example.codingassignment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class AvailableSlotCrud extends AppCompatActivity {

    private FirebaseFirestore firebaseFirestore;
    private RecyclerView slotList;
    private FirestoreRecyclerAdapter adapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_slot_crud);
        firebaseFirestore = FirebaseFirestore.getInstance();
        slotList = findViewById(R.id.recyclerView);

        Query query = firebaseFirestore.collection("Available Slots");
        FirestoreRecyclerOptions<AvailableSlotDetails> options  = new FirestoreRecyclerOptions.Builder<AvailableSlotDetails>()
                .setQuery(query,AvailableSlotDetails.class)
                .build();

        adapter = new FirestoreRecyclerAdapter<AvailableSlotDetails, SlotViewHolder>(options) {
            @NonNull
            @Override
            public SlotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.available_slot_crud_item,parent,false);

                return new SlotViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(SlotViewHolder slotViewHolder, int i, AvailableSlotDetails availableSlotDetails) {
                slotViewHolder.list_date.setText(availableSlotDetails.getDate());
                slotViewHolder.list_time.setText(availableSlotDetails.getTime());


            }



        };
        slotList.setHasFixedSize(true);
        slotList.setLayoutManager(new LinearLayoutManager(this));
        slotList.setAdapter(adapter);



    }

    private class SlotViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView list_date;
        private TextView list_time;
        Button deleteButton ;
        Button updateButton;

        public SlotViewHolder(@NonNull View itemView) {
            super(itemView);

            list_date  = itemView.findViewById(R.id.avc_date);
            list_time = itemView.findViewById(R.id.avc_time);
            deleteButton = findViewById(R.id.avc_delete);
            updateButton = findViewById(R.id.avc_update);

            deleteButton

        }


        @Override
        public void onClick(View v) {

        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

}
