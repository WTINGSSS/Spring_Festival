package com.czxy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 庭前云落
 * @Date 2019/12/16 10:14
 * @description
 */
@Table(name = "tb_teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Serializable {
     @Id
     private Integer tid;
     private String tname;
     private Integer type;
}










