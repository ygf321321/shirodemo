package com.gf.shirodemo.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

    @Bean
     public Realm realm(){
        TextConfigurationRealm realm = new TextConfigurationRealm();
        realm.setUserDefinitions("ygf=123,user\n admin=123,admin");
        realm.setRoleDefinitions("admin=read,write\n user=read");
        return realm;
     }

     @Bean
     public ShiroFilterChainDefinition shiroFilterChainDefinition(){
         DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
         //可匿名访问
         chainDefinition.addPathDefinition("/login","anon");
         chainDefinition.addPathDefinition("/doLogin","anon");
         //注销
         chainDefinition.addPathDefinition("/logout","logout");
         //认证后访问
         chainDefinition.addPathDefinition("/**","authc");
         return  chainDefinition;

     }

     @Bean
     public ShiroDialect shiroDialect(){
        return  new ShiroDialect();
     }
}
