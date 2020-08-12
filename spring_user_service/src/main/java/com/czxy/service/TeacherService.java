package com.czxy.service;

import com.czxy.domain.Teacher;

import java.util.List;

/**
 * @author 庭前云落
 * @Date 2019/12/16 18:47
 * @description
 */
public interface TeacherService {
    List<Teacher> findByType(Integer type);
}
