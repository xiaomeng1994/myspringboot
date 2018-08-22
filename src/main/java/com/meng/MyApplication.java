package com.meng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableScheduling//启动定时任务
@EnableSwagger2             //启动swagger注解
//@ComponentScan(basePackages = "com.meng")fcddsfed
//@EnableAutoConfiguration
public class MyApplication {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(MyApplication.class, args);

    }

}
