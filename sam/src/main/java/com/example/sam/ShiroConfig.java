package com.example.sam;
import org.apache.catalina.session.StandardSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.HttpServletSession;
import org.apache.shiro.web.session.mgt.WebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
   // TomcatWebServer
//     Cookie cookie = ApplicationSessionCookieConfig.createSessionCookie(context, this.session.getIdInternal(), this.isSecure());
//                                    this.response.addSessionCookieInternal(cookie);
    @Bean
    public  TextConfigurationRealm realm(){
        TextConfigurationRealm realm=new TextConfigurationRealm();
        realm.setUserDefinitions("dxs=123,jll");
        realm.setRoleDefinitions("jll=kiss");
        realm.init();
        return realm
               ;
    }
    @Bean
    public DefaultWebSecurityManager manager(TextConfigurationRealm  ream){
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
         defaultWebSecurityManager.setRealm(ream);
         defaultWebSecurityManager.setSessionManager(new SessionFactory());
        return defaultWebSecurityManager;
    }
    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        Map<String, Filter> filterMap=new HashMap<>();
        filterMap.put("s", new AccessControlFilter() {
            @Override
            protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
                System.out.println(66);
                return false;
            }

            @Override
            protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
                return false;
            }

            @Override
            public void setEnabled(boolean enabled) {
                super.setEnabled(enabled);
            }
        });
        shiroFilterFactoryBean.setFilters(filterMap);
        Map<String, String> urlMap = new LinkedHashMap<>();
        urlMap.put("/dxs", "authc");
        urlMap.put("/test","anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(urlMap);
        return shiroFilterFactoryBean;
    }
    public static void main(String[] args) {
        DefaultSecurityManager manager=new DefaultSecurityManager();
        manager.setCacheManager(new MemoryConstrainedCacheManager());
        TextConfigurationRealm realm=new TextConfigurationRealm();
        realm.setRoleDefinitions("jll=kiss,doLove");
        realm.setUserDefinitions("dxs=123,jll");
        realm.init();
        manager.setRealm(realm);
        UsernamePasswordToken token=new UsernamePasswordToken("dxs","123");
        //org.apache.shiro.spring.boot.autoconfigure.ShiroAnnotationProcessorAutoConfiguration
        SecurityUtils.setSecurityManager(manager);
        Subject subject=SecurityUtils.getSubject();
        System.out.println(subject.getPrincipal());
        subject.login(token);
        subject.checkPermission("doLove");
        System.out.println(subject.getPrincipal());
        subject.checkPermissions();
        System.out.println(null==null);
    }
}
class SessionFactory implements WebSessionManager{
    String sessionId;
    Session simpleSession=null;
    @Override
    public Session start(SessionContext sessionContext) {
        MySession standardSession=new MySession();
        standardSession.setId("dxs12345634");
        simpleSession=new HttpServletSession(standardSession,sessionContext.getHost());
        Cookie cookie =new Cookie("JSESSIONID","dxs12345634");
        WebUtils.getHttpResponse(sessionContext).addCookie(cookie);
        sessionId="ok";
        return  simpleSession;
    }
    @Override
    public Session getSession(SessionKey key) throws SessionException {
        if("ok".equals(sessionId)) {
            return simpleSession;
        }else return null;
    }

    @Override
    public boolean isServletContainerSessions() {
        return true;
    }
}
class MySession implements HttpSession{
    Map<String,Object> map=new HashMap<>();
    String id;

    @Override
    public long getCreationTime() {
        return 0;
    }

    @Override
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id=id;
    }
    @Override
    public long getLastAccessedTime() {
        return 0;
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    @Override
    public void setMaxInactiveInterval(int i) {

    }

    @Override
    public int getMaxInactiveInterval() {
        return 0;
    }

    @Override
    public HttpSessionContext getSessionContext() {
        return null;
    }

    @Override
    public Object getAttribute(String s) {
        return map.get(s);
    }

    @Override
    public Object getValue(String s) {
        System.out.println(11);
        return null;
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return null;
    }

    @Override
    public String[] getValueNames() {
        return new String[0];
    }

    @Override
    public void setAttribute(String s, Object o) {
//       map.put(s,o);
    }

    @Override
    public void putValue(String s, Object o) {

    }

    @Override
    public void removeAttribute(String s) {

    }

    @Override
    public void removeValue(String s) {

    }

    @Override
    public void invalidate() {

    }

    @Override
    public boolean isNew() {
        return false;
    }
}