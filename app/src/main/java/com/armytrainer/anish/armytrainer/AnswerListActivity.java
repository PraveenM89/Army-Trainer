package com.armytrainer.anish.armytrainer;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


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

        ArrayList<Question> answer_array = new ArrayList<Question>();
        for(int i=review_qno,j=0;j<15;j++){
            answer_array.add(qBank[i]);
            i = (i+1)% qBank.length;
        }
        /*
        int temp_qno = 1;
        for(Question q : answer_array){
            q.setQno(temp_qno);
            temp_qno +=1;
        }*/

        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, answer_array);
        answers_list_view.setAdapter(adapter);
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

class StableArrayAdapter extends ArrayAdapter<Question> {

    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

    public StableArrayAdapter(Context context, int textViewResourceId, ArrayList<Question> objects) {
        super(context, textViewResourceId, objects);
        int i=0;
        for (Question c : objects) {
            mIdMap.put(objects.toString(), i);
            i+=1;
        }
    }

}
