package org.lhyf.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//将项目中对应的mapper类的路径加进来
@MapperScan("org.lhyf.demo.mapper")
@EnableTransactionManagement
public class AdminApplication {


    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class);
    }
}
