package com.jielin;

import com.jielin.dao.BookDao;
import com.jielin.dao.BookDao_MP;
import com.jielin.domain.Book;
import com.jielin.domain.Test_tb;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootDemoApplicationTests {

	@Autowired
	private BookDao dao;
	@Autowired
	private BookDao_MP dao_mp;

	@Test
	void testMyBatis() {
		System.out.println("getById");
		System.out.println(dao.getById(2));
		System.out.println("---------------------------");
		List<Book> all = dao.getAll();
		System.out.println("all.size: " + all.size());
		all.forEach(x->{
			System.out.println(x);
		});
	}

	@Test
	void testMyBatisPlus(){
		System.out.println(dao_mp.selectById(2));
		System.out.println("-------------------------");
		List<Test_tb> all = dao_mp.selectList(null);
		System.out.println("all.size: " + all.size());
		System.out.println(all);
	}

}
