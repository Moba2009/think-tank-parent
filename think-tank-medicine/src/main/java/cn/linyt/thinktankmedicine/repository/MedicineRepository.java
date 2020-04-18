package cn.linyt.thinktankmedicine.repository;


import cn.linyt.thinktankmedicine.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @InterfaceName MedicineRepository
 * @Description TODO
 * @Author Mojo
 * @Date 2020/4/18 17:18
 * @Version 1.0
 **/
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    List<Medicine> findByType(String type);
}
