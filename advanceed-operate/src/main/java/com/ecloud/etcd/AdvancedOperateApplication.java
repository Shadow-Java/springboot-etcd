package com.ecloud.etcd;
import com.ecloud.etcd.service.AdvancedEtcdService;
import com.ecloud.etcd.service.impl.AdvancedEtcdServiceImpl;
import com.ecloud.etcd.service.EtcdService;
import com.ecloud.etcd.service.impl.EtcdServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
/**
 * @author shadow
 * @Description 启动类
 * @create 2022-06-01 16:54
 */
@SpringBootApplication
public class AdvancedOperateApplication {
    private static final String IP = "ip";

    public static final String endpoints = "http://" + IP + ":2379,http://" + IP + ":2380,http://" + IP + ":2381";


    @Bean
    public EtcdService getEtcdService(){
        return new EtcdServiceImpl(endpoints);
    }

    @Bean
    public AdvancedEtcdService getAdvancedEtcdService(){
        return new AdvancedEtcdServiceImpl(endpoints);
    }

    public static void main(String[] args) {
        SpringApplication.run(AdvancedOperateApplication.class, args);
    }
}
