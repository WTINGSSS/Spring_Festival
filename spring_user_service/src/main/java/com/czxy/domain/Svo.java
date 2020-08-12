package com.czxy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 庭前云落
 * @Date 2019/12/18 10:28
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Svo {
      private Integer pageNum;
      private Integer pageSize;
      private String sname;
      private String gender;
      private Double startsalary;
      private Double endsalry;


}
