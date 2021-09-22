package com.example.library_managment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class displayActivity extends AppCompatActivity {

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        DB = new DBHelper(this);
        Cursor res = DB.displaydata();

        if (res.getCount() == 0) {
            Toast.makeText(displayActivity.this, "No Entry Exists", Toast.LENGTH_LONG).show();
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Book Id : " + res.getString(0) + "\n\n");
            buffer.append("Book Name : " + res.getString(1) + "\n\n");
            buffer.append("AuthorName : " + res.getString(2) + "\n\n");
            buffer.append("publicationY : " + res.getString(3) + "\n\n");
            buffer.append("publishingH : " + res.getString(4) + "\n\n");
            buffer.append("Department : " + res.getString(5) + "\n\n");
            buffer.append("ISBN : " + res.getString(6) + "\n\n");
            buffer.append("Copies : " + res.getString(7) + "\n\n");
            buffer.append("--------------------- " +"\n\n");

        }
        AlertDialog.Builder builder = new AlertDialog.Builder(displayActivity.this);
        builder.setCancelable(true);
        builder.setTitle("Book Info. \n \n");

        builder.setMessage(buffer.toString());
        builder.setPositiveButton("Ok", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(displayActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
        builder.show();
    }
}