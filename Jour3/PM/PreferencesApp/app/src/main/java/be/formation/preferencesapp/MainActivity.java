package be.formation.preferencesapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etMainEmail;
    private EditText etMainPassword;
    private CheckBox cbMainRememberme;
    private Button btnMainSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMainEmail = (EditText) findViewById(R.id.et_main_email);
        etMainPassword = (EditText) findViewById(R.id.et_main_password);
        cbMainRememberme = (CheckBox) findViewById(R.id.cb_main_rememberme);
        btnMainSubmit = (Button) findViewById(R.id.btn_main_submit);

        btnMainSubmit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor editor = prefs.edit();

                if (cbMainRememberme.isChecked()) {
                    editor.putString("email", etMainEmail.getText().toString());
                    editor.putString("password", etMainPassword.getText().toString());
                    editor.putBoolean("remember_me", true);
                } else {
                    editor.clear();
                }
                editor.apply();
            }
        });

        loadInfo();
    }

    private void loadInfo() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        etMainEmail.setText(prefs.getString("email", ""));
        etMainPassword.setText(prefs.getString("password", ""));
        cbMainRememberme.setChecked(prefs.getBoolean("remember_me", false));
    }
}
