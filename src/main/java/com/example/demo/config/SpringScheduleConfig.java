package com.example.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan("com.example.demo.service")
@Configuration
@EnableScheduling
public class SpringScheduleConfig {



}
