package com.czxy.service.impl;

import com.czxy.domain.StCourse;
import com.czxy.mapper.StCourserMapper;
import com.czxy.service.StCourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 庭前云落
 * @Date 2019/12/25 10:59
 * @description
 */
@Service
@Transactional
public class StCourseServiceImpl implements StCourseService {
    @Resource
    private StCourserMapper stCourserMapper;

    @Override
    public void addCourseList(List<StCourse> list) {
        System.out.println(list);
        for (StCourse tbStudentCourse : list) {
            stCourserMapper.insert(tbStudentCourse);
        }
    }
}
