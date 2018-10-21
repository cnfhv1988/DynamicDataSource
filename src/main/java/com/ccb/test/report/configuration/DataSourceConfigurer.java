package com.ccb.test.report.configuration;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfigurer {


    @Bean("pl2")
    @ConfigurationProperties(prefix = "spring.datasource.pl2")
    public DataSource pl2() {
        return DataSourceBuilder.create().build();
    }

    @Bean("pl3")
    @ConfigurationProperties(prefix = "spring.datasource.pl3")
    public DataSource pl3() {
        return DataSourceBuilder.create().build();
    }

    @Bean("pl4")
    @ConfigurationProperties(prefix = "spring.datasource.pl4")
    public DataSource pl4() {
        return DataSourceBuilder.create().build();
    }

    @Bean("vt")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.vt")
    public DataSource vt() {
        return DataSourceBuilder.create().build();
    }

    @Bean("selectedDataSource")
    public DataSource selectedDataSource(){
        MultiDataSource multiDataSource = new MultiDataSource();
        Map<Object, Object> datasourceMap = new HashMap<>(4);
        datasourceMap.put("pl2", pl2());
        datasourceMap.put("pl3", pl3());
        datasourceMap.put("pl4", pl4());
        datasourceMap.put("vt", vt());
        multiDataSource.setTargetDataSources(datasourceMap);
        return multiDataSource;
    }

    @Bean
    @ConfigurationProperties(prefix = "mybatis")
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(selectedDataSource());
        return sqlSessionFactoryBean;
    }
}
