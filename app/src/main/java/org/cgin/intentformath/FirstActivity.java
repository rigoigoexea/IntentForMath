package org.cgin.intentformath;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }
    //----------------------------------------------------------------------------------------------
    // Intent Explicit
    //----------------------------------------------------------------------------------------------

    public void onExplicitButtonClicked(View view){
        //Debug register for the second button
        Log.d("estrella galicia", "explicit method in progress");
        //Create an object intent assigned to the SecondActivity
        Intent intentCall = new Intent(this, SecondActivity.class);
        //Throw the intent to android, and run the SecondActivity
        startActivityForResult(intentCall, 31415);
        //Debug register for throw the second activity
        Log.d("estrella galicia", "thrown SecondActivity");
    }

    //----------------------------------------------------------------------------------------------
    //  Intent implicit
    //----------------------------------------------------------------------------------------------

    public void onImplicitButtonClicked(View view){
        //Debug register for the first button
        Log.d("estrella galicia", "implicit method in progress");
    }

    //----------------------------------------------------------------------------------------------
    //  Catch the data when the SecondActivity ends
    //----------------------------------------------------------------------------------------------

    protected void onActivityResult(int requestCode, int resultCode, Intent intentRespuesta)
    {
        if (requestCode == 31415) //the ID from startActivityForResult(nameIntent,ID)
        {

            if (resultCode==RESULT_CANCELED){
                //Debug message to know that there isn't any value on the intent
                Log.d("estrella galicia", "Recived str to the FirstActivity is cancelled " );
            }

            if(resultCode==RESULT_OK) {

                //get the extra info from the intent and save it into a String
                String calculatedStr = intentRespuesta.getExtras().getString("Valor");

                Log.d("estrella galicia", "Recived str to the FirstActivity is " + calculatedStr);

                //Create a TextView object to show the text complement of the result
                View showText = findViewById(R.id.textView2);
                //Make the text visible
                showText.setVisibility(View.VISIBLE);
                //Create a field to put the result
                EditText messageView = (EditText) findViewById(R.id.editText3);
                //Make it visible
                messageView.setVisibility(View.VISIBLE);
                //Set the given result on the field
                messageView.setText(calculatedStr);
            }
        }
    }
}
