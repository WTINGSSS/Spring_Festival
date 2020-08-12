package com.czxy.service;

import com.czxy.domain.TClass;
import com.czxy.domain.Tvo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author 庭前云落
 * @Date 2019/12/16 18:48
 * @description
 */
public interface TClassService {
    void add(TClass tClass);

    PageInfo<TClass> pageByPageNum(Tvo tvo);

    void deleteAll(String ids);

    TClass findOneByCid(Integer cid);

    void modify(TClass tClass);

    List<TClass> selectAllClass();
}
