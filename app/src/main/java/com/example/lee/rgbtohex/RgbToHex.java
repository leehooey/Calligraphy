package com.example.lee.rgbtohex;

/**
 * Created by Lee on 2015/11/14.
 */
public class RgbToHex {
    public static String getHex(int r,int g,int b){
        String str="#";
        str=str+getHexPart(r)+getHexPart(g)+getHexPart(b);
        return str;
    }
    public static String getHexPart(int numb){
        String str="";
        int n=numb/16;
        str+=digitalToABC(n);
        int n1=numb-n*16;
        str+=digitalToABC(n1);
        return str;
    }
    public static String digitalToABC(int numb){
        String str=numb+"";
        if(numb<=9){
            return numb+"";
        }else if(numb==10){
            return "A";
        }else if(numb==11){
            return "B";
        }else if(numb==12){
            return "C";
        }else if(numb==13){
            return "D";
        }else if(numb==14){
            return "E";
        }else if(numb==15){
            return "F";
        }
        return str;
    }
}
