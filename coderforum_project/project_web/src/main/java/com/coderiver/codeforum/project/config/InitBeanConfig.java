package com.coderiver.codeforum.project.config;

import com.coderiver.codeforum.common.util.IdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author: solo
 * @Date: 2019/4/30 10:24 AM
 * @Version 1.0
 */
@Configuration
public class InitBeanConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public IdGenerator idGenerator(){
        return new IdGenerator();
    }

}
