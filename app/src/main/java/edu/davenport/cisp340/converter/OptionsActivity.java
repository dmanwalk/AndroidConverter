package edu.davenport.cisp340.converter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class OptionsActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_CLEAR = 0;
    boolean clearScreenPressed = false;
    private static final String TAG = "OptionsActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

    //set clear screen button
        Button mClearScreen = (Button) this.findViewById(R.id.clearButton);
        mClearScreen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                clearScreenPressed = true;
                setClearedScreenResult(clearScreenPressed);

            }
        });


    // set on click build alert dialog
        Button mAboutButton = (Button) this.findViewById(R.id.aboutButton);
        mAboutButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //create alert dialog object
          AlertDialog.Builder builder
                  = new AlertDialog
                  .Builder(OptionsActivity.this);
                // Set the message with string res
                builder.setMessage(getString(R.string.dialog_text));

                // Set Alert Title with resource string
                builder.setTitle(getString(R.string.about));
                //set positive button with name
                builder
                        .setPositiveButton(//set button name with string res
                                getString(R.string.pretty_neatButton),
                                new DialogInterface
                                        .OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which)
                                    {

                                        // When the user click yes button
                                        //it will be logged and nothing will happen
                                        Log.d(TAG, "onPause() called");
                                        dialog.cancel();
                                    }
                                });
                // Set the Negative button with No name
                // OnClickListener method is use
                // of DialogInterface interface.
                builder
                        .setNegativeButton(
                                getString(R.string.not_neatButton),
                                new DialogInterface
                                        .OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which)
                                    {

                                        // If user click no
                                        // then the app will close
                                        finish();

                                    }
                                });
                //put together all pieces of the dialog made with the builder.
                AlertDialog alertDialog = builder.create();

                // Show the Alert Dialog box
                alertDialog.show();
            }
        });

    }
    private void setClearedScreenResult(boolean clearScreenPressed) {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        //send boolean extra to MainActivity.class
        intent.putExtra("REQUEST_CODE_CLEAR", clearScreenPressed);
        //start Main activity and send extra
        startActivity(intent);
    }



}
