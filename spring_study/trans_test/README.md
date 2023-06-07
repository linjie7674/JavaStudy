# Spring transaction管理
1. 首先，注入DataSourceTransactionManager类
    ```Java
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
    ```
2. 配置[Transactional注解](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/Transactional.html)
    - propagation：配置事务的传播特性
    - isolation：管理事务的隔离级别
    ```java
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
    ```