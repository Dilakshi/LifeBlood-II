package com.graise.ansafn.lifeblood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ExistingDonor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donor_home_screen);

    }

    public void checkEligibility(View view) {
        Intent intent = new Intent(ExistingDonor.this, EligibilityQuestionaire.class);
        startActivity(intent);
    }

}
