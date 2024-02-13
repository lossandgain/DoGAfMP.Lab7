package com.example.lab7;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MyDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new
                AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_message);
        LayoutInflater inflater =
                requireActivity().getLayoutInflater();
        View layout = inflater.inflate(R.layout.dialog_layout,null);
        builder.setView(layout);
        final EditText myText = (EditText)
                layout.findViewById(R.id.name);
        builder.setPositiveButton(R.string.yes, new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MyDialogFragmentListener activity =
                                (MyDialogFragmentListener) getActivity();

                        activity.onReturnValue(String.valueOf(myText.getText()));
                    }
                });
        builder.setNegativeButton(R.string.no, new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder.setNeutralButton(R.string.kill, new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                MyDialogFragmentListener activity = (MyDialogFragmentListener) getActivity();
                activity.onClickFinish();
            }
        });
        return builder.create();
    }
    public interface MyDialogFragmentListener {

        void onReturnValue(String value);
        void onClickFinish();

    }
}