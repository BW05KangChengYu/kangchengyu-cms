package com.kangchengyu.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 获取test中的注解 在
 * test类里都要extends这个类
 * @author apple
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class TestBase {

}
