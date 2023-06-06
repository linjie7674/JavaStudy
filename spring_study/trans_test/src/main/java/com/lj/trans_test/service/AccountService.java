package com.lj.trans_test.service;

public interface AccountService {
    void transferAccount(String outAccount, String inAccount, int money);
}
