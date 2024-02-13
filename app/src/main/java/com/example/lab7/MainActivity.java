package com.example.lab7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements MyDialogFragment.MyDialogFragmentListener {

    private TextView myText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button myButton = findViewById(R.id.button);
        myText = findViewById(R.id.textView);
        myButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                FragmentManager manager = getSupportFragmentManager();
                MyDialogFragment myDialogFragment = new
                        MyDialogFragment();
                myDialogFragment.show(manager, "myDialog");
            }
        });
    }
    @Override
    public void onReturnValue(String value) {
        myText.setText("Здравствуйте, "+value+"!");
    }

    public void onClickFinish(){
        Intent i = new Intent(String.valueOf(MainActivity.this));
        finish();
    }
}