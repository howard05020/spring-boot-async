package com.async.springbootasync;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@EnableAsync
public class LoggingController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/")
    public String index() {
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");

        log.info(Thread.currentThread().getName() + "before call async function.");
        asyncService.test1();
        log.info(Thread.currentThread().getName() + "after call async function.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error("sleep error.");
        }
        log.info(Thread.currentThread().getName() + "func end.");

        return "Check out the Logs to see the output...";
    }

}
