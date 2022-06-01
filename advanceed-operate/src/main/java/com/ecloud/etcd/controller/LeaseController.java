package com.ecloud.etcd.controller;

import com.ecloud.etcd.service.AdvancedEtcdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author shadow
 * @Description 和租约相关的web服务
 * @create 2022-06-01 16:23
 */
@RestController
@Slf4j
public class LeaseController {
    @Autowired
    AdvancedEtcdService advancedEtcdService;

    @RequestMapping(value = "/lease/{key}/{value}", method = RequestMethod.GET)
    public String lease(@PathVariable("key") String key, @PathVariable("value") String value) throws Exception {
        advancedEtcdService.putWithLease(key, value);
        return "lease success " + new Date();
    }
}
