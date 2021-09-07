package com.zqh.fileoperation.controller;

import com.zqh.fileoperation.dto.RestResult;
import com.zqh.fileoperation.entities.FileEntity;
import com.zqh.fileoperation.utils.FileUtil;
import com.zqh.fileoperation.utils.QRCodeTools;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * @author zhangqh
 * @date 2021/9/7 0007 10:44
 */
@RestController
@RequestMapping("api")
public class ApiController {

    @GetMapping("files")
    public RestResult files() {
        List<String> files = FileUtil.getFiles("D:\\Google下载\\pas\\codegen");
        ArrayList<FileEntity> list = new ArrayList<>();
        for (String file : files) {
            FileEntity fileEntity = new FileEntity();
            fileEntity.setPath(file);
            fileEntity.setName(FileUtil.getFileName(file));
            fileEntity.setSuffix(FileUtil.getFileSuffix(file));
            list.add(fileEntity);
        }
        return RestResult.success(list);
    }

    @PostMapping("qr")
    public RestResult qrPost(@RequestParam("file") MultipartFile multipartFile) {
        try {
            if (multipartFile != null) {
                byte[] bytes = multipartFile.getBytes();
                String base64 = Base64.getEncoder().encodeToString(bytes);
                String s = QRCodeTools.deEncodeByBase64(base64);
                if (s == null) return RestResult.error();
                return RestResult.success(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return RestResult.error();
    }

}
