package com.spawrks.savingstuff;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;

public class MainActivity extends Activity {

    static final String PREFRENCES = "mySavingStuff";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences savedPreferences = getSharedPreferences(PREFRENCES,0);
        String savedString = savedPreferences.getString("myLastString","nothingSavedYet");

        EditText e = (EditText)findViewById(R.id.littleText);
        e.setText(savedString);

    }

    @Override
    protected void onStop() {
        super.onStop();

        EditText e = (EditText)findViewById(R.id.littleText);
        String currentString = e.getText().toString();

        SharedPreferences savedPreferences = getSharedPreferences(PREFRENCES,0);
        SharedPreferences.Editor editor = savedPreferences.edit();

        editor.putString("myLastString",currentString);
        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
