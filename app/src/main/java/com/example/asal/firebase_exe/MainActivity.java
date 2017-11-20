package com.example.asal.firebase_exe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    TextView mTextView;
    Button mButtonDounut,mButtonNougut;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mConditionRef = mRootRef.child("Condition");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView)findViewById(R.id.textViewCondition);
      mButtonNougut = (Button)findViewById(R.id.btnNougut);
        mButtonDounut = (Button)findViewById(R.id.btnDounut);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mConditionRef.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {

                String text = dataSnapshot.getValue(String.class);
                mTextView.setText(text);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    public void dounut(View view) {
        mConditionRef.setValue("Dounut");

    }

    public void nougut(View view) {
        mConditionRef.setValue("Nougat");
    }
}
