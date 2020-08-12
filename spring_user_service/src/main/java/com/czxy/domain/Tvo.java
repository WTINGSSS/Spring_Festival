package com.czxy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 庭前云落
 * @Date 2019/12/17 10:37
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tvo{
     private Integer pageNum;
     private Integer pageSize;
     private String cname;
}
