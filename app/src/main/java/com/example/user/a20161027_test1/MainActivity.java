package com.example.user.a20161027_test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb;
    Button bt;
    Button bt2;
    Button bt3;
    TextView tv;
    TextView tv2;
    SeekBar sb;
    AutoCompleteTextView act;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = (ProgressBar) findViewById(R.id.progressBar);  //progressbar進度條
        bt = (Button) findViewById(R.id.button);
        bt2 = (Button) findViewById(R.id.button2);
        bt3 = (Button) findViewById(R.id.button3);
        tv = (TextView) findViewById(R.id.textView2);
        tv2 = (TextView) findViewById(R.id.textView3);
        sb = (SeekBar) findViewById(R.id.seekBar);          //seekbar拉條

        act= (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        String data[] = {"aaa","aab","aac","bba","bbc","ccc","cca","ccb"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,data);
        act.setThreshold(1);
        act.setAdapter(adapter);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb.setProgress(pb.getProgress()+10);
            }
        });

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {    //即時變化
                tv.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText(String.valueOf(sb.getProgress()));      //按下button才變化
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {        //跳出選取訊息
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,act.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
