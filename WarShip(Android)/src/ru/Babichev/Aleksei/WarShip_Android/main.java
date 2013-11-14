package ru.Babichev.Aleksei.WarShip_Android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class main extends Activity {

    Button startButton;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onStartClick(View view){
        Intent intent = new Intent(this, GameActivty.class);
        startActivity(intent);
    }
}
