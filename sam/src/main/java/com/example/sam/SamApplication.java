package com.example.sam;


import com.example.sam.jpa.OutSideUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;


@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = {"com.example.sam"})
@MapperScan(basePackages = {"com.example.sam"})
@Slf4j
@EnableJpaRepositories
public class SamApplication {
    @Autowired
    OutSidUserDao outSidUserDao;
    @Autowired
    OutSideUserRepository outSideUserRepository;
    @Autowired
    DataSource dataSource;
    public static void main(String[] args) {
        SpringApplication.run(SamApplication.class, args);
    }
  @PostConstruct
    private void d(){
//        org.slf4j.LoggerFactory.getLogger()
        log.debug("--------hhahahahha ");
        log.info("----d-d--sds");
      System.out.println("数据库连接池是:"+dataSource.getClass());
      for(OutSideUser outSideUser:outSideUserRepository.findAll(PageRequest.of(1,10))){
          System.out.println(outSideUser);
      };
  }
}
