package com.czxy.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "tb_course")
public class TbCourse implements Serializable {
    @Id
    @Column(name = "cid")
    @GeneratedValue(generator = "JDBC")
    private Integer cid;

    @Column(name = "cname")
    private String cname;

    private static final long serialVersionUID = 1L;
}