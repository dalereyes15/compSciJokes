package edu.psu.jjb24.csjokes;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class DisplaySetupDialog extends DialogFragment {

    DisplaysetUpDialogListener listener;

    public interface DisplaysetUpDialogListener {
        void displayPunchLineDialog(String title, String setup, String punchline);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        listener = (DisplaysetUpDialogListener) context;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final String jokeTitle = getArguments().getString("title");
        final String jokeSetUp = getArguments().getString("setup");
        final String punchline = getArguments().getString("punchline");
        builder.setTitle(jokeTitle);
        builder.setMessage(jokeSetUp)
                .setPositiveButton("Punchline", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        listener.displayPunchLineDialog(jokeTitle,jokeSetUp,punchline);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        return builder.create();
    }

}

