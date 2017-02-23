package be.formation.fileapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private final String FILENAME = "data.dat";

    private EditText etMainContent;
    private Button btnMainSave;
    private Button btnMainLoad;
    private Button btnMainDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMainContent = (EditText) findViewById(R.id.et_main_content);
        btnMainSave = (Button) findViewById(R.id.btn_main_save);
        btnMainLoad = (Button) findViewById(R.id.btn_main_load);
        btnMainDelete = (Button) findViewById(R.id.btn_main_delete);

        btnMainSave.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFile(FILENAME);
            }
        });

        btnMainLoad.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFile(FILENAME);
            }
        });

        btnMainDelete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteFile(FILENAME);
            }
        });
    }

    private void saveFile(String filename) {

        try {
            FileOutputStream fos = openFileOutput(filename, MODE_PRIVATE);
            fos.write(etMainContent.getText().toString().getBytes());
            fos.close();
        } catch (IOException e) {
            Log.e("MainActivity", e.getClass().getSimpleName() + " : " + e.getMessage());
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void loadFile(String filename) {

        try {
            FileInputStream fis = openFileInput(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
            fis.close();

            Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Log.e("MainActivity", e.getClass().getSimpleName() + " : " + e.getMessage());
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
