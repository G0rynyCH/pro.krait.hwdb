package pro.krait.hwdb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

/**
 * Created by gorynych on 19.02.16.
 * Класс, который конфигурирует базу данных
 */

@Configuration
@EnableJpaRepositories("pro.krait.hwdb.repository")       //Сообщаем Spring-контексту, что мы будем использовать JPA
@EnableTransactionManagement                              //Использование Транзакций (возможность роллбека при работе с базой данных)
@PropertySource("classpath:db.properties")
@ComponentScan("pro.krait.hwdb")
public class DatabaseConfig {

    @Resource
    private Environment env;
}
