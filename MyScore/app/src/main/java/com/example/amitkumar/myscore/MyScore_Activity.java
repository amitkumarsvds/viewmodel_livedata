package com.example.amitkumar.myscore;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * class to show,add,reset score
 */
public class MyScore_Activity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTxtScore;
    private Button mBtnAddScore, mBtnResetScore;
    private int mScore = 0;
    public MyScoreViewModel myScoreViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myscore_main);

        setUiElements();

        myScoreViewModel = ViewModelProviders.of(this).get(MyScoreViewModel.class);

        myScoreViewModel.getScore().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                mTxtScore.setText(String.valueOf(integer));
            }
        });
    }

    /**
     * Set the Ui elements
     */
    public void setUiElements() {
        mTxtScore = findViewById(R.id.txtScore);
        mBtnAddScore = findViewById(R.id.btnAddScore);
        mBtnResetScore = findViewById(R.id.btnResetScore);
        mBtnAddScore.setOnClickListener(this);
        mBtnResetScore.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddScore:
                myScoreViewModel.addScore();
                break;

            case R.id.btnResetScore:
                myScoreViewModel.resetScore();
                break;

            default:
                break;
        }
    }
}
