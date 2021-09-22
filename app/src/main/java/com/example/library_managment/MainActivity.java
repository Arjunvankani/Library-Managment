package com.example.library_managment;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.insert:
                Intent intent=new Intent(MainActivity.this,insertActivity.class);
                startActivity(intent);
                break;
            case R.id.Upadate:
                Intent intent1=new Intent(MainActivity.this,updateActivity.class);
                startActivity(intent1);
                break;
            case R.id.delete:
                Intent intent2=new Intent(MainActivity.this,deleteActivity.class);
                startActivity(intent2);
                break;
            case R.id.display:
                Intent intent3 = new Intent(MainActivity.this,displayActivity.class);
                startActivity(intent3);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}
