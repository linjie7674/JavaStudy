package com.jielin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jielin.domain.Test_tb;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao_MP extends BaseMapper<Test_tb> {
}
