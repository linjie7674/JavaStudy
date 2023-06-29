# Spring MVC Study
## Spring整合Tomcat
1. 在web.xml中，添加spring中的servlet：
    ```xml
    <servlet>
        <servlet-name>DispatcherServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:spring-web.xml</param-value>
        </init-param>
        <load-on-startup>2</load-on-startup>

    </servlet>
    ```
2. 在spring配置中添加mapper-scanner
    ```xml
    <context:component-scan base-package="com.lj.controller"><context:component-scan>
    ```
## 注解说明
- @RequestMapping
    - 可以用在方法上，也可以用在类上。当用在类上时，该类中所有的方法对应的访问地址都要先加上这个地址。
    - 函数的参数可以是自定义类，只要在类中提供set方法即可
    - value：映射路径，可以有多个值
    - method：请求方法（RequestMethod.GET等）
- @GetMapping
    - 针对GET请求的注释。
    - value：映射路径，可以有多个值
    - get方法传进来的参数名字，需要和函数的参数名字一致。
    - 如果同名的请求参数有多个，可以将对应的函数参数改为数组或List类型
- @PostMapping
    - 上传文件时：type需要设置为multipart-form-data；且函数参数名字需和请求参数名字一致；接受参数类型需要是MultipartFile，且需要导入common-fileupload包
- @PutMapping
- @DeleteMapping
- @RequestParam
    - 用处：
        - 当函数参数名字和请求参数名字不一致时，可以将函数参数映射给对应请求参数
        - 将多个数据直接和该函数参数绑定，而不是去new这个参数对象。比如修饰List类型参数
        - 可以修饰Map类型参数
    - required: 标注该参数是否是必须的，默认是false
    - defaultValue：该参数的默认值
- @RequestBody
    - 将请求体中的数据传给被@RequestBody修饰的参数，这个参数需要是String类型
- @PathVariable
    - 将请求路径中对应的变量赋给被@PathVariable修饰的参数
- @RequestHeader
    - 修饰参数，表示该参数接受请求头
    - value：如果指定了，就是接受指定名字的请求头；如果未指定，就是接受所有的请求头，那么参数的类型需要是```Map<String, String>```
- @CookieValue
    - 修饰参数，获取cookie中的值
    - value：指定获取cookie中哪个key的值
    - defaultValue：设置默认值
- 获取request和response对象
    - 直接在申明两个参数就行了
    ```java
    @RequestMapping
    ```
## 数据响应
### 转发和重定向
函数返回值前加上`forward:`是转发，加`redirect:`是重定向。
### 模型视图
```Java
public ModelAndView resoponse (ModelAndView modelView) {
}
```
### 直接返回字符串
在请求函数前加上`@ResponseBody`注解
- `@RestController`: 是`@ResponseBody`和`@Controller`的合并
### 返回Json格式字符串
直接将返回值改成你想转换成json字符串的实体类就可以了，spring会自动将该类转换成json字符串。（前提是spring已经添加了json handler才行）

## 拦截器
执行某个请求函数前，拦截器看是否该请求可以执行这个请求函数。
- 拦截器主要有三个函数：
    ```Java
    public boolean preHandle(){}

    public void postHandle(){}

    public void afterCompletion(){}
    ```
- 多个拦截器执行顺序：
假如有三个拦截器ljq1, ljq2 和 ljq3，执行顺序如下：

    `preHandle1` -> `preHandle2` -> `preHandle1` -> `postHandle3` -> `postHandle2` -> `postHandle1` -> `afterCompletion3` -> `afterCompletion2` -> `afterCompletion1`

    也就是说除了preHandle函数顺序执行，其余函数都是倒序执行。此外，afterCompletion是否执行，得看对应的preHandle返回值是否为true。

## 全注解开发
- 让web.xml加载spring配置类，而不是配置文件
    - servlet中定义了一个接口，我们只需实现该接口，并在MEAT-INF/services文件中创建一个javax.servlet.ServletContrainerInitializer文件，并把实现类的全限定名放进去就可以了。Spring中帮我们实现了一个抽象类和添加了对应的配置文件，因此我们只需要继承这个spring提供的抽象类就可以了。
- `@EnableWebMVC`
    
    相当于xml配置中的`<mvc:annotation-driven>`标签。
- 实现WebMvcConfigurer接口
    - configureDefaultServletHandling函数负责配置默认的Servlet Handler
    - addInterceptors函数负责添加拦截器
    ```Java
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(...);
    }
    ```