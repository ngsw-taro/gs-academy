package com.example.gs;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatDialogFragment;

public class ProgressDialogFragment extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {
        final FragmentActivity activity = getActivity();
        final Dialog.OnCancelListener listener;
        if (activity instanceof Dialog.OnCancelListener) {
            listener = (Dialog.OnCancelListener) activity;
        } else {
            listener = null;
        }

        final ProgressDialog dialog = new ProgressDialog(activity);
        dialog.setMessage(getString(R.string.processing));
        dialog.setOnCancelListener(listener);
        return dialog;
    }
}
