package com.coderiver.base;

import com.coderiver.common.util.IdGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by Ultratendency on 2019/1/2.
 */
@SpringBootApplication
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }

    // Init Default Util Beans into Spring Container which will be used in this Service
    @Bean
    public IdGenerator idGenerator(){
        return new IdGenerator();
    }
}
