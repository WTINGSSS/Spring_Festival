package com.czxy.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class TbCourse implements Serializable {
    private Integer cid;
    private String cname;
}