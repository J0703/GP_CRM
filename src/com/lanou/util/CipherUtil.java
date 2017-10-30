package com.lanou.util;

/**
 * Created by dllo on 17/10/30.
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 对密码进行加密和验证的类
 */
public class CipherUtil {
    //十六进制下数字到字符的映射数组
    private final static String[] hexDigits={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

    /**
     * 加密
     * @param inputString  输入的字符串
     * @return
     */
    public  String generatePasswprd(String inputString){
        return encodeByMD5(inputString);
    }

    /**
     * 验证输入的密码是否正确
     * @param password 加密后的密码
     * @param inputString  输入的字符串
     * @return 验证结果
     */
    public  boolean validatePasword(String password,String inputString){
        if (password.equals(encodeByMD5(inputString))){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 对字符串进行MD5加密
     * @param originString
     * @return
     */

    private  String encodeByMD5(String originString){
        if (originString!=null){
            try {
                //创建具有指定算法名称的信息摘要
                MessageDigest md = MessageDigest.getInstance("MD5");
                //使用指定的字节数组对摘要进行最后的更新,然后完成摘要计算
                byte[] results = md.digest(originString.getBytes());
                //将得到的字节数组变成字符串返回
                String resultString = byteArrayToHexString(results);
                return resultString.toUpperCase();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 转换字节数组为十六进制的字符串
     * @param b 字节数组
     * @return 十六进制字符串
     */
    private  String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    /**
     * 将一个字节转化为十六进制形式的字符串
     * @param b
     * @return
     */
    private  String byteToHexString(byte b) {
        int n = b;
        if (n<0)
            n=256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];

    }


}
