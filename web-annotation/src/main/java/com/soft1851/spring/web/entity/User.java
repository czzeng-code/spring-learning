package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Zeng
 * @ClassName User
 * @Description TOOD
 * @Date 2020/3/24
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String avatar;
}
