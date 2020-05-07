package edu.psu.jjb24.csjokes;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class DisplayPunchlineDialog extends DialogFragment {

    DisplayPunchLineDialogListener displaySetupDialogListener;

    public interface DisplayPunchLineDialogListener{
        void displaySetupDialog(String title, String setUp, String punchline);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        displaySetupDialogListener = (DisplayPunchLineDialogListener) context;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final String jokeTitle = getArguments().getString("title");
        final String jokeMessage = getArguments().getString("setup");
        final String punchline = getArguments().getString("punchline");
        builder.setTitle(jokeTitle);
        builder.setMessage(punchline)
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                })
                .setNegativeButton("Setup", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        displaySetupDialogListener.displaySetupDialog(jokeTitle,jokeMessage,punchline);
                    }
                });
        return builder.create();
    }
}
