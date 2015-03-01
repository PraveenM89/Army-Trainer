package com.armytrainer.anish.armytrainer;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.facebook.Session;

/**
 * Created by Praveen on 2/28/2015.
 */
public class Fblogout{
    private Session session;
    private final String DEBUG = "fb_Error";

    public static void gobacktoLogin(Activity d){
        Intent i = new Intent(d,MainActivity.class);
        d.startActivity(i);
        d.finish();

    }

    public void logofff(Activity d){
            Log.d(DEBUG, "in facebook signout");
            if (Session.getActiveSession() == null) {

            }
            else {
                session = Session.getActiveSession();
                String token = session.getAccessToken();
                if (token != null && !token.isEmpty()) {
                    Log.d(DEBUG, "session is active");
                    session.closeAndClearTokenInformation();
                    session.close();
                    if (Session.getActiveSession() == null) {
                        Log.d(DEBUG, "session is active in");
                    }
                    gobacktoLogin(d);

                } else {
                    Log.d(DEBUG, "session is not active");
                }
            }


    }

}
