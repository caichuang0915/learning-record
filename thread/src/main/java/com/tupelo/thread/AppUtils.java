package com.tupelo.thread;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.UUID;
 
public class AppUtils {
    private final static String SYSTEM_NAME = "ZBCF_systemaccess";
    private final static String[] chars = new String[]{"a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};
 
    public static String getAppId() {
        StringBuffer shortBuffer = new StringBuffer();
        for (int j = 0; j < 3; j++) {
            String uuid = UUID.randomUUID().toString().replace("-", "");
            for (int i = 0; i < 8; i++) {
                String str = uuid.substring(i * 4, i * 4 + 4);
                int x = Integer.parseInt(str, 16);
                shortBuffer.append(chars[x % 0x3E]);
            }
        }
        return shortBuffer.toString();
 
    }
 
    public static String getAppSecret(String appId) {
        try {
            String[] array = new String[]{appId, SYSTEM_NAME};
            StringBuffer sb = new StringBuffer();
            Arrays.sort(array);
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]);
            }
            String str = sb.toString();
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes());
            byte[] digest = md.digest();
 
            StringBuffer hexstr = new StringBuffer();
            String shaHex = "";
            for (int i = 0; i < digest.length; i++) {
                shaHex = Integer.toHexString(digest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexstr.append(0);
                }
                hexstr.append(shaHex);
            }
            return hexstr.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static String[] getAppKey() {
        String[] result = new String[2];
        String appId = getAppId();
        String appSecret = getAppSecret(appId);
        result[0] = appId;
        result[1] = appSecret;
        return result;
    }
    
    
 
    public static void main(String[] args) {
        String[] appKey = getAppKey();
        System.out.println(appKey[0]);
        String appId = getAppId();
        String appSecret = getAppSecret(appId);
        System.out.println("appId: "+appId);
        System.out.println("appSecret: "+appSecret);
        System.out.println(appId.length());
        System.out.println(appSecret.length());
        
    }
}