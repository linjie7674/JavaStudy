# 整合第三方技术
## JUnit
直接在test类中写就可以了。

注意，测试类的包需要在引导类中所在包及其子包中。否则的话，
需要在@SpringBootTest注解中添加classes参数，
其值应为引导类类名。
## MyBatis
1. 导入相关的maven坐标
    ```xml
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>2.2.0</version>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
    ```
2. 添加相关属性
    ```yaml
    spring:
      datasource:
        driver-class-name: com.mysql.jdbc.Driver
        url: jdbc:mysql://localhost:3306/test_db
        username: root
        password: 123456
    ```
3. 实现实体类
   ```java
   package com.jielin.domain;

   public class Book {
   private String name;
   private String owner;
   private int id;

       @Override
       public String toString() {
           return "Book{" +
                   "name='" + name + '\'' +
                   ", owner='" + owner + '\'' +
                   ", id=" + id +
                   '}';
       }

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

       public String getOwner() {
           return owner;
       }

       public void setOwner(String owner) {
           this.owner = owner;
       }

       public int getId() {
           return id;
       }

       public void setId(int id) {
           this.id = id;
       }
   }
   ```
4. 实现数据层
   ```java
   @Mapper
   public interface BookDao {
   @Select("select * from test_tb where id = #{id}")
   public Book getById(Integer id);

       @Select("select * from test_tb")
       public List<Book> getAll();
   }
   ```
## MyBatis-Plus
1. 导入对应maven坐标
2. 继承BaseMapper