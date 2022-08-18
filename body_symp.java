package com.example.webmd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class body_symp extends AppCompatActivity {

    int click_counter=0;
    boolean is_clicked=false;
    ImageView head_img;
    ImageView arms_img;
    Animation aniFade;
    static int symp_save_counter=0;
    static LinkedList<String> symp_ll=new LinkedList<String>();
    TextView symp_text;
    EditText symp_edit;
    String string_temp="";


    static int get_counter(){
        return symp_save_counter;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("onCreate");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_body_symp);
        head_img=(ImageView) findViewById(R.id.head_image);
        arms_img=(ImageView) findViewById(R.id.arms_image);
        Button turn_button=findViewById(R.id.turn_body);
        aniFade= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);

        turn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(body_symp.this, "yes", Toast.LENGTH_SHORT).show();
                switch (view.getId()) {
                    case R.id.turn_body:
                        if(click_counter==0){
                            findViewById(R.id.body_image).setVisibility(View.INVISIBLE);
                            findViewById(R.id.body_image_back).setVisibility(View.VISIBLE);
                            front_invisible();
                            click_counter=1;
                        }
                        else if(click_counter==1){
                            findViewById(R.id.body_image).setVisibility(View.VISIBLE);
                            findViewById(R.id.body_image_back).setVisibility(View.INVISIBLE);
                            click_counter=0;
                        }
                        break;

                    default:
                        break;
                }
            }
        });

        Button head_button=findViewById(R.id.head_button);
        head_button.setBackgroundColor(Color.TRANSPARENT);
        head_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(body_symp.this, "head", Toast.LENGTH_SHORT).show();
                   if(is_clicked==false) {
                       clicked(view);
                   }
                   else if(is_clicked==true){
                       clicked_before(view);
                   }

                }

            });

        Button right_arm_button = findViewById(R.id.right_arm_button);
        right_arm_button.setBackgroundColor(Color.TRANSPARENT);
        right_arm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(body_symp.this, "right", Toast.LENGTH_SHORT).show();
                if(is_clicked==false) {
                    clicked(view);
                }
                else if(is_clicked==true){
                    clicked_before(view);
                }
            }
        });
        Button left_arm_button = findViewById(R.id.left_arm_button);
        left_arm_button.setBackgroundColor(Color.TRANSPARENT);
        left_arm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(body_symp.this, "left", Toast.LENGTH_SHORT).show();
                if(is_clicked==false) {
                    clicked(view);
                }
                else if(is_clicked==true){
                    clicked_before(view);
                }
            }
        });

        Button symp_save_button=findViewById(R.id.symp_save_button);
        symp_save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                symp_text = findViewById(R.id.symp_box_text);
                symp_edit = findViewById(R.id.symp_edit_text);

                if(!symp_edit.getText().toString().isEmpty()){
                    symp_save_counter++;
                }

                String temp="";
                temp = symp_text.getText().toString();
                Toast.makeText(body_symp.this, symp_text.getText().toString(), Toast.LENGTH_SHORT).show();
                if (temp.isEmpty()) {
                    System.out.println("symp_edit"+symp_edit.getText().toString());
                    symp_ll.add(symp_edit.getText().toString());
                }
                else{
                    System.out.println("symp_edit else"+symp_edit.getText().toString());
                    symp_ll.add("     " + symp_edit.getText().toString());
                }

                symp_edit.setText("");
                show_symps();

            }
        });

        Button symp_delete_button=findViewById(R.id.symp_delete_button);
        symp_delete_button.setBackgroundColor(Color.TRANSPARENT);
        symp_delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(body_symp.this,pop_up.class));
            }
        });

    }



    public void clicked(View view){

        switch(view.getId()){
            case R.id.head_button:
                Toast.makeText(body_symp.this, "head", Toast.LENGTH_SHORT).show();
                head_img.startAnimation(aniFade);
                head_img.setVisibility(View.VISIBLE);
                is_clicked=true;
                break;

            case R.id.left_arm_button:
            case R.id.right_arm_button:
                Toast.makeText(body_symp.this, "arm", Toast.LENGTH_SHORT).show();
                arms_img.startAnimation(aniFade);
                arms_img.setVisibility(View.VISIBLE);
                is_clicked=true;
                break;
            }
        }


    public void clicked_before(View view){

        switch(view.getId()){
            case R.id.head_button:
                arms_img.setVisibility(View.INVISIBLE);
                Toast.makeText(body_symp.this, "head_before", Toast.LENGTH_SHORT).show();
                head_img.startAnimation(aniFade);
                head_img.setVisibility(View.VISIBLE);
                break;

            case R.id.left_arm_button:
            case R.id.right_arm_button:
                head_img.setVisibility(View.INVISIBLE);
                Toast.makeText(body_symp.this, "arm_before", Toast.LENGTH_SHORT).show();
                arms_img.startAnimation(aniFade);
                arms_img.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void front_invisible(){
        arms_img.setVisibility(View.INVISIBLE);
        head_img.setVisibility(View.INVISIBLE);
        is_clicked=false;
    }

    public void show_symps() {

            System.out.println("size"+symp_ll.size());
            for(int i=0;i<symp_ll.size();i++){
                if(symp_ll.get(i)!=null){
                    string_temp+=symp_ll.get(i);
                }
                else if(symp_ll.get(i)!=null){
                    Toast.makeText(this, "null found", Toast.LENGTH_SHORT).show();
                }
            }
            symp_text.setText(string_temp);
            string_temp="";
        }


}
