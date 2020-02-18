package com.example.android_seminar_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View color_View = findViewById(R.id.color_View);
        final EditText ed_color = findViewById(R.id.ed_color);
        Button btn_save = findViewById(R.id.btn_save);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs" , MODE_PRIVATE);
        ed_color.setText(sharedPreferences.getString("color" , "White."));

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String color = "";
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs" , MODE_PRIVATE);
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putString("color", ed_color.getText().toString());
                if (color.equals("blue") || color.equals("Blue")) {
                    color_View.setBackgroundColor(Color.BLUE);
                }
                else if (color.equals("red") || color.equals("Red")) {
                    color_View.setBackgroundColor(Color.RED);
                }
                editor.commit();
            }
        });

    }
}
