package com.xian.room.util;

import java.security.MessageDigest;

public class Md5Util {
	 public static String md5(String source){  
	        String des = "";  
	        try {  
	            MessageDigest md = MessageDigest.getInstance("MD5");  
	            byte[] result = md.digest(source.getBytes());  
	            StringBuilder buf = new StringBuilder();  
	            for (int i=0;i<result.length;i++) {  
	                byte b = result[i];  
	                buf.append(String.format("%02X", b));  
	            }  
	            des = buf.toString().toLowerCase();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            throw new RuntimeException("md5 failure");  
	        }  
	        return des;  
	    }  
	    public static void main(String[] args) {  
	        System.out.println(Md5Util.md5("157701"));  
	    }
}
