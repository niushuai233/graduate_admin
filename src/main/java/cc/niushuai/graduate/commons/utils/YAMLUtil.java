package cc.niushuai.graduate.commons.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration2.YAMLConfiguration;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.InputStream;

/**
 * @ClassName YAMLUtil
 * @Description:
 * @Author niushuai
 * @email niushuai951101@gmail.com
 * @Date 2019/4/11 10:46
 */
@Slf4j
public class YAMLUtil {

    public static Object getProperty(String location, String key) {
        YAMLConfiguration yamlConfiguration = getYAMLConfiguration(location);
        return yamlConfiguration.getProperty(key);
    }

    /**
     * YAMLConfiguration
     *
     * @param location
     * @return
     * @throws ConfigurationException
     */
    public static YAMLConfiguration getYAMLConfiguration(String location) {
        try {
            YAMLConfiguration yamlConfiguration = new YAMLConfiguration();
            yamlConfiguration.read(getInputStream(location));
            return yamlConfiguration;
        } catch (ConfigurationException e) {
            log.error("read yml file error:{}", e.getMessage());
            return null;
        }
    }

    /**
     * 获取指定文件的输入流
     *
     * @param location
     * @return
     */
    public static InputStream getInputStream(String location) {

        return YAMLUtil.class.getClassLoader().getResourceAsStream(location);
    }
}
