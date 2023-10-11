package com.imooc.bilibili.domain.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // 保留策略为运行时
@Target({ElementType.METHOD}) // 只能应用于方法
@Component // 表示这个注解本身也是一个 Spring 组件
@Documented // 包含在生成的文档中
public @interface ApiLimitedRole {
    String[] limitedRoleCodeList() default {}; // 声明了一个属性 limitedRoleCodeList，类型为字符串数组，默认为空数组
}
