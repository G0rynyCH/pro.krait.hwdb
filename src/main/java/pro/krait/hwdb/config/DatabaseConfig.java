package pro.krait.hwdb.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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

    //Автоматическое создание бинов и таблиц
    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(){

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(env.getRequiredProperty("db.entity.package"));
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());  //Сообщаем, что в качестве JPA-адаптера будет выступать Hibernate
        em.setJpaProperties(getHibernateProperties());
        return em;
    }



    //Конфигурируем метод, который вернет нам Data Source. Промежуточное звено между базой данных и Spring
    @Bean
    public DataSource dataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(env.getRequiredProperty("db.url"));
        ds.setDriverClassName(env.getRequiredProperty("db.driver"));
        ds.setUsername(env.getRequiredProperty("db.username"));
        ds.setPassword(env.getRequiredProperty("db.password"));

        ds.setInitialSize(Integer.valueOf(env.getRequiredProperty("db.initialSize")));
        ds.setMinIdle(Integer.valueOf(env.getRequiredProperty("db.minIdle")));
        ds.setMaxIdle(Integer.valueOf(env.getRequiredProperty("db.maxIdle")));
        ds.setTimeBetweenEvictionRunsMillis(Long.valueOf(env.getRequiredProperty("db.timeBetweenEvictionRunsMillis")));
        ds.setMinEvictableIdleTimeMillis(Long.valueOf(env.getRequiredProperty("db.minEvictableIdleTimeMillis")));
        ds.setTestOnBorrow(Boolean.valueOf(env.getRequiredProperty("db.testOnBorrow")));
        ds.setValidationQuery(env.getRequiredProperty("db.validationQuery"));

        return ds;
    }

    //Конфигурируем JPA Api Transaction
    @Bean
    public PlatformTransactionManager platformTransactionManager(){
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory().getObject());

        return manager;
    }

    public Properties getHibernateProperties() {

        try {
            Properties properties = new Properties();
            InputStream is = getClass().getClassLoader().getResourceAsStream("hibernate.properties");
            properties.load(is);
            return properties;

        } catch (IOException e) {
            throw new IllegalArgumentException("Невозможно найти файл hibernate.properties", e);
        }
    }
}
