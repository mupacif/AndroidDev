package be.formation.userapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SignUpActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();

    private EditText etSignupEmail;
    private EditText etSignupPassword;
    private EditText etSignupCheck;
    private EditText etSignupFirstname;
    private EditText etSignupLastname;
    private EditText etSignupPhone;
    private DatePicker dpSignupDateofbirth;
    private RadioGroup rgSignupSex;
    private RadioButton rbSignupMan;
    private RadioButton rbSignupWoman;
    private CheckBox cbSignupTerms;
    private Button btnSignupSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etSignupEmail = (EditText) findViewById(R.id.et_signup_email);
        etSignupPassword = (EditText) findViewById(R.id.et_signup_password);
        etSignupCheck = (EditText) findViewById(R.id.et_signup_check);
        etSignupFirstname = (EditText) findViewById(R.id.et_signup_firstname);
        etSignupLastname = (EditText) findViewById(R.id.et_signup_lastname);
        etSignupPhone = (EditText) findViewById(R.id.et_signup_phone);
        dpSignupDateofbirth = (DatePicker) findViewById(R.id.dp_signup_dateofbirth);
        rgSignupSex = (RadioGroup) findViewById(R.id.rg_signup_sex);
        rbSignupMan = (RadioButton) findViewById(R.id.rb_signup_man);
        rbSignupWoman = (RadioButton) findViewById(R.id.rb_signup_woman);
        cbSignupTerms = (CheckBox) findViewById(R.id.cb_signup_terms);
        btnSignupSubmit = (Button) findViewById(R.id.btn_signup_submit);

        btnSignupSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Click !");
                Log.i(TAG, "Email " + etSignupEmail.getText());
                Log.i(TAG, "Password : " + etSignupPassword.getText());
                Log.i(TAG, "Check : " + etSignupCheck.getText());
                Log.i(TAG, "First name : " + etSignupFirstname.getText());
                Log.i(TAG, "Last name : " + etSignupLastname.getText());
                Log.i(TAG, "Phone number : " + etSignupPhone.getText());
                String d = dpSignupDateofbirth.getDayOfMonth() + "/"
                        + (dpSignupDateofbirth.getMonth() + 1) + "/"
                        + dpSignupDateofbirth.getYear();
                Log.i(TAG, "Date of birth : " + d);

                String sex = "";
                switch (rgSignupSex.getCheckedRadioButtonId()) {
                    case R.id.rb_signup_man:
                        sex = "Man";
                        break;
                    case R.id.rb_signup_woman:
                        sex = "Woman";
                        break;
                }
                Log.i(TAG, "Sex : " + sex);

                Log.i(TAG, "Terms of use : "
                        + (cbSignupTerms.isChecked() ? "Agreed" : "Refused"));
            }
        });
    }
}
