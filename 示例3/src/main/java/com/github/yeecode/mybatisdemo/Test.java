package com.github.yeecode.mybatisdemo;

import org.apache.ibatis.reflection.property.PropertyCopier;

/**
 * 类注释，描述
 *
 * @author caojx created on 2021/1/26 8:54 下午
 */
public class Test {

    public static void main(String[] args) {
        Sub sub1 = new Sub();
        sub1.setName("sub1");
        sub1.setAge(18);

        Sub sub2 = new Sub();
        PropertyCopier.copyBeanProperties(Sub.class, sub1, sub2);
        System.out.println(sub2);
    }
}