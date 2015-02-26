package com.armytrainer.anish.armytrainer;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.util.concurrent.TimeUnit.NANOSECONDS;


public class ReviewActivity extends ActionBarActivity {

    private int score;
    private int review_qno;
    private TextView text_Score;
    private TextView text_time_elapsed;
    private long total_time;
    private Button button_review_answers;
    private Button button_retake_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        score = getIntent().getIntExtra("final_Score",0);
        review_qno = getIntent().getIntExtra("review_from_qno",-1);
        total_time = getIntent().getLongExtra("time_elapsed", 0);


        ((Button)findViewById(R.id.button_retake)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(ReviewActivity.this,RulesActivity.class);
                startActivityForResult(m,1);
                ReviewActivity.this.finish();
            }
        });

        ((Button)findViewById(R.id.button_view_answers)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n = new Intent(ReviewActivity.this,AnswerListActivity.class);
                n.putExtra("review_from_qno",review_qno);
                startActivityForResult(n,1);
            }
        });
        ((TextView)findViewById(R.id.text_result_score)).setText(String.valueOf(score));
        ((TextView)findViewById(R.id.text_time_elapsed)).setText(String.valueOf(NANOSECONDS.toSeconds(total_time)));
        //((TextView)findViewById(R.id.text_qno_caption)).setText(String.valueOf(review_qno));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_review, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
