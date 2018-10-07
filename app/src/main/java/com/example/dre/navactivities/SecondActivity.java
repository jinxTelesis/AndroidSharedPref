package com.example.dre.navactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView showMessage;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        backButton = (Button) findViewById(R.id.backBtnID);

        Bundle extras = getIntent().getExtras();

        showMessage = (TextView) findViewById(R.id.secTextViewID); // message text view

        // check
        if(extras != null){
            String message = extras.getString("Message");
            int myInt = extras.getInt("Value");


            showMessage.setText(message + message + " and " + String.valueOf(myInt));
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // code goes here
                Intent returnIntent = getIntent();
                returnIntent.putExtra("returnData", "From SecondActivity");
                setResult(RESULT_OK,returnIntent);
                finish(); // gets rid of the activity clean slate
            }
        });
    }
}
