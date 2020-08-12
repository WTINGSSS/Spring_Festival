package com.czxy.mapper;

import com.czxy.domain.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 庭前云落
 * @Date 2019/12/16 18:46
 * @description
 */
public interface TeacherMapper extends Mapper<Teacher> {

    @Select("select * from tb_teacher where type=#{type}")
    List<Teacher> findByType(@Param("type") Integer type);
}
