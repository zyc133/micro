package com.jeff.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * springboot会自动注入数据源-不需要数据库支持-配置
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class MicroMessageApplication extends SpringBootServletInitializer {

    /**
     * 通过继承SpringBootServletInitializer并覆盖configure方式
     * 解决springboot打成war包，部署tomcat后访问404问题
     *
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MicroMessageApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroMessageApplication.class, args);
    }
}