package com.example.builderpattern;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.builderpattern.databinding.CustomDialogLayoutBinding;

public class CustomDialog extends DialogFragment {

    private String positiveButtonText, negativeButtonText, titleText, descriptionText;
    private CustomDialogLayoutBinding customDialogLayoutBinding;
    private DialogButtonClickListener dialogClickListener = null;

    interface DialogButtonClickListener{
        void onPositiveButton();
    };
    public CustomDialog(String positiveButtonText, String negativeButtonText, String titleText, String descriptionText){

        this.positiveButtonText = positiveButtonText;
        this.negativeButtonText = negativeButtonText;
        this.titleText = titleText;
        this.descriptionText = descriptionText;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        customDialogLayoutBinding = CustomDialogLayoutBinding.inflate(inflater, container, false);
        return customDialogLayoutBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        customDialogLayoutBinding.dialogTitle.setText(titleText);
        customDialogLayoutBinding.dialogMessage.setText(descriptionText);
        customDialogLayoutBinding.btnRedimirPuntos.setText(positiveButtonText);
        customDialogLayoutBinding.btnRedimirPuntos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogClickListener.onPositiveButton();

            }
        });


    }

    public void setListener(DialogButtonClickListener listener){
        dialogClickListener = listener;
    }

}
