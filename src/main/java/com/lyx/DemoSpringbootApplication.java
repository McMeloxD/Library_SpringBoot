package com.lyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DemoSpringbootApplication {

    public static void main(String[] args) {
        //启动自动打开浏览器和local8080页面
        int port = 8080;
        String portPrefix = "--server.port=";
        for (String arg : args) {
            if (arg.startsWith(portPrefix)) {
                port = Integer.parseInt(arg.substring(portPrefix.length()));
            }
        }
        SpringApplication.run(DemoSpringbootApplication.class, args);
        try {
            Runtime.getRuntime().exec("cmd /c start http://localhost:" + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}