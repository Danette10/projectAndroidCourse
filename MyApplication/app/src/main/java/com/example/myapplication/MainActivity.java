package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button myBtn1, myBtn2, myBtn3;
    private LinearLayout myLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.myBtn1 = findViewById(R.id.btn1);
        this.myBtn2 = findViewById(R.id.btn2);
        this.myBtn3 = findViewById(R.id.btn3);
        this.myLayout = findViewById(R.id.myLayout);

        this.myBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseBackgroundColor();
            }
        });

        this.myBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Le code que vous avez fourni pour le bouton 2
            }
        });

        this.myBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Button 3 clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void chooseBackgroundColor() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Choose background color");

        final EditText input = new EditText(MainActivity.this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.setHint("Enter RGB or hex color");
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String colorInput = input.getText().toString().trim();
                int color;
                try {
                    if (colorInput.matches("^#[0-9a-fA-F]{6}$")) {
                        color = Color.parseColor(colorInput);
                    } else if (colorInput.matches("^\\d{1,3},\\d{1,3},\\d{1,3}$")) {
                        String[] rgbValues = colorInput.split(",");
                        int red = Integer.parseInt(rgbValues[0]);
                        int green = Integer.parseInt(rgbValues[1]);
                        int blue = Integer.parseInt(rgbValues[2]);
                        color = Color.rgb(red, green, blue);
                    } else {
                        Toast.makeText(MainActivity.this, "Invalid input. Please enter RGB or hex color.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    MainActivity.this.myLayout.setBackgroundColor(color);
                } catch (IllegalArgumentException e) {
                    Toast.makeText(MainActivity.this, "Invalid input. Please enter RGB or hex color.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        builder.show();
    }

}