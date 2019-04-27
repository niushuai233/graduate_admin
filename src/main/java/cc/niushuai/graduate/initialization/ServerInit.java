package cc.niushuai.graduate.initialization;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 服务器启动时初始化相关配置
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-03-19 16:36:50
 */
@Slf4j
@Component
@Order(value = 1)
public class ServerInit implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("ServerInit run ...");




        log.info("ServerInit over ...");
    }
}
