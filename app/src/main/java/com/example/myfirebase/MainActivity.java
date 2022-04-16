package com.example.myfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private FirebaseDatabase mDatabase;
    private DatabaseReference dbRef;

    private static final String TAG = "MyActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World000!");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });




        mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef1 = mDatabase.getReference("MedoDB");
        myRef1.setValue("Hello from home");

        dbRef = FirebaseDatabase.getInstance().getReference("OtherRef");
        dbRef.setValue("one line db Ref");
        dbRef.setValue("2nd line db Ref");
        dbRef.child("user").setValue("1st child");
        dbRef.child("user2").setValue("2nd child");
        dbRef.setValue("Last line db");
        myRef1.setValue("hello again");







        }


}