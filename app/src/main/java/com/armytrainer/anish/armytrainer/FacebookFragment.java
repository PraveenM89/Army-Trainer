package com.armytrainer.anish.armytrainer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.widget.LoginButton;

/**
 * Created by Praveen on 2/27/2015.
 */
public class FacebookFragment extends Fragment {
    private UiLifecycleHelper uiHelper;
    private static final String TAG = "FacebookFragment";
    private View v;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fb_login, container, false);
        v = view;
        LoginButton authButton = (LoginButton) view.findViewById(R.id.authButton);

        ((Button)view.findViewById(R.id.skip_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),RulesActivity.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        authButton.setFragment(this);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uiHelper = new UiLifecycleHelper(getActivity(), callback);

        uiHelper.onCreate(savedInstanceState);
    }

    private void onSessionStateChange(Session session, SessionState state, Exception exception) {
        if (state.isOpened()) {
            Log.i(TAG, "Logged in...");
            //((Button)(v.findViewById(R.id.skip_button))).setVisibility(View.INVISIBLE);
            Intent ij = new Intent(getActivity(),RulesActivity.class);
            startActivityForResult(ij,1);
            getActivity().finish();
        } else if (state.isClosed()) {

            Log.i(TAG, "Logged out...");
        }
    }
    private Session.StatusCallback callback = new Session.StatusCallback() {
        @Override
        public void call(Session session, SessionState state, Exception exception) {
            onSessionStateChange(session, state, exception);
        }
    };
    @Override
    public void onResume() {
        super.onResume();
        uiHelper.onResume();
        Session session = Session.getActiveSession();
        if (session != null &&
                (session.isOpened() || session.isClosed()) ) {
            onSessionStateChange(session, session.getState(), null);
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uiHelper.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onPause() {
        super.onPause();
        uiHelper.onPause();
    }

}
