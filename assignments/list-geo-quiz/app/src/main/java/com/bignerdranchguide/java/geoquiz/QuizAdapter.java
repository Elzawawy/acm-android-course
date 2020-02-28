package com.bignerdranchguide.java.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bignerdranchguide.java.geoquiz.Model.Question;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizViewHolder> {

    private Question[] mData;
    private Context mContext;

    QuizAdapter(Question[] data) {
        mData = data;
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new QuizViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_quiz, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {
        holder.bindData(mData[position]);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    class QuizViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView questionTextView;
        Question question;

        QuizViewHolder(@NonNull View itemView) {
            super(itemView);
            questionTextView = itemView.findViewById(R.id.quiz_item_text);
        }

        void bindData(Question item) {
            question = item;
            questionTextView.setText(question.getQuestionText());
            questionTextView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, QuizActivity.class);
            intent.putExtra("key", question);
            mContext.startActivity(intent);
        }
    }
}
