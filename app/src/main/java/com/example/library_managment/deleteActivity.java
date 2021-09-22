package com.example.library_managment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class deleteActivity extends AppCompatActivity {

    EditText Bid;
    Button delete;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delet_acivity);
        Bid=findViewById(R.id.Bid);
        delete=findViewById(R.id.deletebtn);
        DB=new DBHelper(this);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bid = Bid.getText().toString();
                Boolean deleteData = DB.deletedata(bid);
                if (deleteData == true) {
                    Toast.makeText(deleteActivity.this, "Data Deleted Successfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(deleteActivity.this, "Data Deleted failed", Toast.LENGTH_LONG).show();


                    Intent intent = new Intent(deleteActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
