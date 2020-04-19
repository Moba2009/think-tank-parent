package cn.linyt.thinktanklogin.repository;

import cn.linyt.thinktanklogin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @InterfaceName UserRepository
 * @Description TODO
 * @Author Mojo
 * @Date 2020/4/20 7:33
 * @Version 1.0
 **/
public interface UserRepository extends JpaRepository<User, Long> {

    boolean findByUsernameAndPassword(User user);
}
