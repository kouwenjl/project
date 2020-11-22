package com.example.sam;



//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.example.sam.jpa.OutSideUserRepository;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.domain.PageRequest;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.util.List;


@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = {"com.example.sam"})
@MapperScan(basePackages = {"com.example.sam"})
@Slf4j
//@EnableJpaRepositories
@Controller
@ServletComponentScan
public class SamApplication {
    @Autowired
    OutSidUserDao outSidUserDao;
    @Autowired
    DataSource dataSource;
    @Value("${jll}")
    public static void main(String[] args) {
        System.out.println(System.getenv("ni"));

        SpringApplication.run(SamApplication.class, args);
    }
  @PostConstruct
    private void d(){

  }

  @RequestMapping("/dxs")
    public void test(HttpServletRequest request){
      PageHelper.startPage(1,2);
      List<OutSideUser> list=outSidUserDao.selectUsers();
      PageInfo pageInfo=new PageInfo(list);
      System.out.println(66);
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
