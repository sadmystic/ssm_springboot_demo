package com.biu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.biu.controller","com.biu.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
