package com.mycsdnshiro.mycsdnshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mycsdnshiro.mycsdnshiro.mapper")
public class MycsdnshiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(MycsdnshiroApplication.class, args);
    }

}
