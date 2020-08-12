package com.czxy.controller;

import com.czxy.domain.TbCourse;
import com.czxy.domain.StCourse;
import com.czxy.service.CourseService;
import com.czxy.service.StCourseService;
import com.czxy.vo.BaseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 庭前云落
 * @Date 2019/12/24 18:09
 * @description
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Resource
    private CourseService courseService;


    @Resource
    private StCourseService stCourseService;

    @GetMapping("/student/{sid}")
    public BaseResult<List<TbCourse>> findAll(@PathVariable("sid") Integer sid) {
        List<TbCourse> list = courseService.findAll(sid);
        return BaseResult.ok("查询成功", list);
    }

    @GetMapping
    public BaseResult findAll(){
        List<TbCourse> courseList = courseService.findAll();
        return BaseResult.ok("查询成功",courseList);
    }

    @PostMapping
    public BaseResult addCourseList(@RequestBody List<StCourse> list){
        stCourseService.addCourseList(list);
        return BaseResult.ok("添加成功");
    }
}
