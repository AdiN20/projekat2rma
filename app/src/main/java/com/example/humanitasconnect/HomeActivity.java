package com.example.humanitasconnect;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rvActions;
    private ActionAdapter adapter;
    private List<ActionModel> actionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rvActions = findViewById(R.id.rvActions);
        rvActions.setLayoutManager(new LinearLayoutManager(this));

        actionList = new ArrayList<>();


        actionList.add(new ActionModel("Pomoć za narodne kuhinje", "Prikupljanje osnovnih životnih namirnica za socijalno ugrožene porodice.", "3000"));
        actionList.add(new ActionModel("Liječenje u inostranstvu", "Hitna finansijska sredstva potrebna za operaciju i liječenje pacijenta.", "15000"));
        actionList.add(new ActionModel("Stipendije za studente", "Podrška talentovanim studentima slabijeg imovinskog stanja za nastavak školovanja.", "5000"));

        adapter = new ActionAdapter(actionList);
        rvActions.setAdapter(adapter);
    }
}