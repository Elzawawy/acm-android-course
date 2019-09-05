package com.bignerdranchguide.java.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    // Note: We use static keyword only on constants which we declare the same for all instances.
    private static final String TAG = "QuizActivity";
    private static final int CHEAT_REQUEST_CODE = 0;
    private Boolean mIsCheater = false;

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
                if(mIsCheater)
                    Toast.makeText(QuizActivity.this,
                            R.string.cheater_toast,
                            Toast.LENGTH_SHORT).show();
                else
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
                intent.putExtra(getString(R.string.INTENT_EXTRA_DATA_KEY), true);
                startActivityForResult(intent,CHEAT_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // Check if everything is in order. If not, why stay ?
        if(resultCode != Activity.RESULT_OK)
            return;
        // Check if this is my intended child activity.
        if(requestCode == CHEAT_REQUEST_CODE){
            // Check if there is a data. If not, why stay ?
            if(data == null)
                return;
            // Extract the value from data into our member variable.
            mIsCheater = data.getBooleanExtra(getString(R.string.INTENT_CHEAT_KEY),false);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        // Pack this current value in my bundle when i leave please.
        outState.putBoolean(getString(R.string.CHEAT_INSTANCE_STATE_KEY),mIsCheater);
        // Let the Default implementation do what it does best to other views.
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState) {
        // Let the Default implementation do what it does best to other views.
        super.onRestoreInstanceState(savedInstanceState);
        // Extract the last saved value when i come back again please.
        mIsCheater = savedInstanceState.getBoolean(getString(R.string.CHEAT_INSTANCE_STATE_KEY));
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
