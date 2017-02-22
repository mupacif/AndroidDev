package be.formation.intentapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChildActivity extends AppCompatActivity {

    private ToDoApplication app;
    private EditText etChildItem;
    private Button btnChildAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        app = (ToDoApplication) getApplication();

        etChildItem = (EditText) findViewById(R.id.et_child_item);
        btnChildAdd = (Button) findViewById(R.id.btn_child_add);

        btnChildAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.addToDoItem(etChildItem.getText().toString());
                finish();
            }
        });
    }
}
