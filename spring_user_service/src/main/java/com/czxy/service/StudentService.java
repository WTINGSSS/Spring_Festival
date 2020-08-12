package com.czxy.service;

import com.czxy.domain.Student;
import com.czxy.domain.Svo;
import com.github.pagehelper.PageInfo;

/**
 * @author 庭前云落
 * @Date 2019/12/16 18:47
 * @description
 */
public interface StudentService {
    void studentAdd(Student student);

    PageInfo<Student> pageByPageNum(Svo svo);

    void deleteAll(String ids);

    void modify(Student student);

    Student findOneBySid(Integer sid);
}
