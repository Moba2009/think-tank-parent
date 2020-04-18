package cn.linyt.thinktankmedicine.controller;

import cn.linyt.thinktankmedicine.entity.Medicine;
import cn.linyt.thinktankmedicine.entity.MedicinePro;
import cn.linyt.thinktankmedicine.repository.MedicineRepository;
import com.alibaba.fastjson.JSONObject;
import com.sun.javafx.collections.MappingChange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MedicineController
 * @Description TODO
 * @Author Mojo
 * @Date 2020/4/18 17:19
 * @Version 1.0
 **/
@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/medicines")
public class MedicineController {

    @Autowired
    private MedicineRepository medicineRepository;

    /**
     * @Description TODO    GET /medicines
     * @Author Mojo
     * @Date 2020/4/19 1:54
     **/
    @GetMapping
    public List<MedicinePro> list(HttpServletResponse response) {

        //获取药材列表
        log.info("### get medicines ###");
        List<MedicinePro> medicineProList = new ArrayList<>();
        List<Medicine> children;
        String type;
        for (int i = 1; i <= 26; i++) {
            type = String.valueOf(Character.toUpperCase((char) (96 + i)));
            children = medicineRepository.findByType(type);
            if (children.isEmpty())
                continue;
            else
                medicineProList.add(new MedicinePro(type, children));
        }
        //设置响应数据类型和编码方式
        response.setContentType("application/json; charset=utf-8");
        return medicineProList;
    }

    /**
     * @Description TODO    GET /medicines/
     * @Author Mojo
     * @Date 2020/4/19 2:01
     **/
//    @GetMapping
//    public Medicine detail() {
//
//
//    }
}
