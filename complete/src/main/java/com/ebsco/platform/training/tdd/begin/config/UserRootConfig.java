package com.ebsco.platform.training.tdd.begin.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration
@Import({UserTxMgmtConfig.class, UserHALConfig.class})
@Profile("default")
public class UserRootConfig {

}