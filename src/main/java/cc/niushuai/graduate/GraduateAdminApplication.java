package cc.niushuai.graduate;

import cn.hutool.core.date.DateUtil;
import com.github.tobato.fastdfs.FdfsClientConfig;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.SpringVersion;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@Import(FdfsClientConfig.class)
@EnableWebMvc
@EnableAutoConfiguration
@SpringBootConfiguration
@EnableTransactionManagement
@MapperScan(basePackages = {"cc.niushuai.graduate.mapper"})
@ComponentScan("cc.niushuai.graduate")
public class GraduateAdminApplication {

    public static void main(String[] args) {
        AnsiOutput.setEnabled(AnsiOutput.Enabled.ALWAYS);
        // 自定义Banner
        new SpringApplicationBuilder(GraduateAdminApplication.class)
                .main(SpringVersion.class)
                .bannerMode(Banner.Mode.CONSOLE)
                .run(args);
        log.info("===================================");
        log.info("========" + DateUtil.now() + "========");
        log.info("======Server start successful======");
        log.info("===================================");
    }

}

