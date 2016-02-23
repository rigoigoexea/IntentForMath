package org.cgin.intentformath;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }

    //----------------------------------------------------------------------------------------------
    // Normal case button "calculate" pressed
    //----------------------------------------------------------------------------------------------

    public void onCalculateButtonClicked (View view){

        //Debug register for the calculate button
        Log.d("estrella galicia", "calculate button method in progress");

        //Get the objects associated to the two EditText fields
        EditText messageView = (EditText) findViewById(R.id.editText);
        EditText message2View = (EditText) findViewById(R.id.editText2);

        //Get the text from the editable text fields, using the previous objects
        String firstStr = messageView.getText().toString();
        String secondStr = message2View.getText().toString();

        //for case the input vaule is null set a default 0 on the fisrtStr
        if(firstStr.isEmpty()){
            firstStr="0";
        }

        //for case the input vaule is null set a default 0 on the secondStr
        if(secondStr.isEmpty()){
            secondStr="0";
        }

        //Show the string procedent from the text fields in the debug console
        Log.d("estrella galicia", "firstStr is " + firstStr);
        Log.d("estrella galicia", "secondStr is " + secondStr);

        //Convert the string into an int
        int firstNum = Integer.parseInt(firstStr);
        int secondNum = Integer.parseInt(secondStr);

        //Make the operation with int
        int calculatedNum = firstNum + secondNum;

        //Convert the int into a string again to return it to the first activity
        String calculatedStr = String.valueOf(calculatedNum);

        //Show the calculated string on the debug console before send to the first activity
        Log.d("estrella galicia", "The calculatedStr is " + calculatedStr);

        //Create a new intent to rturn the result
        Intent intentResult = new Intent();
        //Put  the extra info on the intent
        intentResult.putExtra("Valor",calculatedStr);
        //Define the requestCode for the method onActivityResult
        setResult(RESULT_OK, intentResult);
        //The activity has already done his job and ends
        finish();

    }
    //----------------------------------------------------------------------------------------------
    //  In case of press the back button
    //----------------------------------------------------------------------------------------------

    @Override //Needs override the previous code
    public void onBackPressed(){
        //Create the intent to return FirstActivity
        Intent returnIntent = new Intent();
        //Define the requestCode in mode canceled for the method onActivityResult
        setResult(RESULT_CANCELED, returnIntent);
        //The activity ends without any info added to the intent
        finish();

    }
}
