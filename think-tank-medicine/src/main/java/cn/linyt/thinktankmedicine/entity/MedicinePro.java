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

    private String label;
    private List<Medicine> list;

    public MedicinePro(String label, List<Medicine> list) {
        this.label = label;
        this.list = list;
    }
}
