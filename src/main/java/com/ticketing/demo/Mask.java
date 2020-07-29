package com.ticketing.demo;

public class Mask {
    public static String maskCardNumber(String cardNumber){
        int index = 0;
        StringBuilder maskedNumber = new StringBuilder();
        for (int i=0; i< cardNumber.length(); i++){
            if (i<6 || i> 11){
                maskedNumber.append(cardNumber.charAt(i));
            }
            else{
                maskedNumber.append("*");
            }
        }
        return maskedNumber.toString();
    }
}
