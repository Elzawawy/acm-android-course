package com.bignerdranchguide.java.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        mAnswer = getIntent().getBooleanExtra(getString(R.string.INTENT_EXTRA_DATA_KEY), false);
    }

    // Adding OnClickListener to Button in a different way than QuizActivity.
    public void showAnswer(View view) {

        // Pass the information. This guy is a cheater !
        setAnswerShownResult();
        // Show them the answer anyway.
        Toast.makeText(this, getString(R.string.answer_title) + mAnswer.toString(), Toast.LENGTH_SHORT).show();
    }

    private void setAnswerShownResult() {
        // Create a new message Intent body.
        Intent data = new Intent();
        // Put the required information in it.
        data.putExtra(getString(R.string.INTENT_CHEAT_KEY), true);
        // Set your results ready to pick up by parent.
        setResult(RESULT_OK, data);
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
