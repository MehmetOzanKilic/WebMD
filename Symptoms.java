package com.example.webmd;

public class Symptoms {
    private int name;
    private String kind=new String();
    private int importance;

    Symptoms(String x,int y,int z){
        kind=x;
        name=y;
        importance=z;
    }

    void printName(){
        System.out.println(name);
    }
    void printKind(){
        if(kind!=""){System.out.println(kind);}
    }
    void printImportance(){
        if(importance!=0){System.out.println(importance);}
    }
    void setName(int a){
        name = a;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    void addKind(String a){
        kind = a;
    }

    void clear(){
        name=15;

    }
    String getKind(){
        return kind;
    }
    int getImportance(){
        return importance;
    }
    int getName(){
        return name;
    }
}
