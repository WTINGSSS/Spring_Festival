package com.czxy.service.impl;

import com.czxy.domain.TClass;
import com.czxy.domain.Tvo;
import com.czxy.mapper.TClassMapper;
import com.czxy.service.TClassService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 庭前云落
 * @Date 2019/12/16 18:48
 * @description
 */
@Service
@Transactional
public class TClassServiceImpl implements TClassService {
    @Resource
    private TClassMapper tClassMapper;

    @Override
    public void add(TClass tClass) {
        tClassMapper.insertSelective(tClass);
    }

    @Override
    public PageInfo<TClass> pageByPageNum(Tvo tvo) {
        PageHelper.startPage(tvo.getPageNum(),tvo.getPageSize());
        if(tvo.getCname()!=null&&!"".equals(tvo.getCname())){
            tvo.setCname("%"+tvo.getCname()+"%");
        }
        List<TClass> tlist = tClassMapper.findAll(tvo);
        return new PageInfo<>(tlist);
    }

    @Override
    public void deleteAll(String ids) {
        String[] split = ids.split(",");
        for (String s : split) {
          tClassMapper.deleteByPrimaryKey(s);
        }
    }

    @Override
    public TClass findOneByCid(Integer cid) {
        return tClassMapper.selectByPrimaryKey(cid);
    }

    @Override
    public void modify(TClass tClass) {
        tClassMapper.updateByPrimaryKey(tClass);
    }

    @Override
    public List<TClass> selectAllClass() {
        return tClassMapper.selectAll();
    }
}
