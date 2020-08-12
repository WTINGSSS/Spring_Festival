package com.czxy.feign;

import com.czxy.domain.StCourse;
import com.czxy.domain.TbCourse;
import com.czxy.vo.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author 庭前云落
 * @Date 2019/12/24 17:53
 * @description
 */
@Component
@FeignClient(value = "courseservice",path = "/course")
public interface CourseFeign {

    @GetMapping("/student/{sid}")
    public BaseResult<List<TbCourse>> findAll(@PathVariable("sid")Integer sid);

    @PostMapping
    public BaseResult addCourseList(@RequestBody List<StCourse> list);

}
