package com.example.munazam_astudentorganizer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;



import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.munazam_astudentorganizer.Adapter.PredictorView;
import com.example.munazam_astudentorganizer.Adapter.TunerView;

public class Mainmenu extends AppCompatActivity {

    private Button opent;
    private  Button openp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        ActionBar ac = getSupportActionBar();
        ac.hide();

        opent = findViewById(R.id.button14);
        openp = findViewById(R.id.button15);

        opent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opentuner();
            }
        });
        openp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openprdictor();
            }
        });

        Fragment x = TunerView.newInstance();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, x);
        ft.commit();
    }
    public void opentuner()
    {
        System.out.println("tuner_template to be opened");
        FragmentManager fm = getSupportFragmentManager();
        Fragment x = TunerView.newInstance();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, x);
        ft.commit();
    }
    public void openprdictor()
    {
        System.out.println("predictor to be opened");
        FragmentManager fm = getSupportFragmentManager();
        Fragment x = PredictorView.newInstance();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, x);
        ft.commit();
    }
}
