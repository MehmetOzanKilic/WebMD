package com.example.webmd;

import java.util.LinkedList;

public class Patient {
    private String problem=new String();
    private LinkedList<Symptoms> symps=new LinkedList<Symptoms>();
    private int sympCount;
    private int matchingSymp;
    private double prob;
    private int age;
    private boolean gender;

    void printSymps(){
        for(int i=0;i<this.symps.size();i++){
            this.symps.get(i).printName();
            if(this.symps.get(i).getKind()!=""){
                this.symps.get(i).printKind();
            }
        }
    }

    int sympCounter(){

        return sympCount=symps.size();
    }

    void setGender(boolean flag){
        gender=flag;
    }

    boolean getGender(){
        return gender;
    }

    void setAge(int x){
        age=x;
    }

    int getAge(){
        return age;
    }

    int matchingSympCounter(LinkedList<Integer> ll){

        int counter=0;

        for(int i=0;i<ll.size();i++){
            for(int j=0;j<symps.size();j++){
                if(ll.get(i)==symps.get(j).getName()) {
                    counter++;
                }
            }
        }

        return counter;
    }

    void addSymptom(Symptoms symptom){
        symps.add(symptom);
    }

    int probCal(){
        return matchingSymp/sympCount;
    }
}
