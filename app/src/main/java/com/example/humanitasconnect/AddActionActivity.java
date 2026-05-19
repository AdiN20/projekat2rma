package com.example.humanitasconnect;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddActionActivity extends AppCompatActivity {

    private EditText etTitle, etDescription, etTarget;
    private Button btnSubmitAction;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_action);

        etTitle = findViewById(R.id.etTitle);
        etDescription = findViewById(R.id.etDescription);
        etTarget = findViewById(R.id.etTarget);
        btnSubmitAction = findViewById(R.id.btnSubmitAction);

        databaseReference = FirebaseDatabase.getInstance().getReference("humanitarna_pomoc");

        btnSubmitAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString().trim();
                String description = etDescription.getText().toString().trim();
                String target = etTarget.getText().toString().trim();

                if (title.isEmpty() || description.isEmpty() || target.isEmpty()) {
                    Toast.makeText(AddActionActivity.this, "Molimo popunite sva polja", Toast.LENGTH_SHORT).show();
                    return;
                }

                String id = databaseReference.push().getKey();
                ActionModel action = new ActionModel(title, description, target);

                if (id != null) {
                    databaseReference.child(id).setValue(action)
                            .addOnCompleteListener(task -> {
                                if (task.isSuccessful()) {
                                    Toast.makeText(AddActionActivity.this, "Akcija uspješno objavljena!", Toast.LENGTH_SHORT).show();
                                    finish(); // Zatvara prozor i vraća na Home
                                } else {
                                    Toast.makeText(AddActionActivity.this, "Greška pri objavi", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
        });
    }
}