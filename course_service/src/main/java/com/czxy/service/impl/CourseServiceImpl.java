package com.czxy.service.impl;

import com.czxy.domain.TbCourse;
import com.czxy.mapper.TbCourseMapper;
import com.czxy.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 庭前云落
 * @Date 2019/12/24 18:07
 * @description
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Resource
    private TbCourseMapper tbCourseMapper;

    @Override
    public List<TbCourse> findAll(Integer sid) {
        return tbCourseMapper.findAll(sid);
    }

    @Override
    public List<TbCourse> findAll() {
        return tbCourseMapper.selectAll();
    }


}
