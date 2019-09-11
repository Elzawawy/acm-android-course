package com.bignerdranchguide.java.geoquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.bignerdranchguide.java.geoquiz.Model.Question;

public class QuizRecyclerActivity extends AppCompatActivity {

    private Question[] questionBank = new Question[]{
            new Question("The Pacific Ocean is larger than the Atlantic Ocean", true),
            new Question("The source of the Nile River is in Egypt", false),
            new Question("The Suez Canal connects the Red Sea and the Indian Ocean.", false),
            new Question("The Amazon River is the longest river in the Americas.", true),
            new Question("Lake Baikal is the world\'s oldest and deepest freshwater lake.", true)};

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_recycler);

        recyclerView = findViewById(R.id.quiz_recycler_view);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new QuizAdapter(questionBank);
        recyclerView.setAdapter(mAdapter);
    }


}
