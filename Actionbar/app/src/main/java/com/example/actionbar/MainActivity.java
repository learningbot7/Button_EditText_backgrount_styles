package com.example.actionbar;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar=getSupportActionBar();
        actionBar.show();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle("Learninig Bot");
      //  actionBar.setIcon(R.drawable.home_icon);
      //  actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.home_icon);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id= item.getItemId();
        switch (id){
            case R.id.mail:
                Toast.makeText(this, "this is mail option", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Second_Activity.class);
                startActivity(intent);
                return true;
        //break;
            case R.id.photo:
                Toast.makeText(this, "this is Photo option", Toast.LENGTH_SHORT).show();
            break;
            case R.id.share:
                Toast.makeText(this, "this is share option", Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit:
                Toast.makeText(this, "this is exit option", Toast.LENGTH_SHORT).show();
                break;


        }

        return super.onOptionsItemSelected(item);
    }
}