package pro.krait.hwdb;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import pro.krait.hwdb.config.WebConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by gss on 19.02.2016.
 * Данный класс инициализирует Spring-контекст
 */
public class ApplicationInitializer implements WebApplicationInitializer{

    private final static String DISPATCHER = "dispatcher";
    public void onStartup(ServletContext servletContext) throws ServletException {

        //Создаем контекст
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebConfig.class);
        servletContext.addListener(new ContextLoaderListener(ctx));

        //В диспетчер сервлетов добавляем наш контекст
        ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER, new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);                         //В случае наличия нескольких сервлетов указывается порядок их инициализации
    }
}
