package com.czxy.mapper;

import com.czxy.domain.TbCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TbCourseMapper extends tk.mybatis.mapper.common.Mapper<TbCourse> {

    @Select("select * from tb_course c,tb_student_course sc WHERE c.cid=sc.course_id AND sc.student_id=#{sid}")
    List<TbCourse> findAll(@Param("sid") Integer sid);
}