package com.css.trainmember;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

@SpringBootTest
class TrainMemberApplicationTests {

    @Test
    void contextLoads() throws NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher.getInstance("AES");
    }

}
