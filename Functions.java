package com.example.webmd;

import java.util.Scanner;

public class Functions {
    public void getSymptoms(String symp){


        Patient patient=new Patient();

        String input=symp;

        String temp=new String();
        String tempk = new String();

        for(int i=0;i<input.length();i++){

            if(input.charAt(i)==',' || input.charAt(i)=='-'){
                if(temp!="" && input.charAt(i)==','){
                    Symptoms tempSym = new Symptoms("",0,0);
                    tempSym.addKind(tempk);
                    int intTemp=Integer.parseInt(temp);
                    tempSym.setName(intTemp);
                    patient.addSymptom(tempSym);
                    temp="";
                    tempk="";

                }

                if(temp!="" && input.charAt(i)=='-'){


                    i++;
                    while(input.charAt(i)!=','){
                        tempk+=input.charAt(i);
                        i++;
                    }
                    i--;

                }
                //i--;
            }

            else{
                temp+=input.charAt(i);

            }
        }

        System.out.println("Here are the symps");
        patient.printSymps();
        System.out.println("There are this much symps: "+patient.sympCounter());
    }
    public void addDisease(String name,String symp){

        System.out.println("burda");
        Disease disease=new Disease();
        //Scanner scanner=new Scanner(System.in);
        String input;
        disease.setName(name);


        System.out.println("Enter disease symptoms");
        input=symp;

        String temp=new String();
        String tempk = new String();
        int tempI=0;

        for(int i=0;i<input.length();i++){

            if(input.charAt(i)==',' || input.charAt(i)=='-' || input.charAt(i)=='/'){
                if(temp!="" && input.charAt(i)==','){
                    Symptoms tempSym = new Symptoms("",0,0);
                    tempSym.addKind(tempk);
                    tempSym.setImportance(tempI);
                    int intTemp=Integer.parseInt(temp);
                    tempSym.setName(intTemp);
                    disease.addSymptom(tempSym);
                    temp="";
                    tempk="";
                    tempI=0;
                }

                else if(temp!="" && input.charAt(i)=='-'){
                    i++;

                    while(input.charAt(i)!=',' && input.charAt(i)!='/'){
                        tempk+=input.charAt(i);

                        i++;

                    }
                    i--;


                }

                else if(temp!="" && input.charAt(i)=='/'){
                    i++;

                    while(input.charAt(i)!=',' && input.charAt(i)!='-'){
                        tempI=(tempI*10)+Character.getNumericValue(input.charAt(i));
                        i++;

                    }
                    i--;


                }

            }

            else{
                temp+=input.charAt(i);
            }
        }

        System.out.println("Here are the symps");
        disease.printDisease();
        //System.out.println("There are this much symps: "+patient.sympCounter());
    }
}
