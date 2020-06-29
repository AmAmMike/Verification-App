package com.example.vbariacodeverifier;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("SetTextI18n")
    public void Decoder(View view) {
        EditText Code = findViewById(R.id.InputCode);
        TextView Result_Text = findViewById(R.id.Result);
        String Code_String = Code.getText().toString();
        String match = ".";
        int count = 0;
        Boolean chk = Boolean.FALSE;
        int matchLength = match.length();

        int index = Code_String.indexOf(match);
        int oldindex = index;
        String Part1 = null;
        String Part2 = null;
        String Part3 = null;
        String Part4;
        int Length1 = 0;
        int Length2 = 0;
        int Length3 = 0;
        int Length4 = 0;
        while (index >= 0) {  // indexOf returns -1 if no match found
            count = count + 1;
            switch (count) {
                case 1:
                    Part1 = Code_String.substring(0, index);
                    Length1 = Part1.length();
                    Part2 = Code_String.substring(index + matchLength);
                    Length2 = Part2.length();
                    oldindex = index;
                case 2:
                    Part2 = Code_String.substring(oldindex + matchLength, index);
                    Length2 = Part2.length();
                    Part3 = Code_String.substring(index + matchLength, 1);
                    Length3 = Part3.length();
                    Part4 = Code_String.substring(index + matchLength + 1);
                    Length4 = Part4.length();
            }
            index = Code_String.indexOf(match, index + matchLength);
        }

        if (count == 2 && Part1 == "VBAria" && Part3 == "0" && Length4 >= 1 && Length4 <= 5) {
            if (Integer.parseInt(Part2) % 1361 == 0) {
                chk = Boolean.TRUE;
            }
        }

        if (chk) {
            Result_Text.setText("@string/ResultAccept_Text");
        }else{
            Result_Text.setText("@string/ResultReject_Text");
        }
    }
}