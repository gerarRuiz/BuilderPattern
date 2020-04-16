package com.example.builderpattern;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.builderpattern.databinding.CustomQuestionDialogLayoutBinding;
import com.example.builderpattern.databinding.CustomWaintingDialogLayoutBinding;

import static android.content.ContentValues.TAG;

public class CustomWaitingDialog extends DialogFragment {


    private String titleText, descriptionText;
    private static CustomWaintingDialogLayoutBinding customDialogLayoutBinding;


    public CustomWaitingDialog(String titleText, String descriptionText){

        this.titleText = titleText;
        this.descriptionText = descriptionText;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        customDialogLayoutBinding = CustomWaintingDialogLayoutBinding.inflate(inflater, container, false);
        return customDialogLayoutBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        customDialogLayoutBinding.dialogTitle.setText(titleText);
        customDialogLayoutBinding.dialogMessage.setText(descriptionText);
        customDialogLayoutBinding.circularProgressBar.setProgressMax(100f);

        new TaskTimer().execute();

    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        Log.d(TAG, "onDismiss: Funciona");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.DialogThemeFading;
    }

    public static class TaskTimer extends AsyncTask<Void,Void,Void>{


        @Override
        protected Void doInBackground(Void... voids) {

            for (int i = 10; i <= 100; i=i+10) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                customDialogLayoutBinding.circularProgressBar.setProgress(Float.parseFloat(String.valueOf(i)));

            }

            return null;
        }

    }

}
