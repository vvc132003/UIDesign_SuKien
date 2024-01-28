package org.chinh.baitapmoblile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private TextInputLayout textInputEmail, textInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_login);

        // Initialize views
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        textInputEmail = findViewById(R.id.textInputEmail);
        textInputPassword = findViewById(R.id.textInputPassword);

        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Call your login method
                performLogin();
            }
        });
    }

    private void performLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        if (validateEmail(email) && validatePassword(password)) {
            if (isLoginSuccessful(email, password)) {
                showSuccessDialog();
            } else {
                showSerrDialog();
            }
        }
    }

    private boolean validateEmail(String email) {
        if (email.isEmpty()) {
            textInputEmail.setError("Email is required");
            return false;
        } else {
            textInputEmail.setError(null);
            return true;
        }
    }

    private boolean validatePassword(String password) {
        if (password.isEmpty()) {
            textInputPassword.setError("Password is required");
            return false;
        } else {
            textInputPassword.setError(null);
            return true;
        }
    }
    private boolean isLoginSuccessful(String email, String password) {
        return email.equals("chinhvovan13@gmail.com") && password.equals("123");
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void showSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_login_success, null);
        builder.setView(dialogView);
        final AlertDialog dialog = builder.create();
        TextView textViewDialogTitle = dialogView.findViewById(R.id.textViewDialogTitle);
        textViewDialogTitle.setText("Login Successful");
        dialog.getWindow().getAttributes().windowAnimations = R.style.SlideInTopAnimation;
        dialog.show();
    }
    private void showSerrDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_login_err, null);
        builder.setView(dialogView);
        final AlertDialog dialog = builder.create();
        TextView textViewDialogTitle = dialogView.findViewById(R.id.textViewDialogTitle);
        textViewDialogTitle.setText("Email hoặc mật khẩu sai");
        dialog.getWindow().getAttributes().windowAnimations = R.style.SlideInTopAnimation;
        dialog.show();
    }
}