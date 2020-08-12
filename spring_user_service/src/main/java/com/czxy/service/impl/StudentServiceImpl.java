package com.czxy.service.impl;

import com.czxy.domain.StCourse;
import com.czxy.domain.Student;
import com.czxy.domain.Svo;
import com.czxy.domain.TbCourse;
import com.czxy.feign.CourseFeign;
import com.czxy.mapper.StudentMapper;
import com.czxy.service.StudentService;
import com.czxy.vo.BaseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 庭前云落
 * @Date 2019/12/16 18:46
 * @description
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private CourseFeign courseFeign;

    @Override
    public void studentAdd(Student student) {
        studentMapper.insert(student);

        ArrayList<StCourse> list = new ArrayList<>();

        for (TbCourse tbCourse : student.getCourseList()) {
            Integer courseId = tbCourse.getCid();
            Integer studentId = student.getSid();
            System.out.println(tbCourse);
            StCourse stCourse = new StCourse();
            stCourse.setCourseId(courseId);
            stCourse.setStudentId(studentId);

            list.add(stCourse);
        }

        courseFeign.addCourseList(list);
    }

    @Override
    public PageInfo<Student> pageByPageNum(Svo svo) {

        PageHelper.startPage(svo.getPageNum(), svo.getPageSize());
        if (svo.getSname() != null && !"".equals(svo.getSname())) {
            svo.setSname("%" + svo.getSname() + "%");
        }
        List<Student> slist = studentMapper.findAll(svo);
        //遍历学生，依次查询每一个学生所有课程，并将结果封装student中
        for (Student student : slist) {
            BaseResult<List<TbCourse>> baseResult = courseFeign.findAll(student.getSid());
            List<TbCourse> courseList = baseResult.getData();
            student.setCourseList(courseList);
        }
        return new PageInfo<>(slist);
    }

    @Override
    public void deleteAll(String ids) {
        String[] split = ids.split(",");
        for (String s : split) {
            studentMapper.deleteByPrimaryKey(s);
        }
    }

    @Override
    public void modify(Student student) {
        studentMapper.updateByPrimaryKey(student);
    }

    @Override
    public Student findOneBySid(Integer sid) {
        return studentMapper.selectByPrimaryKey(sid);
    }
}
