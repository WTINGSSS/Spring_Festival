package com.czxy.mapper;

import com.czxy.domain.Student;
import com.czxy.domain.Svo;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 庭前云落
 * @Date 2019/12/16 18:45
 * @description
 */

public interface StudentMapper extends Mapper<Student> {


    @Select("<script>" +
            "select * from tb_student where 1=1" +
            "<if test=\"svo.sname!=null and svo.sname!=''\"> and sname like #{svo.sname} </if>"+
            "<if test=\"svo.startsalary!= null and svo.startsalary!='' and svo.endsalry!=null and svo.endsalry!=''\"> and salary between #{svo.startsalary} and #{svo.endsalry} </if>"+
            "</script>")
    @Results({
            @Result(property = "class_id",column = "class_id"),
            @Result(property = "tClass",column = "class_id",one = @One(select = "com.czxy.mapper.TClassMapper.selectByPrimaryKey")),
    })
    List<Student> findAll(@Param("svo") Svo svo);


}
