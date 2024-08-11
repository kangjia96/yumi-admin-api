package cn.ikangjia.yumi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.ikangjia.yumi.domain.mapper")
public class YumiApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(YumiApiApplication.class, args);
    }

}
