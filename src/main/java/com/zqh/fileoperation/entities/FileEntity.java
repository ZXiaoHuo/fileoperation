package com.zqh.fileoperation.entities;

import lombok.Data;

/**
 * @author zhangqh
 * @date 2021/9/7 0007 9:13
 */
@Data
public class FileEntity {

    private String name;
    private String path;
    private String suffix;
    private Boolean enabled;

}
