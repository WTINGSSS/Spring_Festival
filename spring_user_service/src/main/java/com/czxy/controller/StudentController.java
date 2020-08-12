package com.czxy.controller;

import com.czxy.domain.Student;
import com.czxy.domain.Svo;
import com.czxy.service.StudentService;
import com.czxy.vo.BaseResult;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 庭前云落
 * @Date 2019/12/16 18:51
 * @description
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentServiceImpl;

    @PostMapping
    public BaseResult stduentAdd(@RequestBody Student student){
        System.out.println(student);
        studentServiceImpl.studentAdd(student);
       return BaseResult.ok("添加成功");
    }

    @GetMapping
    public BaseResult pageByPageNum(Svo svo){
    PageInfo<Student> pageInfo= studentServiceImpl.pageByPageNum(svo);
    return BaseResult.ok("查询成功",pageInfo);
    }

    @DeleteMapping
    public BaseResult deleteAll(String ids){
        studentServiceImpl.deleteAll(ids);
        return BaseResult.ok("删除成功");
    }

    @PutMapping
    public BaseResult modify(@RequestBody Student student){
        studentServiceImpl.modify(student);
        return BaseResult.ok("修改成功");
    }

    @GetMapping("/{sid}")
    public BaseResult findOneBySid(@PathVariable("sid") Integer sid){
       Student student = studentServiceImpl.findOneBySid(sid);
    return BaseResult.ok("查询成功",student);
    }
}








