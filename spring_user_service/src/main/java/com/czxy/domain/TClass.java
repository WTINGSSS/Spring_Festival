package com.czxy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 庭前云落
 * @Date 2019/12/16 10:18
 * @description
 */
@Table(name = "tb_class")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TClass implements Serializable {
    @Id
    private Integer cid;
    private String cname;
    private Integer teacher1_id;
    private Teacher teacher1;
    private Integer teacher2_id;
    private Teacher teacher2;
    private Integer teacher3_id;
    private Teacher teacher3;


}
