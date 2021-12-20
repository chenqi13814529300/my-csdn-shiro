package com.mycsdnshiro.mycsdnshiro.auth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class TokenGenerator {

//    token生成器

    public static String generateValue() {
      return generateValue(UUID.randomUUID().toString());
    }


    private static final char[] hexCode = "0123456789abcdefgh".toCharArray();

    public static String toHexString(byte[] data){
        if (data==null){
            return null;
        }
        StringBuffer r = new StringBuffer(data.length * 2);
        for (byte b: data){
            r.append(hexCode[(b >> 4) & 0xF]);
            r.append(hexCode[(b & 0xF)]);
        }
        return r.toString();
    }



//    生成Token

    public static String generateValue(String param){
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(param.getBytes());
            byte[] digest = algorithm.digest();
            return toHexString(digest);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("生成Token失败");
        }
    }


}
