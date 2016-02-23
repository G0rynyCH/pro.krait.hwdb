package pro.krait.hwdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.krait.hwdb.entity.User;

/**
 * Created by gss on 23.02.2016.
 * Интерфейс, который по сути является наследником DAO
 * Служит для выполнения операций с нашей таблицей
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
