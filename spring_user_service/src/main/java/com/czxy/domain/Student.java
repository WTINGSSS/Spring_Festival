package com.czxy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 庭前云落
 * @Date 2019/12/16 10:16
 * @description
 */
@Table(name = "tb_student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer sid;
   private String sname;
   private Integer gender;
   private Integer age;
   private Double salary;
   @Column(name = "`desc`")
   private String desc;
   @Column(name = "class_id")
   private Integer class_id;

   private TClass tClass;

   private List<TbCourse> courseList=new ArrayList<>();
}
