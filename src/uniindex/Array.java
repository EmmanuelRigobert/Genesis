package com.uniindex;

import java.util.Scanner;

public class Array {

    public static void main(String[] args){
        int newCounter = 0;
        int oldCounter = 0;
//        int[] myArray = {26,40,28,26,28,29,31,33,29,21};
        int[] myArray = new int[5];
        Scanner scanner = new Scanner(System.in);

        int youngestAge=0;
        int oldestAge=0;

        for(int i =0; i<myArray.length; i++){
            System.out.print("Enter your age: ");
            myArray[i] = scanner.nextInt();

            youngestAge = (youngestAge==0)? myArray[i]:youngestAge;
            oldestAge = (oldestAge==0)?myArray[i]:oldestAge;

            if(myArray[i]==youngestAge){
                newCounter++;
            }else if(myArray[i]<youngestAge){
                youngestAge=myArray[i];
                newCounter = 1;
            }
            if(myArray[i]==oldestAge){
                oldCounter++;
            }else if(myArray[i]>oldestAge){
                oldestAge=myArray[i];
                oldCounter = 1;
            }

        }
        System.out.println("Youngest Age is : " + youngestAge + " and it appears " + newCounter + " time(s).");
        System.out.println("Oldest Age is : " + oldestAge + " and it appears " + oldCounter + " time(s).");

    }
}
