package edu.uark.uarkregisterapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

//import edu.uark.uarkregisterapp.models.transition.ProductTransition;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginscreen);
    }

    public void loginButtonOnClick(View view) {
        this.startActivity(new Intent(getApplicationContext(), HomeActivity.class));
    }
    public void createemployeeButtonOnClick(View view) {
        this.startActivity(new Intent(getApplicationContext(), createnewemployee.class));
    }

}
