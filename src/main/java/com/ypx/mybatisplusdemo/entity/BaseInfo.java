package com.ypx.mybatisplusdemo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class BaseInfo {
    @TableField(exist = false)
    private String token;
    @TableField(exist = false)
    private Integer page = 0;
    @TableField(exist = false)
    private Integer pageSize = 10;
}
