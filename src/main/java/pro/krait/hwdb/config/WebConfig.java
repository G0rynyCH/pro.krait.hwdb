package pro.krait.hwdb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by gss on 19.02.2016.
 */

@Configuration                                      //Указывает, что данный класс является конфигурацией, которую нужно выполнить перед разворачиванием контекста Spring
@EnableWebMvc                                       //Включение режима WebMVC - возможность использования контроллеров и Web-контроллеров
@ComponentScan("pro.krait.hwdb")                    //Указывает, где искать наши бины
public class WebConfig {
}
