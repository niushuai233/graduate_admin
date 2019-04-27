package cc.niushuai.graduate.config;

import cc.niushuai.graduate.interceptor.BaseInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author niushuai
 * @date 2018/12/11.
 * @email 1225803134@qq.com
 * <p>
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return converter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        BaseInterceptor baseInterceptor = new BaseInterceptor();
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(baseInterceptor);
        interceptorRegistration.excludePathPatterns("/common/**","/frontframe/**","/js/**","/login/**","/statics/**");

        super.addInterceptors(registry);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/index");
        super.addViewControllers(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").
                addResourceLocations("classpath:/META-INF/resources/","classpath:/static/","classpath:/templates/").setCachePeriod(0);


        super.addResourceHandlers(registry);
    }

}
