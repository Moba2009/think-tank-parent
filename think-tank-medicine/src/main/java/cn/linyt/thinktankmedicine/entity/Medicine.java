package cn.linyt.thinktankmedicine.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @ClassName Medicine
 * @Description TODO
 * @Author Mojo
 * @Date 2020/4/18 16:25
 * @Version 1.0
 **/
@Data
@Entity
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;    //药名
    private String type;    //药名首字母
    private Long price;     //售价
    private Long cost;      //成本
    private Integer stock;  //库存
    private String efficacy;//功效
    private String image;   //图片

}
