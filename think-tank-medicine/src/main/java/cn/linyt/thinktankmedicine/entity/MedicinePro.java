package cn.linyt.thinktankmedicine.entity;

import lombok.Data;

import java.util.List;

/**
 * @ClassName MedicinePro
 * @Description TODO
 * @Author Mojo
 * @Date 2020/4/19 0:25
 * @Version 1.0
 **/
@Data
public class MedicinePro {

    private String type;
    private List<Medicine> list;

    public MedicinePro(String type, List<Medicine> list) {
        this.type = type;
        this.list = list;
    }
}
