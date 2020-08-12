package com.czxy.service;

import com.czxy.domain.TbCourse;

import java.util.List;

/**
 * @author 庭前云落
 * @Date 2019/12/24 18:08
 * @description
 */
public interface CourseService {
    List<TbCourse> findAll(Integer sid);

    List<TbCourse> findAll();



}
