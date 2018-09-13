package com.msp.files;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    EditText edtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.txt);
        edtxt = (EditText) findViewById(R.id.edtxt);
    }

    String path = "/sdcard/myfile.txt";
    public void onSave(View view) {
        String text = edtxt.getText().toString();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            fileOutputStream.write(text.getBytes());
            fileOutputStream.close();
            edtxt.setText("");
            txt.setText("Saved Successfully...");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public void onLoad(View view) {
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line + "\n");
                line = bufferedReader.readLine();
            }
            fileInputStream.close();
            txt.setText(stringBuilder.toString());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
