package com.example.agenda.util;

import android.app.ProgressDialog;
import android.content.Context;

public class Loading {
    private static ProgressDialog progress;

    public static void start(Context context, String msg){
        progress = new ProgressDialog(context);
        progress.setMessage(msg);
        progress.setCancelable(false);
        progress.show();
    }
    public static void stop(){
        progress.dismiss();
    }
}
