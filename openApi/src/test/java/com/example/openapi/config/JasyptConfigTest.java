package com.example.openapi.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class JasyptConfigTest {

    private static StandardPBEStringEncryptor encryptor;
    private String plainText = "hello";
    private static String key = "testKey";

    @BeforeAll
    static void beforeSetting() {
        encryptor = new StandardPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(key);
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.NoIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
    }

    @Test
    void encrypt() {
        String encryptText = encryptor.encrypt(plainText);
        System.out.println("encryptText : " + encryptText);
    }

    @Test
    void decrypt() {
        String encryptText = "ye+XFXq9h2pY2VnLVOm7QQ==";
        String decryptText = encryptor.decrypt(encryptText);
        System.out.println("decryptText : " + decryptText);
    }

//    @Test
//    void jasypt(){
//        String key = "testKey";
//        String plainText = "hello";
//
//        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
//        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
//        config.setPassword(key);
//        config.setAlgorithm("PBEWithMD5AndDES");
//        config.setKeyObtentionIterations("1000");
//        config.setPoolSize("1");
//        config.setProviderName("SunJCE");
//        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
//        config.setIvGeneratorClassName("org.jasypt.iv.NoIvGenerator");
//        config.setStringOutputType("base64");
//        encryptor.setConfig(config);
//
//        String encryptText = encryptor.encrypt(plainText);
//        System.out.println("encryptText : " + encryptText);
//        String decryptText = encryptor.decrypt(encryptText);
//        System.out.println("decryptText : " + decryptText);
//
//        Assertions.assertThat(plainText).isEqualTo(decryptText);
//    }

}