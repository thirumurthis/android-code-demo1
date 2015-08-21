package mordenartui.labs.course.modernartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by thirumurthi on 8/20/2015.
 */
public class MenuDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState){

        return new AlertDialog.Builder(getActivity()).setMessage("Inspired by the works of the artists such as  Piet Mondrian " +
                "and Ben Nicholson \n\n Click Below to learn more!")
                .setCancelable(false)
                .setNegativeButton("Visit MOMA", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface,int id){
                        MainActivity mainActivity= (MainActivity)getActivity();

                        Toast.makeText(mainActivity.getContext(), "Clicked menu", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(mainActivity,WebViewActivity.class));

                    }
                })
                .setPositiveButton("Not Now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((MainActivity)getActivity()).shutdownDialog();
                    }
                }).create();
    }
}
