package com.lj.trans_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lj.trans_test.mapper.AccountMapper;

@Service("accountService")
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountMapper accountMapper;    

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    @Override
    public void transferAccount(String outAccount, String inAccount, int money) {
        int res = accountMapper.decrMoney(inAccount, money);
        System.out.println("decrease sender's money result: " + res);
        int a = 1 / 0;
        res = accountMapper.incrMoney(outAccount, money);
        System.out.println("increase sender's money result: " + res);
        System.out.println("Transfer successfully!");
    }
    
}
