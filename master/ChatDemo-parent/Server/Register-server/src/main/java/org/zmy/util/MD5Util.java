package org.zmy.util;


import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    public static String encoder(String password,String salt){
        String result = "";
        try {
            String input = salt + password + salt;
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for(byte b : digest){
                sb.append(b);
            }
            result = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
}
