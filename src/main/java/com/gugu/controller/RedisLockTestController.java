package com.gugu.controller;

import com.gugu.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author Administrator
 * @Classname RedisLockTestController
 * @Description TODO
 * @Date 2021/5/29 9:43
 */
@Api("分布式锁测试")
@Controller
@RequestMapping("/lock")
public class RedisLockTestController {
    Logger logger = LoggerFactory.getLogger(RedisLockTestController.class);

    @Autowired
    RedisLockRegistry redisLockRegistry;

    @GetMapping("/test")
    @ApiOperation("获取锁")
    public void  test() throws InterruptedException  {
        Lock lock = redisLockRegistry.obtain("lock");
        boolean b1 = lock.tryLock(3, TimeUnit.SECONDS);
        logger.info("b1 is : {}", b1);
        TimeUnit.SECONDS.sleep(5);
        boolean b2 = lock.tryLock(3, TimeUnit.SECONDS);
        logger.info("b2 is : {}", b2);

        lock.unlock();
        lock.unlock();
    }
}
