package com.example.doinhietdo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioGroup group1, group2;
    private RadioButton rbtn1[], rbtn2[];
    private TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        rbtn1 = new RadioButton[3];
        rbtn2 = new RadioButton[3];
        rbtn1[0] = findViewById(R.id.C1);
        rbtn1[1] = findViewById(R.id.F1);
        rbtn1[2] = findViewById(R.id.K1);
        rbtn2[0] = findViewById(R.id.C2);
        rbtn2[1] = findViewById(R.id.F2);
        rbtn2[2] = findViewById(R.id.K2);

        text1 = (TextView) findViewById(R.id.in);
        text2 = (TextView) findViewById(R.id.out);
        group1 = (RadioGroup) findViewById(R.id.group1);
        group2 = (RadioGroup) findViewById(R.id.group2);

        for (int i = 0; i < 3; i++) {
            rbtn1[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    doi_t();
                }
            });
            rbtn2[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    doi_t();
                }
            });
        }
    }

    public void doi_t() {
        int i = -1,j = -1;
        double t = 0;
        if(text1.getText().length() > 0){
            t = Double.parseDouble(String.valueOf(text1.getText()));
            for(i = 0; i < 3; i++){
                if(rbtn1[i].getId() == group1.getCheckedRadioButtonId())
                    break;
            }
            for(j = 0; j < 3; j++) {
                if (rbtn2[j].getId() == group2.getCheckedRadioButtonId())
                    break;
            }
        }
        if(i > -1 && j > -1)
            switch (i) {
                case 0:
                    switch (j) {
                        case 0:
                            t = t;
                            break;
                        case 1:
                            t = (t * 1.8) + 32;
                            break;
                        case 2:
                            t = t + 273.15;
                            break;
                    };
                    break;
                case 1:
                    switch (j) {
                        case 0:
                            t = (t - 32) / 1.8;
                            break;
                        case 1:
                            t = t;
                            break;
                        case 2:
                            t = ((t - 32) / 1.8) + 273.15;
                            break;
                    };
                    break;
                case 2:
                    switch (j) {
                        case 0:
                            t = t - 273.15;
                            break;
                        case 1:
                            t = ((t - 273.15) * 1.8) + 32;
                            break;
                        case 2:
                            t = t;
                            break;
                    };
                    break;
            };
        text2.setText(String.valueOf( Math.round(t * 100) / 100.0));
    }
}
