package com.armytrainer.anish.armytrainer;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.Session;


public class RulesActivity extends ActionBarActivity {

    private Button button_begin;
    private TextView temp ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        button_begin = (Button)findViewById(R.id.button_begin);

        button_begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(RulesActivity.this, QuizActivity.class);
                startActivityForResult(k,1);
                RulesActivity.this.finish();
            }
        });
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
    public void onBackPressed() {
        super.onBackPressed();
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
            fb.logofff(RulesActivity.this);
        }

        return super.onOptionsItemSelected(item);
    }
}
