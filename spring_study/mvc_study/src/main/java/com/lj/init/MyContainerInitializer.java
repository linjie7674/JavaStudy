package com.lj.init;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.lj.config.SpringConfig;
import com.lj.config.SpringMVCConfig;

public class MyContainerInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    public MyContainerInitializer() {
        System.out.println("MyContainerInitializer construct.");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { SpringConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { SpringMVCConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}
