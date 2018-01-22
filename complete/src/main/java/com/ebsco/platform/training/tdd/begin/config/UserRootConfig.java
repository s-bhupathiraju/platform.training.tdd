package com.ebsco.platform.training.tdd.begin.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({UserTxMgmtConfig.class, UserHALConfig.class})
public class UserRootConfig {

}