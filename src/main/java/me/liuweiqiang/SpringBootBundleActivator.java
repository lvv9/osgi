package me.liuweiqiang;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.osgi.io.OsgiBundleResourcePatternResolver;

@SpringBootApplication(scanBasePackages = "me.liuweiqiang")
public class SpringBootBundleActivator implements BundleActivator {

    ConfigurableApplicationContext context;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
        // 资源定位要重新用Bundle的方式解析
        OsgiBundleResourcePatternResolver resolver = new OsgiBundleResourcePatternResolver(bundleContext.getBundle());
        context = new SpringApplication(resolver, SpringBootBundleActivator.class).run();
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        SpringApplication.exit(context, () -> 0);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBundleActivator.class, args);
    }
}
