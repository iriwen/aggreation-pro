package com.java.code.codec;

import com.java.code.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

/**
 * created by yuxiaodong01 on 2021/04/20.
 */
@Slf4j
public class AesCodec {


    public static final String encryptionKey = "book-storef00a08";

    //初始向量（偏移）,私钥：aaBBccDDeeffggHH
    private static final String VIPARA = "aaBBccDDeeffggHH";   //AES 为16bytes. DES 为8bytes

    public static void main(String[] args) {

        String cleartext = "{\n" +
                "\t\"applyId\": 74584,\n" +
                "\t\"orderSource\": \"2\",\n" +
                "\t\"cpId\": 75009,\n" +
                "\t\"cpName\": \"yHVoDFBFtO\",\n" +
                "\t\"applyUserId\": 75547,\n" +
                "\t\"applyUserName\": \"2O4pirZCi\",\n" +
                "\t\"deptName\": \"5xiSG95Gia\",\n" +
                "\t\"bizNumber\": \"G3HZjkTGPT\",\n" +
                "\t\"batchNumber\": 94334,\n" +
                "\t\"sceneType\": 869,\n" +
                "\t\"activeTime\": \"2020-10-20 10:11:20\",\n" +
                "\t\"applyCardForm\": 10323,\n" +
                "\t\"useApplyCardTypeList\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"applyCardTypeId\": 75781,\n" +
                "\t\t\t\"cardType\": 699,\n" +
                "\t\t\t\"canUseTime\": 144,\n" +
                "\t\t\t\"amoutOrTimes\": 554,\n" +
                "\t\t\t\"applyNum\": 9882,\n" +
                "\t\t\t\"bindingEndTime\": \"2020-10-20 10:11:20\",\n" +
                "\t\t\t\"useEndTime\": \"2022-10-20 10:11:20\",\n" +
                "\t\t\t\"cardRange\": \"VtFqiJhc\",\n" +
                "\t\t\t\"prePrice\": 882\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"applyCardTypeId\": 76186,\n" +
                "\t\t\t\"cardType\": 520,\n" +
                "\t\t\t\"canUseTime\": 1612,\n" +
                "\t\t\t\"amoutOrTimes\": 3260,\n" +
                "\t\t\t\"applyNum\": 884,\n" +
                "\t\t\t\"bindingEndTime\": \"2020-10-20 10:11:20\",\n" +
                "\t\t\t\"useEndTime\": \"2021-10-20 10:11:20\",\n" +
                "\t\t\t\"cardRange\": \"oj3I2VELyE\",\n" +
                "\t\t\t\"prePrice\": 194\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"applyCardTypeId\": 76884,\n" +
                "\t\t\t\"cardType\": 801,\n" +
                "\t\t\t\"canUseTime\": 1633,\n" +
                "\t\t\t\"amoutOrTimes\": 977,\n" +
                "\t\t\t\"applyNum\": 2621,\n" +
                "\t\t\t\"bindingEndTime\": \"2020-10-20 10:11:20\",\n" +
                "\t\t\t\"useEndTime\": \"2021-10-20 10:11:20\",\n" +
                "\t\t\t\"cardRange\": \"6ZErnGB6N4\",\n" +
                "\t\t\t\"prePrice\": 702\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";

        try {
            IvParameterSpec zeroIv = new IvParameterSpec(VIPARA.getBytes());
            //两个参数，第一个为私钥字节数组， 第二个为加密方式 AES或者DES
            SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes(), "AES");
            //实例化加密类，参数为加密方式，要写全
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);

            byte[] encryptedData = cipher.doFinal(cleartext.getBytes(StandardCharsets.UTF_8));
            String result = Base64.encodeBase64URLSafeString(encryptedData);
            log.info("result : {}",result);

            decryptBody(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String decryptBody(String encryptedBody) {
        try {
            //将字符串转化为base64编码的字节数组
            byte[] encryptedBase64Bytes = encryptedBody.getBytes();
            //将base64编码的字节数组转换为在加密之后的字节数组
            byte[] byteMi = Base64.decodeBase64(encryptedBase64Bytes);
            IvParameterSpec zeroIv = new IvParameterSpec(VIPARA.getBytes());
            SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
            byte[] decryptedData = cipher.doFinal(byteMi);
            String clear = new String(decryptedData, StandardCharsets.UTF_8);

            CouponDto couponDto = JsonMapper.getMapper().readValue(clear, CouponDto.class);
            log.info("coupon:{}",JsonMapper.toJsonString(couponDto));
            return clear ;

        } catch (Exception e) {
            log.error("decrypt failed : {}", e.getCause().getMessage());
            e.printStackTrace();
            return "";
        }
    }

}




