package com.etcd.test;

import io.etcd.jetcd.KeyValue;
import io.etcd.jetcd.kv.PutResponse;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author shadow
 * @Description test
 * @create 2022-06-01 17:16
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HelloWorldTest {
    // 用与测试的键
    private static final String KEY = "/abc/foo-" + System.currentTimeMillis();

    // 用于测试的值
    private static final String VALUE = "/abc/foo";

    @org.junit.jupiter.api.Test
    @Order(2)
    void get() throws ExecutionException, InterruptedException {
        List<KeyValue> getResult = new HelloWorld().get("/abc/foo");
        getResult.forEach(keyValue -> {
            System.out.println("key:"+keyValue.getKey().toString(UTF_8)+"   value:"+keyValue.getValue().toString(UTF_8));
        });
    }

    @Test
    @Order(1)
    void put() throws ExecutionException, InterruptedException {
        PutResponse putResponse = new HelloWorld().put(KEY, VALUE);
        assertNotNull(putResponse);
        assertNotNull(putResponse.getHeader());
    }
}
