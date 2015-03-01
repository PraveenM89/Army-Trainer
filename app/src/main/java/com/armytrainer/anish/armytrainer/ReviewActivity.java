package com.armytrainer.anish.armytrainer;
//1545362515737768
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
//ga0RGNYHvNM5d0SLGQfpQWAPGJ8=
import android.widget.Button;
import android.widget.TextView;

import com.facebook.Session;

import static java.util.concurrent.TimeUnit.NANOSECONDS;


public class ReviewActivity extends ActionBarActivity {

    private int score;
    private int review_qno;
    private TextView text_Score;
    private TextView text_time_elapsed;
    private long total_time;
    private int high_Score;
    private Button button_review_answers;
    private Button button_retake_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        score = getIntent().getIntExtra("final_Score",0);

        SharedPreferences sp = getSharedPreferences("data", Context.MODE_PRIVATE);
        //SharedPreferences.Editor ed = sp.edit();
        high_Score = sp.getInt("high_score",-1);
        if(high_Score == -1 || high_Score < score){
            high_Score = score;
            SharedPreferences.Editor ed = sp.edit();
            ed.putInt("high_score",score);
            ed.commit();
        }
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
        ((TextView)findViewById(R.id.text_high_score)).setText(String.valueOf(high_Score));
        ((TextView)findViewById(R.id.text_result_score)).setText(String.valueOf(score));
        ((TextView)findViewById(R.id.text_time_elapsed)).setText(String.valueOf(NANOSECONDS.toSeconds(total_time)));
        //((TextView)findViewById(R.id.text_qno_caption)).setText(String.valueOf(review_qno));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        Session s = Session.getActiveSession();
        String t = s != null ? s.getAccessToken() : null;
        if(t == null || t.isEmpty())
            return  false;
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout_fb) {
            Fblogout fb = new Fblogout();
            fb.logofff(ReviewActivity.this);
        }

        return super.onOptionsItemSelected(item);
    }
}
