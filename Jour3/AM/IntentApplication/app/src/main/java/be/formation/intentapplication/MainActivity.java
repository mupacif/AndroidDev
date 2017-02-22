package be.formation.intentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ToDoApplication app;
    private Button btnMainAdd;
    private TextView tvMainList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        app = (ToDoApplication) getApplication();

        btnMainAdd = (Button) findViewById(R.id.btn_main_add);
        tvMainList = (TextView) findViewById(R.id.tv_main_list);

        btnMainAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toNext = new Intent(MainActivity.this, ChildActivity.class);
                startActivity(toNext);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        String s = app.getAllItemsAsString();
        tvMainList.setText(s);
    }
}
