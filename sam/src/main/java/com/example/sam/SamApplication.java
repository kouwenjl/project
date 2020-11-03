package com.example.sam;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sam.jpa.OutSideUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Manager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;


@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = {"com.example.sam"})
@MapperScan(basePackages = {"com.example.sam"})
@Slf4j
@EnableJpaRepositories
@Controller
@ServletComponentScan
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
      Page<OutSideUser> outSideUserPage=new Page<>();
      outSideUserPage.setSize(2);
      outSideUserPage.setCurrent(1);
      outSidUserDao.selectUsers(outSideUserPage);
      System.out.println(outSideUserPage.getTotal());
  }
  @RequestMapping("/dxs")
    public void test(HttpServletRequest request){
        System.out.println(6666);
      Subject subject= SecurityUtils.getSubject();
      System.out.println(subject.getSession().getId());
    }

    @RequestMapping("/login")
    public String test(String name,String pwd){
        UsernamePasswordToken token=new UsernamePasswordToken(name,pwd);
        Subject subject= SecurityUtils.getSubject();
//        token.setRememberMe(true);
        subject.login(token);
        System.out.println(subject.getSession().getId());
        System.out.println(name +" "+pwd+ "--登陆成功");
        return "index";
    }
}
