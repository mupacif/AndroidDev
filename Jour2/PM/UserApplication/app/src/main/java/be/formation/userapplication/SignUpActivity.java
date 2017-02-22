package be.formation.userapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Checked;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.mobsandgeeks.saripaar.annotation.Past;
import com.mobsandgeeks.saripaar.annotation.ValidateUsing;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import be.formation.userapplication.model.Sex;
import be.formation.userapplication.model.User;

public class SignUpActivity extends AppCompatActivity implements Validator.ValidationListener {

    private final String TAG = getClass().getSimpleName();

    @NotEmpty
    @Email
    private EditText etSignupEmail;

    @NotEmpty
    @Password
    private EditText etSignupPassword;

    @NotEmpty
    @ConfirmPassword
    private EditText etSignupCheck;

    @NotEmpty
    private EditText etSignupFirstname;

    @NotEmpty
    private EditText etSignupLastname;

    private EditText etSignupPhone;

    private DatePicker dpSignupDateofbirth;

    private RadioGroup rgSignupSex;
    private RadioButton rbSignupMan;
    private RadioButton rbSignupWoman;

    @Checked
    private CheckBox cbSignupTerms;

    private Button btnSignupSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final Validator validator = new Validator(this);
        validator.setValidationListener(this);

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
                validator.validate();
            }
        });
    }

    @Override
    public void onValidationSucceeded() {

        Toast.makeText(this, "Success !", Toast.LENGTH_SHORT).show();

        String email = etSignupEmail.getText().toString();
        String password = etSignupPassword.getText().toString();
        String firstName = etSignupFirstname.getText().toString();
        String lastName = etSignupLastname.getText().toString();
        String phoneNumber = etSignupPhone.getText().toString();

        Calendar c = Calendar.getInstance();
        c.set(dpSignupDateofbirth.getYear(),
                dpSignupDateofbirth.getMonth(),
                dpSignupDateofbirth.getDayOfMonth());
        Date dateOfBirth = c.getTime();

        Sex sex = null;
        switch (rgSignupSex.getCheckedRadioButtonId()) {
            case R.id.rb_signup_man:
                sex = Sex.MAN;
                break;
            case R.id.rb_signup_woman:
                sex = Sex.WOMAN;
                break;
        }

        User u = new User(email, password, lastName, firstName, phoneNumber, sex, dateOfBirth);
        Log.i(TAG, u.toString());
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {

        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
