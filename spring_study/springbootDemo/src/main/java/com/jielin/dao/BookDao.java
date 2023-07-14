package com.jielin.dao;

import com.jielin.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookDao {
    @Select("select * from test_tb where id = #{id}")
    public Book getById(Integer id);

    @Select("select * from test_tb")
    public List<Book> getAll();
}
