package io.github.igordonxiao.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Base64;

import io.github.igordonxiao.bean.Constants;

/**
 * 工具类-密码加密
 */
public class PwdUtil {

    /**
     * MD5加密
     *
     * @param content 待加密文本
     * @return
     */
    public static String md5(String content) {
        return encryption("MD5", content);
    }

    /**
     * SHA-1加密
     *
     * @param content 待加密文本
     * @return
     */
    public static String sha1(String content) {
        return encryption("SHA-1", content);
    }

    /**
     * MD5、SHA-1 等通用加密方法
     *
     * @param type
     * @param content
     * @return
     */
    private static String encryption(String type, String content) {
        MessageDigest curAlg = null;
        try {
            curAlg = MessageDigest.getInstance(type);
            byte[] b = content.getBytes("UTF-8");
            curAlg.update(b);
            byte[] hash = curAlg.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                int v = hash[i] & 0xFF;
                if (v < 16) {
                    hexString.append(0);
                }
                hexString.append(Integer.toString(v, 16));
            }
            return hexString.toString();
        } catch (Exception e) {
            Constants.LOG.error(e.getMessage());
        }
        return "";
    }

    /**
     * 字符串 base64编码
     *
     * @param str
     * @return
     */
    public static String strToBase64(Object obj) {

        try {
            return Base64.getEncoder().encodeToString(obj.toString().getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            Constants.LOG.info(e.getMessage());
            return Base64.getEncoder().encodeToString(obj.toString().getBytes());
        }
    }

    /**
     * base64编码的字符串解码
     *
     * @param b64Str
     * @return
     */
    public static String base64ToStr(String b64Str) {
        try {
            return new String(Base64.getDecoder().decode(b64Str), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Constants.LOG.info(e.getMessage());
            return new String(Base64.getDecoder().decode(b64Str));
        }
    }


    private static final int RADIX = 36;//可逆加密结果的进制（36表示36进制，表示加密结果可以为0-9，a-z一共36个字符）
    private static final String SEED = "MySEED2015";//可逆加密种子（种子不一样加密出来的结果不一样）

    /**
     * 可逆加密
     *
     * @param password
     * @return
     */
    public static final String xorEncrypt(String content) {
        if (content == null || content.length() == 0) return "";
        BigInteger bi_content = new BigInteger(content.getBytes());
        BigInteger bi = new BigInteger(SEED, RADIX);
        bi = bi.xor(bi_content);
        return bi.toString(RADIX).toLowerCase();
    }

    /**
     * 可逆加密的解密
     *
     * @param encrypted
     * @return
     */
    public static final String xorDecrypt(String encrypted) {
        if (encrypted == null || encrypted.length() == 0) return "";
        BigInteger bi_confuse = new BigInteger(SEED, RADIX);
        try {
            BigInteger bi = new BigInteger(encrypted.toLowerCase(), RADIX);
            bi = bi.xor(bi_confuse);
            return new String(bi.toByteArray());
        } catch (Exception e) {
            Constants.LOG.info(e.getMessage());
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(PwdUtil.md5("admin"));
    }

}
