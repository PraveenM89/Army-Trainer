package com.armytrainer.anish.armytrainer;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;


public class AnswerListActivity extends ActionBarActivity {

    private ListView answers_list_view ;
    private int review_qno;
    private Question qBank[] = QuestionBank.getQuestionBank();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_list);
        answers_list_view = (ListView)findViewById(R.id.answers_list_view);
        review_qno = getIntent().getIntExtra("review_from_qno",1);
        Log.i("review value",String.valueOf(review_qno));
        ArrayList<Question> answer_array = new ArrayList<Question>();
        for(int i=review_qno,j=0;j<15;j++){
            answer_array.add(qBank[i]);
            i = (i+1)% qBank.length;
        }

        MyListAdapter ad = new MyListAdapter(this,answer_array);
        answers_list_view.setAdapter(ad);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_answer_list, menu);
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

class MyListAdapter extends BaseAdapter{

    ArrayList<Question> f_qbank;

    Context c;
    public MyListAdapter(Context c, ArrayList<Question> qbank){
        this.f_qbank = qbank;
        this.c = c;
    }
    @Override
    public int getCount() {
        return f_qbank.size();
    }

    @Override
    public Object getItem(int position) {
        return f_qbank.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if(row == null){
            LayoutInflater inf = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inf.inflate(R.layout.single_row, parent,false);
        }
        ((TextView) row.findViewById(R.id.final_qno)).setText("Q-No "+ position);
        ((TextView) row.findViewById(R.id.final_qtext)).setText(f_qbank.get(position).getqText());
        ((TextView) row.findViewById(R.id.final_qans)).setText(f_qbank.get(position).getqAnswer());

        return row;
    }
}
