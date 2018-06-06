package com.example.eth.ethdemo.service;

import com.sun.jmx.snmp.tasks.ThreadService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by wxl on 2018/6/6.
 *
 * @author wxl
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AdminTest {
    public static final String KEY_FILE = "C:\\Users\\wxl\\testNet\\keystore";

    @Autowired
    private Admin admin;
    @Autowired
    private Web3j web3j;

    @Test
    public void testCreateAccount() throws Exception {
        String fileName = WalletUtils.generateNewWalletFile("admin123", new File(KEY_FILE), true);
        log.info("new account fileName:{}", fileName);
    }

    @Test
    public void testAdmin() throws IOException {
        PersonalUnlockAccount personalUnlockAccount =
                admin.personalUnlockAccount("0xf24387fc761df8357d083ed5d3824a36be9cfd16", "admin122").send();
        try {
            if (personalUnlockAccount.accountUnlocked()) {
                // send a transaction;
                log.info("right password");
            }
        } catch (Exception e) {
            //TODO 密码无效
        }


    }

    @Test
    public void testNonce() throws ExecutionException, InterruptedException {
        for(int i = 0;i<5;i++){
            EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount("0xf24387fc761df8357d083ed5d3824a36be9cfd16",
                    DefaultBlockParameterName.PENDING).sendAsync().get();
            BigInteger nonce = ethGetTransactionCount.getTransactionCount();
            log.info("nonce is {}",nonce.toString());
        }

    }
}
