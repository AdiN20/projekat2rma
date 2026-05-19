package com.example.humanitasconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rvActions;
    private ActionAdapter adapter;
    private List<ActionModel> actionList;
    private DatabaseReference databaseReference;
    private FloatingActionButton fabAddAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rvActions = findViewById(R.id.rvActions);
        rvActions.setLayoutManager(new LinearLayoutManager(this));

        actionList = new ArrayList<>();
        adapter = new ActionAdapter(actionList);
        rvActions.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("humanitarna_pomoc");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                actionList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ActionModel action = dataSnapshot.getValue(ActionModel.class);
                    if (action != null) {
                        actionList.add(action);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(HomeActivity.this, "Greška pri učitavanju: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        fabAddAction = findViewById(R.id.fabAddAction);
        fabAddAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AddActionActivity.class);
                startActivity(intent);
            }
        });
    }
}