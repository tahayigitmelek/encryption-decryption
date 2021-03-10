package com.tahayigitmelek;

public class Decryption implements WhichMethod{
    @Override
    public String get(String text, int num, String alg) {
        char[] chars = text.toCharArray();
        String returnValue = "";
        char value;
        for (Character c : chars){
            if (alg.equals("shift")){
                if (c == ' '){
                    value = ' ';
                }else if (c == '!'){
                    value = '!';
                }else if (c-num >= 97){
                    value = (char)(c-num);
                }else {
                    value = (char)(((c-num)+123)-97);
                }
                returnValue += value;
            }
            else {
                returnValue += (char)(c-num);
            }

        }
        return returnValue;
    }
}
