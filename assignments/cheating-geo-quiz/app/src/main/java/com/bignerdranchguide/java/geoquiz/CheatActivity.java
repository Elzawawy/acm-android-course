package com.bignerdranchguide.java.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class CheatActivity extends AppCompatActivity {

    private Boolean mAnswer;
    private static final String TAG = "CheatActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "I am in Create State");

        // Attach Activity to it's UI Layout.
        setContentView(R.layout.activity_cheat);

        // Get the passed Boolean Variable Answer.
        mAnswer = getIntent().getBooleanExtra(getString(R.string.INTENT_EXTRA_DATA_KEY),false);
    }

    // Adding OnClickListener to Button in a different way than QuizActivity.
    public void showAnswer(View view) {
        Toast.makeText(this,getString(R.string.answer_title)+mAnswer.toString(),Toast.LENGTH_SHORT).show();
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
