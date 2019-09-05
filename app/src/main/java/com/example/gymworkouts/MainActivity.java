package com.example.gymworkouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText workoutsET;
    private Button btn;
    private Button addbtn;
    private ListView workoutList;

    private ArrayList<String> workouts;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workoutsET = findViewById(R.id.workouts_edit_text);
        btn = findViewById(R.id.timer);
        addbtn = findViewById(R.id.add_btn);
        workoutList = findViewById(R.id.workout_list);

        addbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.add_btn:
                String workoutEntered = workoutsET.getText().toString();
                adapter.add(workoutEntered);
                workoutsET.setText("");

                Toast.makeText( this, "Workout Added", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
