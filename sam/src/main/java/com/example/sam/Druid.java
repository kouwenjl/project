package com.example.sam;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.ServerSocket;

@ConfigurationProperties(prefix = "spring.datasource.druid")
@Data
public class Druid {
    private String url;
    private String userName;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket=new ServerSocket(8080,2);
        while (true);
    }
}
