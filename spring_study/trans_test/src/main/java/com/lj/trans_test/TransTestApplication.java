package com.lj.trans_test;

import java.util.Arrays;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;
import com.lj.trans_test.config.SpringConfig;
import com.lj.trans_test.service.AccountService;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

@SpringBootApplication
public class TransTestApplication {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(args));
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		AccountService accountService = (AccountService) context.getBean("accountService");
		accountService.transferAccount("xiaoming", "xiaohua", 100);
		// DruidDataSource druidDataSource = (DruidDataSource) context.getBean("druidDataSource");;
		// System.out.println(druidDataSource.getUsername());
	}

}
