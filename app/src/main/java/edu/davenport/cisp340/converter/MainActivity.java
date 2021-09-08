package edu.davenport.cisp340.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_INDEX = "index";
    private static int REQUEST_CODE_CLEAR;
    private boolean mClearScreen;
    private static final String TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean REQUEST_CODE_CLEAR = getIntent().getBooleanExtra("REQUEST_CODE_CLEAR",false);

        if (REQUEST_CODE_CLEAR == true){
            clearScreen(true);
        }

        //options button
        Button optionsButton = this.findViewById(R.id.optionsButton);
        optionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start options activity
                Intent intent = new Intent(MainActivity.this, OptionsActivity.class);
                //listen for intent back from options activity
                startActivity(intent);
                Log.d(TAG, "Opening Options Activity");
            }
        });


        Button button = (Button) this.findViewById(R.id.convertButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView mphOutput = findViewById(R.id.knotsOutput);
                EditText knotsInput = findViewById(R.id.knotsInput);
                //get knots input and convert to mph
                float knots = Float.parseFloat(String.valueOf(knotsInput.getText()));
                float mph = (float) (knots * 1.150779);
                mphOutput.setText(String.valueOf(mph));

                //get nautical miles and convert to statue miles
                TextView statuteMilesOutput = findViewById(R.id.nauticalMilesOutput);
                EditText nauticalInput = findViewById(R.id.nauticalMilesInput);
                float nauticalMiles = Float.parseFloat(String.valueOf(nauticalInput.getText()));
                float statuteMiles = (float) (nauticalMiles * 1.15);
                statuteMilesOutput.setText(String.valueOf(statuteMiles));

                //get compass reading reading and convert to reciprocal
                TextView reciprocalOutput = findViewById(R.id.compassHeadingOutput);
                EditText compassInput = findViewById(R.id.compassHeadingInput);
                float compassHeadingInput = Float.parseFloat(String.valueOf(compassInput.getText()));
                //get reciprocal of compass heading and reset to 0 if its invalid value
                if (compassHeadingInput >= 180.00){
                    compassHeadingInput -= 180.00;
                }
                else if (compassHeadingInput < 180.00){
                    compassHeadingInput += 180.00;
                }
                else if (compassHeadingInput < 0){
                    compassHeadingInput = 0;
                }
                else if (compassHeadingInput > 360){
                    compassHeadingInput = 0;
                }
                reciprocalOutput.setText(String.valueOf(compassHeadingInput));

            }
        });



    }
    private void clearScreen(boolean userClearedScreen){
        TextView mphOutput = findViewById(R.id.knotsOutput);
        EditText knotsInput = findViewById(R.id.knotsInput);
        TextView statuteMilesOutput = findViewById(R.id.nauticalMilesOutput);
        EditText nauticalInput = findViewById(R.id.nauticalMilesInput);
        TextView reciprocalOutput = findViewById(R.id.compassHeadingOutput);
        EditText compassInput = findViewById(R.id.compassHeadingInput);

        mphOutput.setText("0");
        knotsInput.setText("");
        statuteMilesOutput.setText("0");
        nauticalInput.setText("");
        reciprocalOutput.setText("0");
        compassInput.setText("");

    }

    //override on start to log starting application
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    //log on resume
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    //log on pause
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    //log on stop
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    //log on destroy
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
}