package cn.linyt.thinktankmedicine.controller;

import cn.linyt.common.exception.CustomException;
import cn.linyt.common.response.Result;
import cn.linyt.common.response.ResultCode;
import cn.linyt.thinktankmedicine.repository.MedicineRepository;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


/**
 * @ClassName FileUploadController
 * @Description TODO
 * @Author Mojo
 * @Date 2020/4/20 2:04
 * @Version 1.0
 **/
@Slf4j
@RestController
public class FileUploadController {

    private static final List<String> CONTENT_TYPES = Arrays.asList("image/jpg", "image/gif", "image/jpeg", "image/png");

    @PostMapping("/fileUpload")
    public Result fileUpload(@RequestParam(value = "file") MultipartFile file, HttpServletResponse response) {

        //设置响应数据类型和编码方式
        response.setContentType("application/json; charset=utf-8");
        // 是否接收到文件
        if (file.isEmpty()) {
            log.info("### upload file is null ###");
            return Result.FAIL("没有接收到上传的文件");
        }
        // 文件名
        String fileName = file.getOriginalFilename();
        // 后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 校验文件的类型
        String contentType = file.getContentType();
        log.info("### file type: {} ###", contentType);
        if (!CONTENT_TYPES.contains(contentType)){
            // 文件类型不合法，直接返回null
            log.info("### Type not supported：{} ###", suffixName);
            return Result.FAIL("文件类型不合法");
        }
        // 校验文件的内容（校验是否是图片类型）
        BufferedImage bufferedImage = null;
        PrintWriter writer = null;
        try {
            bufferedImage = ImageIO.read(file.getInputStream());
            if (null == bufferedImage){
                log.info("### Content not supported：{} ###", suffixName);
                return Result.FAIL("文件内容不合法");
            }
        } catch (IOException e) {
            // 设置响应状态码
            response.setStatus(422);
            // 设置响应体数据
            writer.write(JSONObject.toJSONString(Result.FAIL("上传的文件无法处理")));
            throw new CustomException(ResultCode.UPLOAD_ERROR);
        }
        // 文件保存到服务器的路径
        String filePath = "C:\\Program Files\\nginx-1.16.1\\html\\upload\\img\\";
        // 新文件名
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            // 写入磁盘
            file.transferTo(dest);
            writer = response.getWriter();
        } catch (IOException e) {
            // 设置响应状态码
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            // 设置响应体数据
            writer.write(JSONObject.toJSONString(Result.FAIL("文件写入磁盘出错")));
            throw new CustomException(ResultCode.UPLOAD_ERROR);
        }
        // 访问文件的路径
        String originalFileName = "http://111.230.223.21/upload/img/" + fileName;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("url", originalFileName);
        return Result.SUCCESS(jsonObject);
    }
}
