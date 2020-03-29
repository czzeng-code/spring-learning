package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zeng
 * @ClassName Blog
 * @Description TOOD
 * @Date 2020/3/29
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private Integer id;
    private String userName;
    private String avatar;
    private Integer zan;
    private Integer viewCount;

}
