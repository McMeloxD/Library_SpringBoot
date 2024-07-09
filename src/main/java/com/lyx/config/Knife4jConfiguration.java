package com.lyx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/7/9
 * @desc
 */
@Configuration // 开启配置
@EnableSwagger2 // 启动Swagger2
public class Knife4jConfiguration {
    @Bean
    public Docket defaultApi2() {
        String groupName = "1.0版本";
        Docket docket = new Docket(DocumentationType.OAS_30)
                // 是否启用Swagger
                .enable(true)
                .apiInfo(new ApiInfoBuilder()
                        .title("这是Library_springboot API ")
                        .description("这是项目描述")
                        .termsOfServiceUrl("服务器URL")
                        .contact(new Contact("McMeloxD", null, "lyx60668@gmail.com"))
                        .version("1.0")
                        .build())
                //分组名称
                .groupName(groupName)
                .select()
                // 这里指定Controller扫描包路径,没有加注解的接口方法也会生成接口文档
                .apis(RequestHandlerSelectors.basePackage("com.lyx.controller"))

                // 这里指定只有加了注解的才会生成接口文档
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
