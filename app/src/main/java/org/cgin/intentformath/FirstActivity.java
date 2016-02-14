package org.cgin.intentformath;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void onImplicitButtonClicked(View view){
        //Debug register for the first button
        Log.d("estrella galicia", "implicit method in progress");
    }

    public void onExplicitButtonClicked(View view){
        //Debug register for the second button
        Log.d("estrella galicia", "explicit method in progress");
    }
}
