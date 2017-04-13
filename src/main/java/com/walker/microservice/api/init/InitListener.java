package com.walker.microservice.api.init;

import com.walker.microservice.framework.registry.ServiceRegistry;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Map;

/**
 * Created by walker on 2017/4/13.
 */
@lombok.extern.slf4j.Slf4j
@Component
public class InitListener implements ServletContextListener {
    @Value("${server.addr}")
    private String serverAddr;

    @Value("${server.port}")
    private int serverPort;

    @Autowired
    private ServiceRegistry serviceRegistry;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.debug("context initialized, start to register services.");
        ServletContext servletContext = servletContextEvent.getServletContext();
        ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = mapping.getHandlerMethods();
        for (RequestMappingInfo info : handlerMethods.keySet()) {
            String serviceName = info.getName();
            if (serviceName != null) {
                log.debug("start to register service, name = {}",serviceName);
                //register service: service name and provider addrs
                serviceRegistry.register(serviceName, String.format("%s:%d", serverAddr, serverPort));
            }else {
                log.warn("serviceName is empty, cannot register!");
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.debug("context destroyed, do nothing.");
    }
}
