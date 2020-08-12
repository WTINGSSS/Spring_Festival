package com.czxy.mapper;

import com.czxy.domain.TClass;
import com.czxy.domain.Tvo;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 庭前云落
 * @Date 2019/12/16 18:46
 * @description
 */
public interface TClassMapper extends Mapper<TClass> {

    @Select("<script>" +
            "select * from tb_class where 1=1" +
            "<if test=\"tvo.cname!=null and tvo.cname!=''\"> and cname like #{tvo.cname} </if>"+
            "</script>")
    @Results(id = "r1",value = {
            @Result(property = "teacher1_id",column = "teacher1_id"),
            @Result(property = "teacher2_id",column = "teacher2_id"),
            @Result(property = "teacher3_id",column = "teacher3_id"),
            @Result(property = "teacher1",column = "teacher1_id",one = @One(select = "com.czxy.mapper.TeacherMapper.selectByPrimaryKey")),
            @Result(property = "teacher2",column = "teacher2_id",one = @One(select = "com.czxy.mapper.TeacherMapper.selectByPrimaryKey")),
            @Result(property = "teacher3",column = "teacher3_id",one = @One(select = "com.czxy.mapper.TeacherMapper.selectByPrimaryKey"))

    })
    List<TClass> findAll(@Param("tvo") Tvo tvo);


    @Select("select * from where cid=#{cid}")
    @ResultMap("r1")
    TClass findOneByCid(@Param("cid")Integer cid);
}
