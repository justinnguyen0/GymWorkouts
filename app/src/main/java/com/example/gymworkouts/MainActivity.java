package com.example.gymworkouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

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

        workouts = FileHelper.readData(this);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                workouts);
        workoutList.setAdapter(adapter);

        addbtn.setOnClickListener(this);
        workoutList.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.add_btn:
                String workoutEntered = workoutsET.getText().toString();
                adapter.add(workoutEntered);
                workoutsET.setText("");

                FileHelper.writeData(workouts, this);

                Toast.makeText( this, "Workout Added", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        workouts.remove(position);
        adapter.notifyDataSetChanged();
        FileHelper.writeData(workouts, this);
        Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
    }
}
