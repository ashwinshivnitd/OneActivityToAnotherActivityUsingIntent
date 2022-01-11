package com.jwhh.oneactivitytoanotheractivityusingintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText enterUserName;
    private EditText enterPassword;
    private Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews(); //Finding views by id
        setupListener();//After finding views,then setting up listener

    }
    //Find Views
    private void findViews(){
        this.enterUserName=this.findViewById(R.id.username);
        this.enterPassword=this.findViewById(R.id.password);
        this.signIn=this.findViewById(R.id.signin);
    }
    //Setup Listeners
    private void setupListener() {

        //Perform Action after clicking on button
        this.signIn.setOnClickListener(view -> {
            String userName = this.enterUserName.getText().toString();
            String password = this.enterPassword.getText().toString();

            //If userName is empty on application
            if (userName.isEmpty()) {
                this.enterUserName.setError("Invalid Username");
                return;
            }

            //If password is empty on application
            if (password.isEmpty()) {
                this.enterPassword.setError("Invalid Password");
                return;
            }

            Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();

            //Switching to Another Activity using Intent
            Intent goToBodyWorkout = new Intent(this, ChooseWorkoutActivity.class);
            this.startActivity(goToBodyWorkout);
        });
    }
}