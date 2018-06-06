package com.example.eth.ethdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by wxl on 2018/6/6.
 *
 * @author wxl
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Web3jSampleServiceTest {
    @Autowired
    private Web3jSampleService web3jSampleService;
    @Test
    public void getClientVersion() throws Exception{
        log.info("web3j version=== : {}",web3jSampleService.getClientVersion());
    }
}