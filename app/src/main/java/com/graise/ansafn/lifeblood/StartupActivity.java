package com.graise.ansafn.lifeblood;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.graise.ansafn.lifeblood.DonationRequest.DonationRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class StartupActivity extends AppCompatActivity {

    private ListView lstRequest;
    List<DonationRequest> reqList = new ArrayList<DonationRequest>();
    DonationRequest reqSeleceted = new DonationRequest();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_identification);

        lstRequest = (ListView) findViewById(R.id.lstRequest);

        //load data
        new GetData().execute(Common.getRequestAPI());

        findViewById(R.id.btnexistuser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartupActivity.this, ExistingDonor.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnnewuser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartupActivity.this, ActivityDonorRegistration.class);
                startActivity(intent);
            }
        });
    }


    //process data
    class GetData extends AsyncTask<String, Void, String> {

        ProgressDialog pd = new ProgressDialog(StartupActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pd.setTitle("Loading...");
            pd.show();
        }

        @Override
        protected String doInBackground(String... params) {
            String stream = null;
            String urlString = params[0];

            HTTPDataHandler http = new HTTPDataHandler();
            stream = http.GetHTTPData(urlString);
            return stream;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Gson gson = new Gson();
            Type listType = new TypeToken<List<DonationRequest>>() {
            }.getType();
            reqList = gson.fromJson(s, listType);
            CustomAdapter adapter = new CustomAdapter(getApplicationContext(), reqList);
            lstRequest.setAdapter(adapter);
            pd.dismiss();
        }

    }
}