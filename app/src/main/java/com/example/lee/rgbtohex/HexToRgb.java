package com.example.lee.rgbtohex;

/**
 * Created by Lee on 2015/11/14.
 */
public class HexToRgb {
    public static int[] getRgb(String hex) {
        int[] num = new int[3];
        String[] str = new String[3];
        str[0] = hex.substring(1, 3);
        str[1] = hex.substring(3, 5);
        str[2] = hex.substring(5, 7);
        num[0]=getRgbPart(str[0]);
        num[1]=getRgbPart(str[1]);
        num[2]=getRgbPart(str[2]);
        return num;
    }

    public static int getRgbPart(String str){
        int numb;
        String []st=new String[2];
        st[0]=str.substring(0,1);
        st[1]=str.substring(1);
        int a=ABCtodigital(st[0]);
        int b=ABCtodigital(st[1]);
        numb=a*16+b;
        return numb;
    }
    public static int ABCtodigital(String str){
        if(str.equals("A")){
            return 10;
        }else if(str.equals("B")){
            return 11;
        }else if(str.equals("C")){
            return 12;
        }else if(str.equals("D")){
            return 13;
        }else if(str.equals("E")){
            return 14;
        }else if(str.equals("F")){
            return 15;
        }else{
            return Integer.parseInt(str);
        }
    }
}
