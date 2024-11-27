package com.genesisstudio.ernteweb;

import io.github.cdimascio.dotenv.Dotenv;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.genesisstudio.ernteweb.mapper")
public class ErnteWebApplication {

    public static void main(String[] args) {
        // 使用 dotenv 加载 .env 文件
        Dotenv dotenv = Dotenv.configure().load();

        // 设置环境变量
        System.setProperty("spring.datasource.url", dotenv.get("MYSQL_URL"));
        System.setProperty("spring.datasource.username", dotenv.get("MYSQL_USERNAME"));
        System.setProperty("spring.datasource.password", dotenv.get("MYSQL_PASSWORD"));

        SpringApplication.run(ErnteWebApplication.class, args);
    }

}
