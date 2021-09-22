package com.example.library_managment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class insertActivity extends AppCompatActivity {
    EditText bid,bname,author,pyear,phouse,dept,isbn,copies;
    Button insert;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        bid=findViewById(R.id.bid);
        bname=findViewById(R.id.bname);
        author=findViewById(R.id.author);
        pyear=findViewById(R.id.pyear);
        phouse=findViewById(R.id.phouse);
        dept=findViewById(R.id.dept);
        isbn=findViewById(R.id.isbn);
        copies=findViewById(R.id.copies);
        insert=findViewById(R.id.insertbtn);
        DB=new DBHelper(insertActivity.this);
        insert.setOnClickListener(new View.OnClickListener() {
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

                Boolean checkinsertdata = DB.insertdata(Bookid,BName,Author,Pyear,Phouse,Dept,ISBN,Copies);
                if(checkinsertdata==true){
                    Toast.makeText(insertActivity.this,"New Data Inserted",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(insertActivity.this,"New Data Not Inserted",Toast.LENGTH_LONG).show();
                }
                Intent intent=new Intent(insertActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

