package com.bignerdranchguide.java.geoquiz;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private static final String TAG = "QuizActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "I am in Create State");

        // Attach Activity to it's UI Layout.
        setContentView(R.layout.activity_quiz);

        // Set Buttons ClickListeners to make them interactive.
        Button mTrueButton = findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this,
                        R.string.correct_toast,
                        Toast.LENGTH_SHORT).show();
            }
        });

        Button mFalseButton = findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this,
                        R.string.incorrect_toast,
                        Toast.LENGTH_SHORT).show();
            }
        });

        Button mCheatButton = findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizActivity.this, CheatActivity.class);
                intent.putExtra(getString(R.string.INTENT_EXTRA_DATA_KEY),true);
                startActivity(intent);
            }
        });
    }

    // Adding Lifecycle callbacks to better understand them using Logcat.
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "I am in Start State");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "I am in Resume State");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "I am in Pause State");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "I am in Stop State");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "I am in Destroy State");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "I am in Restart State");
    }
}
