package com.armytrainer.anish.armytrainer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class QuizActivity extends ActionBarActivity {

    private Question qBank[] = QuestionBank.getQuestionBank();
    private int curr_qno;
    private int count;
    private int total_qCount = qBank.length;
    private int score;

    private TextView text_qno;
    private TextView text_score;
    private TextView text_qText;
    private RadioGroup radio_group;
    private RadioButton radio_choice1;
    private RadioButton radio_choice2;
    private RadioButton radio_choice3;
    private RadioButton radio_choice4;
    private Button button_next;
    private Button button_end;
    private int temp_curr_index;
    private long total_time = 0;
    private long start_time=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        start_time = System.nanoTime();

        text_qno = (TextView)findViewById(R.id.text_qno);
        text_score = (TextView)findViewById(R.id.text_score);
        text_qText = (TextView)findViewById(R.id.text_question);
        radio_group = (RadioGroup)findViewById(R.id.radio_group);
        radio_choice1 = (RadioButton)findViewById(R.id.radio_choice1);
        radio_choice2 = (RadioButton)findViewById(R.id.radio_choice2);
        radio_choice3 = (RadioButton)findViewById(R.id.radio_choice3);
        radio_choice4 = (RadioButton)findViewById(R.id.radio_choice4);
        button_next = (Button)findViewById(R.id.button_next);
        button_end = (Button)findViewById(R.id.button_end);

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(radio_group.getCheckedRadioButtonId()==-1){
                    Toast.makeText(QuizActivity.this, " select an answer ", Toast.LENGTH_SHORT).show();
                }
                else {
                    RadioButton selected_radio = (RadioButton)findViewById(radio_group.getCheckedRadioButtonId());
                    if(selected_radio.getText().equals(qBank[curr_qno].getqAnswer()))
                        score += 1;
                    curr_qno = (curr_qno + 1) % total_qCount;

                    if(count == 15)
                        endTest();

                    else{
                        count+=1;
                        updateText();
                    }

                }
            }
        });

        button_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder end_alert = new AlertDialog.Builder(QuizActivity.this);
                end_alert.setTitle("  EXIT ?")
                        .setPositiveButton("yes",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                endTest();
                            }
                        })
                        .setNegativeButton("no",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
               Dialog alert =  end_alert.create();
                alert.show();
            }
        });

        Random rd = new Random();
        temp_curr_index = curr_qno =  rd.nextInt(15);
        score = 0;
        count = 1;
        updateText();

    }

    private void endTest(){
        total_time += System.nanoTime() - start_time;
        start_time=0;
        Intent l = new Intent(QuizActivity.this, ReviewActivity.class);
        l.putExtra("final_Score",score);
        l.putExtra("review_from_qno",temp_curr_index);
        l.putExtra("time_elapsed",total_time);
        startActivityForResult(l, 1);
        QuizActivity.this.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        total_time = 0;
        start_time = 0;
    }

    @Override
    protected void onPause() {
        super.onPause();
        total_time += System.nanoTime() - start_time;
        start_time = 0;

    }

    @Override
    protected void onResume() {
        super.onResume();
        start_time = System.nanoTime();
    }

    private void updateText(){

        text_qno.setText(String.valueOf(count));
        text_score.setText(String.valueOf(score));
        text_qText.setText(qBank[curr_qno].getqText());
        radio_choice1.setText(qBank[curr_qno].getqChoice1());
        radio_choice2.setText(qBank[curr_qno].getqChoice2());
        radio_choice3.setText(qBank[curr_qno].getqChoice3());
        radio_choice4.setText(qBank[curr_qno].getqChoice4());
        radio_group.clearCheck();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
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
