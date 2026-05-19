package com.example.humanitasconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
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

    private LinearLayout layoutEmptyState;
    private SearchView searchView;
    private Toolbar toolbarHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        toolbarHome = findViewById(R.id.toolbarHome);
        setSupportActionBar(toolbarHome);


        rvActions = findViewById(R.id.rvActions);
        layoutEmptyState = findViewById(R.id.layoutEmptyState);
        searchView = findViewById(R.id.searchView);
        fabAddAction = findViewById(R.id.fabAddAction);

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

                if (actionList.isEmpty()) {
                    layoutEmptyState.setVisibility(View.VISIBLE);
                    rvActions.setVisibility(View.GONE);
                } else {
                    layoutEmptyState.setVisibility(View.GONE);
                    rvActions.setVisibility(View.VISIBLE);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(HomeActivity.this, "Greška pri učitavanju: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });

        fabAddAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AddActionActivity.class);
                startActivity(intent);
            }
        });
    }

    private void filter(String text) {
        List<ActionModel> filteredList = new ArrayList<>();
        for (ActionModel item : actionList) {
            if (item.getTitle().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        if (filteredList.isEmpty()) {
            layoutEmptyState.setVisibility(View.VISIBLE);
        } else {
            layoutEmptyState.setVisibility(View.GONE);
        }
        adapter.filterList(filteredList);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull android.view.MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_profile) {
            Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_settings) {
            Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}