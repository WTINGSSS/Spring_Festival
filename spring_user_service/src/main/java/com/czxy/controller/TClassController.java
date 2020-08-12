package com.czxy.controller;

import com.czxy.domain.TClass;
import com.czxy.domain.Tvo;
import com.czxy.service.TClassService;
import com.czxy.vo.BaseResult;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 庭前云落
 * @Date 2019/12/16 18:50
 * @description
 */
@RestController
@RequestMapping("/tclass")
public class TClassController {

    @Resource
    private TClassService tClassService;

    @PostMapping
    public BaseResult add(@RequestBody TClass tClass) {
        tClassService.add(tClass);
        return BaseResult.ok("添加成功");
    }

    @GetMapping
    public BaseResult pageByPageNum(Tvo tvo) {
        PageInfo<TClass> pageInfo = tClassService.pageByPageNum(tvo);
        return BaseResult.ok("查询成功", pageInfo);
    }

    @DeleteMapping
    public BaseResult deleteAll(String ids) {
        tClassService.deleteAll(ids);
        return BaseResult.ok("删除成功");
    }

    @GetMapping("/{cid}")
    public BaseResult findOneByCid(@PathVariable("cid") Integer cid) {
        TClass tClass = tClassService.findOneByCid(cid);
        System.out.println(tClass);
        return BaseResult.ok("查询成功", tClass);
    }

    @PutMapping
    public BaseResult modify(@RequestBody TClass tClass) {
        tClassService.modify(tClass);
        return BaseResult.ok("修改成功");
    }

    @GetMapping("/findAllClass")
    public BaseResult selectAllClass() {
        List<TClass> tlist = tClassService.selectAllClass();
        return BaseResult.ok("查询成功", tlist);
    }
}
