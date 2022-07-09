package cn.biu.autoconfig;

import cn.biu.interceptor.SpringMvcConfig;
import cn.biu.properties.IpProperties;
import cn.biu.service.ipCountService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
//@EnableConfigurationProperties(IpProperties.class)
@Import({IpProperties.class,SpringMvcConfig.class})
public class ipAutoConfiguration {
    @Bean
    public ipCountService ipCountService(){
        return new ipCountService();
    }

}
