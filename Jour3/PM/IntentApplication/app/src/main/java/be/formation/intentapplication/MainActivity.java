package be.formation.intentapplication;

import android.content.Intent;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ToDoApplication app;
    private Button btnMainAdd;
    private ListView lvMainList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        app = (ToDoApplication) getApplication();

        btnMainAdd = (Button) findViewById(R.id.btn_main_add);
        lvMainList = (ListView) findViewById(R.id.lv_main_list);

        btnMainAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toNext = new Intent(MainActivity.this, ChildActivity.class);
                startActivity(toNext);
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                app.getToDoList()
        );

        lvMainList.setAdapter(adapter);

        lvMainList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String toDoItem = ((TextView) view).getText().toString();
                Toast.makeText(app, toDoItem, Toast.LENGTH_SHORT).show();
            }
        });

        lvMainList.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String toDoItem = ((TextView) view).getText().toString();
                app.getToDoList().remove(toDoItem);
                ((ArrayAdapter)lvMainList.getAdapter()).notifyDataSetChanged();
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayAdapter adapter = (ArrayAdapter) lvMainList.getAdapter();
        adapter.notifyDataSetChanged();
    }
}
