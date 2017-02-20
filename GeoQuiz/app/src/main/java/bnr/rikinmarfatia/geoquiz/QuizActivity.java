package bnr.rikinmarfatia.geoquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";

    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private TextView questionTextView;
    private int currentIndex = 0;

    private final Question[] questions = new Question[] {
            new Question(R.string.question_americas, true),
            new Question(R.string.question_memes, false),
            new Question(R.string.question_oceans, true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "In onCreate(bundle)");
        setContentView(R.layout.activity_quiz);

        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt(KEY_INDEX);
        }

        questionTextView = (TextView) findViewById(R.id.question_txtview);
        setQuestion();

        trueButton = (Button) findViewById(R.id.true_btn);
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        falseButton = (Button) findViewById(R.id.false_btn);
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        nextButton = (Button) findViewById(R.id.next_btn);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex + 1) % questions.length;
                setQuestion();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "In onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "In onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "In onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "In onStop()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "In onSaveInstanceState(bundle)");
        outState.putInt(KEY_INDEX, currentIndex);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "In onDestroy()");
    }

    private void setQuestion() {
        int question = questions[currentIndex].getQuestionTextResId();
        questionTextView.setText(question);
    }

    private void checkAnswer(boolean pressedTrue) {
        boolean answerTrue = questions[currentIndex].isAnswerTrue();
        int messageResId;

        if (pressedTrue && answerTrue || !pressedTrue && !answerTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }
}
