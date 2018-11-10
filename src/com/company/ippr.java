package com.company;

import java.util.ArrayList;
import java.util.List;

class ippr {
    public List<String> restoreIpAddresses(String s) {
        List<String> list= new ArrayList<>();

        for(int i=1;i<4 && i<s.length();i++){
            String first = s.substring(0,i);
            if( validate(first) ){
                for(int j=1; i+j < s.length() && j<4;j++){
                    String second = s.substring(i,i+j);
                    if(validate(second)){
                        for(int k=1; i+j+k < s.length() && k<4;k++){
                            String third = s.substring(i+j,i+j+k);
                            String fourth = s.substring(i+j+k);
                            if(validate(third) && validate(fourth)){
                                list.add(first+"."+second+"."+third+"."+fourth);
                            }
                        }
                    }
                }
            }
        }

        return list;
    }

    public boolean validate(String s){
        if( s.length() > 3 &s.startsWith("0") && s.length()>1){
            return false;
        }

        int val= Integer.parseInt(s);
        return val<=255 && val>=0;
    }

    public static void main(String[] args){
        ippr ippr1 = new ippr();
        ippr1.restoreIpAddresses("25525511135").stream().forEach(System.out::println);
    }
}
