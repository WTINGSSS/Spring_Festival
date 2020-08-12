package com.czxy.service.impl;

import com.czxy.domain.Teacher;
import com.czxy.mapper.TeacherMapper;
import com.czxy.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 庭前云落
 * @Date 2019/12/16 18:47
 * @description
 */

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> findByType(Integer type) {
        return teacherMapper.findByType(type);
    }
}
