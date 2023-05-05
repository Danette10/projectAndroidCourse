package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button myBtn1, myBtn2, myBtn3;
    private EditText myEditText;

    public void exitApp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(getResources().getString(R.string.popup_title));
        builder.setMessage(getResources().getString(R.string.popup_message));
        builder.setPositiveButton(getResources().getString(R.string.popup_yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.popup_no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.myBtn1 = findViewById(R.id.btn1);
        this.myBtn2 = findViewById(R.id.btn2);
        this.myBtn3 = findViewById(R.id.btn3);
        this.myEditText = findViewById(R.id.editText);

        this.myBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
            }
        });

        this.myBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitApp();
            }
        });

        this.myBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String myText = myEditText.getText().toString();

                Intent intent = new Intent(MainActivity.this, HelloActivity.class);
                intent.putExtra("user", myText);

                if(myText.isEmpty()) {
                    myEditText.setError("Veuillez saisir un texte");
                }else{
                    startActivity(intent);
                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        exitApp();
    }
}