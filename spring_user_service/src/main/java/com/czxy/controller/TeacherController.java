package com.czxy.controller;

import com.czxy.domain.Teacher;
import com.czxy.service.TeacherService;
import com.czxy.vo.BaseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 庭前云落
 * @Date 2019/12/16 18:48
 * @description
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Resource
    private TeacherService teacherService;

    @GetMapping("/{type}")
    public BaseResult findByType(@PathVariable("type")Integer type){
     List<Teacher> tlist =teacherService.findByType(type);
     return BaseResult.ok("查询成功",tlist);
    }

}
