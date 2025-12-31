package com.javaindex;

import java.io.PrintStream;
import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    final static int MONTHS = 12;
    final static int PERCENT = 100;

    public static void main(String[] args) {
        int numberOfPaidPayments = 0;


        int principal = (int) readInput("Principal ($1k - $1M): ",1000,1_000_000);
        float annualRate = (float) readInput("Annual Interest Rate: ", 0, 30);
        byte period = (byte) readInput("Period: ", 1,12);

        float monthlyRate = annualRate/MONTHS/PERCENT;
        int numberOfPayments = period * MONTHS;
        paymentSchedule(principal,monthlyRate,numberOfPayments,numberOfPaidPayments);

    }

    public static double readInput(String prompt,int min, int max){
        Scanner scanner = new Scanner(System.in);

        double value;
        while (true){
            System.out.print(prompt);
            value = scanner.nextDouble();
            if(value >= min && value <= max){
                break;
            }
            System.out.println("Enter a number between " + min + " and " + max);
        }
        return value;
    }

    public static float calcMortgage(int principal, float monthlyRate, int numberOfPayments){

        double numerator = principal * monthlyRate * Math.pow(1+ monthlyRate,numberOfPayments);
        double denominator = Math.pow(1+ monthlyRate,numberOfPayments) - 1;

        return (float) (numerator/denominator);
    }

    public static float getDebt(int principal, float monthlyRate, int numberOfPayments, int numberOfPaidPayments){
        float cPlusOne = 1+monthlyRate;
        double numerator = principal * (Math.pow(cPlusOne,numberOfPayments)-Math.pow(cPlusOne,numberOfPaidPayments));
        double denominator = Math.pow(cPlusOne,numberOfPayments) - 1;
        numberOfPaidPayments ++;
        return (float) (numerator/denominator);
    }

    public static void paymentSchedule(int principal, float monthlyRate, int numberOfPayments, int numberOfPaidPayments){
        float balance = getDebt(principal,monthlyRate,numberOfPayments,numberOfPaidPayments);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        float mortgage = calcMortgage(principal,monthlyRate,numberOfPayments);
        System.out.println("MORTGAGE:");
        System.out.println("_________");
        System.out.println("MonthlyPayments: "+ currency.format(mortgage));

        System.out.println("PAYMENT SCHEDULE");
        System.out.println("________________");

    }

}