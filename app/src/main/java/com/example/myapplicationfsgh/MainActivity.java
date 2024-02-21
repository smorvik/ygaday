package com.example.myapplicationfsgh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    boolean gameFinished = false;
    int guess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView)findViewById(R.id.textView1);
        etInput = (EditText)findViewById(R.id.editText1);
        bControl = (Button)findViewById(R.id.button1);

        guess = (int) (Math.random() * 100);
    }

    public void onClick(View v){
        if (!gameFinished) {
            int inp = Integer.parseInt(etInput.getText().toString());
            if (inp > guess)
                tvInfo.setText(R.string.ahead);
            if (inp < guess)
                tvInfo.setText(R.string.behind);
            if (inp == guess) {
                tvInfo.setText(R.string.hit);
                bControl.setText(R.string.play_more);
                gameFinished = true;
            }
        } else {
            guess = (int)(Math.random()*100);
            bControl.setText(R.string.input_value);
            tvInfo.setText(R.string.try_to_guess);
            gameFinished = false;
        }
        etInput.setText("");
    }
}
