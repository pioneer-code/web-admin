package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

//@Configuration
public class MyDataSourceConfig {

//    @Bean //Springboot默认自动配置是判断容器中没有才会配@ConditionalOnMissingBean(DataSource.class),所有在这里配置了之后，默认的会失效
//    @ConfigurationProperties("spring.datasource")//将类的属性和配置源spring.datasource的属性进行绑定
//    public DataSource dataSource() throws SQLException {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setFilters("stat,wall");//加入监控功能
//
//        return druidDataSource;
//    }

    /**
     * 配置druid的监控页
     */
    @Bean
    public ServletRegistrationBean statiViewServlet(){
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(statViewServlet, "/druid/*");
        return registrationBean;
    }

    /**
     * WebStatFilter 用于采集web-jdbc关联监控的数据
     */
//    @Bean
//    public FilterRegistrationBean webStatFilter(){
//        WebStatFilter webStatFilter = new WebStatFilter();
//        FilterRegistrationBean<WebStatFilter> webStatFilterFilterRegistrationBean = new FilterRegistrationBean<>();
//        webStatFilterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
//        webStatFilterFilterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        System.out.println(webStatFilterFilterRegistrationBean);
//        return webStatFilterFilterRegistrationBean;
//    }


}
