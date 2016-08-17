package com.leihan.lockwindow;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final KeyguardManager km = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (km.inKeyguardRestrictedInputMode()) {
                            Intent alarmIntent = new Intent(MainActivity.this, LockActivity.class);
                            alarmIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(alarmIntent);
                            finish();
                        }
                    }
                }, 4000);

            }
        });

    }
}
