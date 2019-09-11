package com.bignerdranchguide.java.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.bignerdranchguide.java.geoquiz.Model.Question;

public class QuizListActivity extends AppCompatActivity {

    private Question[] questionBank = new Question[]{
            new Question("The Pacific Ocean is larger than the Atlantic Ocean", true),
            new Question("The source of the Nile River is in Egypt", false),
            new Question("The Suez Canal connects the Red Sea and the Indian Ocean.", false),
            new Question("The Amazon River is the longest river in the Americas.", true),
            new Question("Lake Baikal is the world\'s oldest and deepest freshwater lake.", true)};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list);

        ArrayAdapter<Question> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, questionBank);

        ListView listView = findViewById(R.id.quiz_list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(QuizListActivity.this, QuizActivity.class);
                intent.putExtra("key",questionBank[i]);
                startActivity(intent);
            }
        });

    }
}
