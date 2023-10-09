/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emo.temp;

import java.util.Scanner;

/**
 *
 * @author Emo_CPE
 */
public class EmoTemp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
  Scanner input =new java.util.Scanner (System.in);
  
  System.out.println("Welcome to Francine Temperature Converter");
System.out.println(  "1.C -> F "
                    + "2.F -> C "
                    + "3.K -> F "
                    + "4.K -> C "
                    + "5.C -> K "
                    + "6.F -> K ");
       
                   
System.out.println("Select Convertion");
int a= input .nextInt();

if (a==1){
    System.out.println("Enter Temperature");
    double b = input.nextInt();
System.out.println("the answer is" + ((b*9/5)+32)+ "Fahrenheit" );
}else if (a==2){
    System.out.println("Enter Temperature");
    double b = input.nextInt();
System.out.println("the answer is" + ((b-32)*5/9)+ "Celcius" );
}else if (a==3){
    System.out.println("Enter Temperature");
    double b = input.nextInt();
System.out.println("the answer is" + (((b-273.15)*1.8)+32 )+ "Fahrenheit" );
}else if (a==4){
    System.out.println("Enter Temperature");
    double b = input.nextInt();
System.out.println("the answer is" + (b-273.15)+ "Celcius" );
}else if (a==5){
    System.out.println("Enter Temperature");
    double b = input.nextInt();
System.out.println("the answer is" + (b+273.15)+ "Kelvin" );
}else if (a==6){
    System.out.println("Enter Temperature");
    double b = input.nextInt();
System.out.println("the answer is" + (b+273.15)+ "Kelvin" );


}
    }   
    
    
}
