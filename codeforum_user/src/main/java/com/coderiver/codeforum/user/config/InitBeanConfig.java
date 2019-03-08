package com.coderiver.codeforum.user.config;

import com.coderiver.codeforum.common.util.IdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Shiyu Rao on 08/03/2019.
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
