//package com.example.demo;
//
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.util.Objects;
//import java.util.concurrent.TimeUnit;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.api.Assumptions.*;
//
////@SpringBootTest //使用springboot容器中的组件
//public class Junit5Test {
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    /**
//     * 前面的断言失败，后面的代码不会执行
//     */
//    @DisplayName("测试简单断言")
//    @Test
//    void testSimpleAssertions(){
//        assertEquals(5,2+3,"业务逻辑计算出错");//前面的参数是预期，后面的参数是真实值
//    }
//
//
//
//
//    @Test
//    @DisplayName("测试前置条件")
//    public void simpleAssume() {
//        Assumptions.assumeTrue(true,"结果不是true，会跳过");
//        assumeFalse(false,"结果不是false");
//    }
//
//    @Test
//    @DisplayName("assume then do")
//    public void assumeThenDo() {
//        assumingThat(
//                Objects.equals("DEV", "DEV"),
//                () -> System.out.println("In DEV")
//        );
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    @DisplayName("测试displayname注解")
//    @Test
//    void testDisplayName(){
//        System.out.println(1);
//    }
//
//    @BeforeEach
//        //在每个单元测试开始前会执行
//    void testBeforeEach(){
//        System.out.println("测试就要开始了");
//    }
//    @AfterEach//在每个单元测试结束后会执行
//    void testAfterEach(){
//        System.out.println("测试就要开始了");
//    }
//
//    @AfterAll//在每个单元测试结束后会执行，必须是静态方法
//    static void testAfterAll(){
//        System.out.println("测试就要开始了");
//    }
//
//    //规定超时时间，超出这个时间会抛出异常
//    @Timeout(value = 500,unit = TimeUnit.MICROSECONDS)
//    @Test
//    void testTimeOut() throws InterruptedException {
//        Thread.sleep(500);
//    }
//
//    @RepeatedTest(5)//重复测试5次
//    @Test
//    void test3(){
//        System.out.println(5);
//    }
//
//}
