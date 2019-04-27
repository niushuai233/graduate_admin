package cc.niushuai.graduate.initialization;

import cc.niushuai.graduate.commons.constant.Constant;
import cc.niushuai.graduate.commons.utils.PathUtil;
import cc.niushuai.graduate.commons.utils.YAMLUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
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
@Order(value = 2)
public class PathInit implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("PathInit run ...");
        String property = (String) YAMLUtil.getProperty(Constant.MAIN_CONFIG_YAML, Constant.FDFS_TRACKER_URL);

        if (StringUtils.isEmpty(property)) {
            log.error("the property {} in {} doesn't exist, please check the file", Constant.FDFS_TRACKER_URL, Constant.MAIN_CONFIG_YAML);
            log.info("PathInit over ...");
            return;
        }
        // 此处得到的内容样式如：106.12.218.104:22122 需要将端口号分开
        String[] split = property.split(":");
        PathUtil.fdfsAccessPrefix = PathUtil.http.replace(Constant.IP_STRING_KEY, split[0]).replace(Constant.PORT_STRING_KEY, Constant.HTTP_PORT);
        log.info("init fdfsAccessPrefix:{} success", PathUtil.fdfsAccessPrefix);

        log.info("PathInit over ...");
    }
}
