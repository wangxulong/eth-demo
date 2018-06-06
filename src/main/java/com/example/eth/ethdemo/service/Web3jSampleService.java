package com.example.eth.ethdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;

import java.io.IOException;

/**
 * Created by wxl on 2018/6/6.
 *
 * @author wxl
 */
@Service
public class Web3jSampleService {
    @Autowired
    private Web3j web3j;

    public String getClientVersion() throws IOException {
        Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().send();
        return web3ClientVersion.getWeb3ClientVersion();
    }

}
