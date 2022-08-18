package com.example.webmd;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class pop_up extends Activity {
    LinearLayout layout;
    RelativeLayout relativeLayout;
    body_symp obj=new body_symp();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);

        layout=findViewById(R.id.ll_deneme);
        relativeLayout=findViewById(R.id.rl_deneme);

        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int pop_width=dm.widthPixels;
        int pop_height=dm.heightPixels;

        getWindow().setLayout((int)(pop_width*.8),(int) (pop_height*.6));

        show_sypms();



    }

    public void show_sypms(){

        int n=body_symp.get_counter();

        for (int i = 0; i < n; i++) {
            final TextView tv = new TextView(this); // Prepare textview object programmatically
            tv.setText(body_symp.symp_ll.get(i).replace("     ",""));
            final Button bt = new Button(this);
            bt.setLayoutParams(new LinearLayout.LayoutParams(150,120));
            bt.setId(105+i);
            bt.setText("");
            bt.setText("DELETE");
            bt.setTextSize(10);
            bt.setWidth(20);
            bt.setHeight(10);
            tv.setTextSize(25);
            tv.setId(5+i);
            tv.setPadding(10,10+(i*120),10,10);
            bt.setPadding(10,10,10,10);

            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    tv.setText("");
                    int n=bt.getId();
                    n-=105;
                    body_symp.symp_ll.remove(n);
                    bt.setBackgroundColor(Color.TRANSPARENT);
                    bt.setText("");

                    Intent intent=new Intent(pop_up.this,body_symp.class);
                    //TODO instead of creating another class por the popup use its xml to call it so
                    // you dont have to exchange info between classes.
                    obj.show_symps();



                }
            });


            relativeLayout.addView(tv);
            layout.addView(bt);// Add to your ViewGroup using this method
        }
    }

}
