package com.hanfei.rpc.hook;

import com.hanfei.rpc.factory.ThreadPoolFactory;
import com.hanfei.rpc.util.NacosUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Clean up the resources
 *
 * @author: harris
 * @time: 2023
 * @summary: harris-rpc-framework
 */
@Slf4j
public class ShutdownHook {

    // make sure that the shutdown hook is singleton
    @Getter
    private static final ShutdownHook shutdownHook = new ShutdownHook();

    /**
     * clean the Nacos registry and shutdown the thread pool when the JVM shuts down
     */
    public void addClearAllHook() {
        log.info("All services will be cleared when JVM shuts down");

        // add a new thread as a shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            NacosUtil.clearRegistry();
            ThreadPoolFactory.shutDownAll();
        }));
    }
}
