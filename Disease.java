package com.example.webmd;

import android.widget.Toast;

import java.util.LinkedList;

public class Disease {
    private String name=new String();
    private LinkedList<Symptoms> symptomsD;

    Disease(){
        name="";
        symptomsD=new LinkedList<Symptoms>();
    }

    void addSymptom(Symptoms symptom){
        symptomsD.add(symptom);
    }

    void setName(String a){
        name=a;
    }

    void printDName(){
        System.out.println(name);
    }

    void printDisease(){

        printDName();

        for(int i=0;i<this.symptomsD.size();i++){
            this.symptomsD.get(i).printName();
            if(this.symptomsD.get(i).getKind()!=""){
                this.symptomsD.get(i).printKind();
            }
            if(this.symptomsD.get(i).getImportance()!=0){
                this.symptomsD.get(i).printImportance();
            }
        }
    }
}
