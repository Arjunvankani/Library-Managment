package com.example.library_managment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updateActivity extends AppCompatActivity {

    EditText bid,bname,author,pyear,phouse,dept,isbn,copies;
    Button update;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        bid=findViewById(R.id.bid2);
        bname=findViewById(R.id.bname2);
        author=findViewById(R.id.author2);
        pyear=findViewById(R.id.pyear2);
        phouse=findViewById(R.id.phouse2);
        dept=findViewById(R.id.dept2);
        isbn=findViewById(R.id.isbn2);
        copies=findViewById(R.id.copies2);
        update=findViewById(R.id.updatebtn);
        DB=new DBHelper(updateActivity.this);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Bookid=bid.getText().toString();
                String BName=bname.getText().toString();
                String Author=author.getText().toString();
                String Pyear=pyear.getText().toString();
                String Phouse=phouse.getText().toString();
                String Dept=dept.getText().toString();
                String ISBN=isbn.getText().toString();
                String Copies=copies.getText().toString();

                Boolean checkupdatedata=DB.updatedata(Bookid,BName,Author,Pyear,Phouse,Dept,ISBN,Copies);
                if(checkupdatedata==true){
                    Toast.makeText(updateActivity.this,"Data Updated",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(updateActivity.this," Data Not Exists",Toast.LENGTH_LONG).show();
                }
                Intent intent=new
                        Intent(updateActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
