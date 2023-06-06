package com.lj.trans_test.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface AccountMapper {
    
    @Update("update account set money = money + #{money} where name = #{account}")
    public int incrMoney(@Param("account") String account, @Param("money") int money);
    @Update("update account set money = money - #{money} where name = #{account}")
    public int decrMoney(@Param("account") String account, @Param("money") int money);
}
