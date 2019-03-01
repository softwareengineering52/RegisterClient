package edu.uark.uarkregisterapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import edu.uark.uarkregisterapp.models.transition.ProductTransition;

public class EmployeeLoginActivity extends AppCompatActivity {
    @Override
    //if (function to check for existing ermployee) is false, make a new employee, else:
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
    }

    public void loginButtonOnClick(View view) {
        this.startActivity(new Intent(getApplicationContext(), MainMenuActivity.class));
    }
}