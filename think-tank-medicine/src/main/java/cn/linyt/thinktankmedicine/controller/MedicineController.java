package cn.linyt.thinktankmedicine.controller;

import cn.linyt.common.response.Result;
import cn.linyt.common.utils.PinYinUtil;
import cn.linyt.thinktankmedicine.repository.MedicineRepository;
import cn.linyt.thinktankmedicine.entity.Medicine;
import cn.linyt.thinktankmedicine.entity.MedicinePro;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @ClassName MedicineController
 * @Description TODO
 * @Author Mojo
 * @Date 2020/4/18 17:19
 * @Version 1.0
 **/
@Slf4j
@CrossOrigin
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
    public List<MedicinePro> list(HttpServletResponse response) throws IOException {

        //获取药材列表
        log.info("### get medicines ###");
        List<MedicinePro> medicineProList = new ArrayList<>();
        List<Medicine> list;
        String type;
        for (int i = 1; i <= 26; i++) {
            type = String.valueOf(Character.toUpperCase((char) (96 + i)));
            list = medicineRepository.findByType(type);
            if (list.isEmpty())
                continue;
            else
                medicineProList.add(new MedicinePro(type, list));
        }
        return medicineProList;
    }

    /**
     * @Description TODO    GET /medicines/{id}
     * @Author Mojo
     * @Date 2020/4/19 2:01
     **/
    @GetMapping("/{id}")
    public Medicine detail(@PathVariable(value = "id") Long id, HttpServletResponse response) throws IOException {

        //获取详情页
        log.info("### get detail ###");
        Optional<Medicine> byId = medicineRepository.findById(id);
        return byId.get();
    }

    /**
     * @Description TODO    POST /medicines/save
     * @Author Mojo
     * @Date 2020/4/19 3:11
     **/
    @PostMapping("/save")
    public Result save(@RequestBody Medicine medicine, HttpServletResponse response) {

        if (medicine == null) {
            response.setStatus(422);
            return Result.FAIL("没有接受到对象");
        }
        //生成药材名的首字母
        String pinYin = PinYinUtil.getPinYin(medicine.getType());
        medicine.setType(PinYinUtil.getPinYin(medicine.getType()).substring(0, 1));
        medicineRepository.save(medicine);
        return Result.SUCCESS();
    }

    /**
     * @Description TODO    PUT /medicines/update
     * @Author Mojo
     * @Date 2020/4/20 1:34
     **/
    @PutMapping("/update")
    public Result update(@RequestBody Medicine medicine, HttpServletResponse response) {

        if (medicine == null) {
            response.setStatus(422);
            return Result.FAIL("没有接受到对象");
        }
        medicineRepository.save(medicine);
        return Result.SUCCESS();
    }
}
