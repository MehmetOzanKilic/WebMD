package com.example.webmd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        int male=0;
        int female=0;
        Patient patient=new Patient();
        EditText age_edit_text;

    public void onClick(View v){


        switch (v.getId()){
            case R.id.male_button:
                Toast.makeText(this, "male", Toast.LENGTH_SHORT).show();
                age_edit_text.onEditorAction(EditorInfo.IME_ACTION_DONE);
                if(female==1) {
                    findViewById(R.id.female_button).setBackgroundResource(R.drawable.new_shadow);
                    female = 0;
                }
                if(male==0) {
                    findViewById(R.id.male_button).setBackgroundResource(R.drawable.new_shadow_re);
                    male=1;
                }
                break;

            case R.id.female_button:
                Toast.makeText(this, "female"+female, Toast.LENGTH_SHORT).show();
                age_edit_text.onEditorAction(EditorInfo.IME_ACTION_DONE);
                if(male==1) {
                    findViewById(R.id.male_button).setBackgroundResource(R.drawable.new_shadow);
                    male = 0;
                }
                if(female==0) {
                    findViewById(R.id.female_button).setBackgroundResource(R.drawable.new_shadow_re);
                    female=1;
                }
                break;

            case R.id.age_gender_save_button:

                if(male==1){patient.setGender(true);}if (female==1){patient.setGender(false);}
                EditText age_edit_text=findViewById(R.id.age_text);
                int temp_age=Integer.parseInt(age_edit_text.getText().toString());
                patient.setAge(temp_age);
                Toast.makeText(this, "save "+patient.getGender()+patient.getAge(), Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(this,body_symp.class);
                startActivity(intent);

                break;

            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("denmee");


        int count_male=0;
        int count_female=0;

        Button button_male=findViewById(R.id.male_button);
        Button button_female=findViewById(R.id.female_button);
        Button button_save=findViewById(R.id.age_gender_save_button);
        age_edit_text = findViewById(R.id.age_text);

        button_female.setOnClickListener(this);
        button_male.setOnClickListener(this);
        button_save.setOnClickListener(this);


    }



}