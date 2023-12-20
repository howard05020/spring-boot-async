package com.async.springbootasync;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AsyncService {

    @Async
    public void test1() {
        try {
            log.info(Thread.currentThread().getName() + " in test1, before sleep.");
            Thread.sleep(2000);
            log.info(Thread.currentThread().getName() + " in test1, after sleep.");
        } catch (InterruptedException e) {
            log.error("test1 sleep error.");
        }
    }

}
