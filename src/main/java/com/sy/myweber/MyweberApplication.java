package com.sy.myweber;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.sy.myweber.mapper")
public class MyweberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyweberApplication.class, args);
    }

}
