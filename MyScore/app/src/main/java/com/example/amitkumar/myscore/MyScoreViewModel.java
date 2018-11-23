package com.example.amitkumar.myscore;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * View model for score class to hold UI data.
 *
 * If we want application context than extends Androidview model instead of viewmodel
 */
public class MyScoreViewModel extends ViewModel {

    private MutableLiveData<Integer> mutableLiveData;

    /**
     * Live data to hold a data and update it to UI
     * setvalue-When caling from main thread
     * postvalue-when calling from worker thread
     *
     * @return mutableLiveData
     */
    public MutableLiveData<Integer> getScore() {
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
            mutableLiveData.setValue(0);
        }
        return mutableLiveData;
    }

    /**
     * Add a score
     */
    public void addScore() {
        if (mutableLiveData.getValue() != null) {
            mutableLiveData.setValue(mutableLiveData.getValue() + 1);
        }
    }

    /**
     * reset a score
     */
    public void resetScore() {
        mutableLiveData.setValue(0);
    }
}
