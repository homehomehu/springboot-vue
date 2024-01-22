package com.example.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
/**    这行代码是一个典型的 Spring Boot 应用程序的入口点。具体来说，SpringApplication.run 方法用于启动 Spring Boot 应用程序。

 在运行这行代码后，会发生以下事情：

 Spring Boot 应用程序启动： SpringApplication.run 方法会启动 Spring Boot 应用程序。

 应用程序上下文初始化： Spring Boot 会初始化应用程序上下文，包括加载配置、扫描包，创建和初始化所有的 Bean 等。

 自动配置： Spring Boot 会根据类路径上的依赖和项目的配置，自动配置应用程序。

 嵌入式 Web 服务器启动： 如果应用程序是一个Web应用，Spring Boot 将启动嵌入式的 Web 服务器（比如 Tomcat、Jetty 或 Undertow）。

 应用程序运行： 应用程序开始运行，接受来自客户端的请求。 **/