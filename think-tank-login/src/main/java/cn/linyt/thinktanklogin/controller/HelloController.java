package cn.linyt.thinktanklogin.controller;

import cn.linyt.thinktanklogin.response.Result;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author Mojo
 * @Date 2020/4/17 15:10
 * @Version 1.0
 **/
@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/hello")
public class HelloController {

//    @JwtIgnore
    @PostMapping
    public Result hello(@RequestBody String data) {

        log.info("### hello: " + data + " ###");
        JSONObject result = new JSONObject();
        result.put("token", data);
        return Result.SUCCESS(result);
    }
}
