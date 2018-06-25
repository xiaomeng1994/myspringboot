package com.meng;

import com.meng.filepath.service.FilePathService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@ComponentScan(basePackages = "com.meng")
//@EnableAutoConfiguration
public class MyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MyApplication.class, args);
        FilePathService filePathService = (FilePathService) context.getBean("filePathService");
        //filePathService.insertFilePathBydir("C:\\Users\\1\\Desktop\\主题目录数据整理");
        filePathService.insertFilePathBydir("C:\\Users\\1\\Desktop\\主题目录数据整理");
        //filePathService.insertFilePathBydir("C:\\Users\\1\\Desktop\\ztmlsjzl\\lyhylj\\lyylzdstgcjzqk");
        SpringApplication.exit(context);
    }

}
