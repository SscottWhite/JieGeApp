package com.ncstudy.toolutils;


import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;


/*
 * 3DES
	3DES（即Triple DES）是DES向AES过渡的加密算法，它使用3条56位的密钥对数据进行三次加密。
	是DES的一个更安全的变形。它以DES为基本模块，通过组合分组方法设计出分组加密算法。
	比起最初的DES，3DES更为安全。密钥长度默认为168位，还可以选择128位。
 */
//https://mp.weixin.qq.com/s/l7A6YwvIoXEVT3pyNdjP_g

public class DES3 {

    public static final String DES3KEY = "decdecdecdecdecdecdecdecdecde"; //长度24

    /**
     * 加密
     * @param src
     * @param key
     * @return
     */
    public static String encryptThreeDESECB(String src, String key) {
        try{
            DESedeKeySpec dks = new DESedeKeySpec(key.getBytes("UTF-8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
            SecretKey securekey = keyFactory.generateSecret(dks);

            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, securekey);
            byte[] b = cipher.doFinal(src.getBytes("UTF-8"));

            String ss = new String(Base64.encodeBase64(b));
            ss = ss.replaceAll("\\+", "-");
            ss = ss.replaceAll("/", "_");
            return ss;
        } catch(Exception ex){
            ex.printStackTrace();
            return src;
        }
    }

    /**
     * 解密
     * @param src
     * @param key
     * @return
     */
    public static String decryptThreeDESECB(String src, String key) {
        try{
            src = src.replaceAll("-", "+");
            src = src.replaceAll("_", "/");
            byte[] bytesrc = Base64.decodeBase64(src.getBytes("UTF-8"));
            // --解密的key
            DESedeKeySpec dks = new DESedeKeySpec(key.getBytes("UTF-8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
            SecretKey securekey = keyFactory.generateSecret(dks);

            // --Chipher对象解密
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, securekey);
            byte[] retByte = cipher.doFinal(bytesrc);

            return new String(retByte, "UTF-8");
        } catch(Exception ex){
            ex.printStackTrace();
            return src;
        }
    }
}

