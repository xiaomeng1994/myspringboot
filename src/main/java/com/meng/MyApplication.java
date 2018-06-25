package com.meng;

import com.meng.filepath.service.FilePathService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@ComponentScan(basePackages = "com.meng")
//@EnableAutoConfiguration
public class MyApplication {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(MyApplication.class, args);
        FilePathService filePathService = (FilePathService) context.getBean("filePathService");
        //String path = "C:\\Users\\1\\Desktop\\数据3";
        //String path = "C:\\Users\\1\\Desktop\\数据2\\城乡建设环境与资源保护工委\\市国土规划委\\控制性详细规划备案\\2016年度\\1.华南理工大学五山校区（天河区AT0501、AT0504、AT0505规划管理单元）";
        String path = "C:\\Users\\1\\Desktop\\最终数据";
        //filePathService.clearFileContentByPath(path);
        filePathService.insertFilePathBydir(path);
        //filePathService.insertFilePathBydir("C:\\Users\\1\\Desktop\\ztmlsjzl\\lyhylj\\lyylzdstgcjzqk");
        SpringApplication.exit(context);
    }

}
