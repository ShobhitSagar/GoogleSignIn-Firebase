package com.shobhitsagar.googlesignin;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

/**
 * Created by shobhitsagar on 03/09/17.
 */

public class SignedInActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signedin);
    }

    @Override
    public void onBackPressed() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(SignedInActivity.this);
        builder.setTitle("Exit");
        builder.setIcon(R.drawable.ic_exit_to_app_black_24dp);
        builder.setMessage("Are you sure you want to exit?");
        builder.setCancelable(true);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
