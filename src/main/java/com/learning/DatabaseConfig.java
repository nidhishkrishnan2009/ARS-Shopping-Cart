package com.learning;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class DatabaseConfig {
	//@Bean
	public DataSource dataSource() {
	        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
	        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
	        dataSourceBuilder.url("jdbc:mysql://localhost:3306/examutility?useSSL=false");
	        dataSourceBuilder.username("root");
	        //dataSourceBuilder.password("root");
	        
	        return dataSourceBuilder.build();   
}
}
