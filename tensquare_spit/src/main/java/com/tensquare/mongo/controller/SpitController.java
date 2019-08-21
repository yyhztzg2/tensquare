package com.tensquare.mongo.controller;

import com.tensquare.mongo.pojo.Spit;
import com.tensquare.mongo.service.SpitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/spit")
@CrossOrigin
public class SpitController {

    @Autowired
    private SpitService spitService;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK, "查询成功", spitService.findAll());
    }

    @RequestMapping(value = "/{spitId}", method = RequestMethod.GET)
    public Result findById(@PathVariable String spitId){
        return new Result(true, StatusCode.OK, "查询成功", spitService.findById(spitId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Spit spit){
        spitService.save(spit);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @RequestMapping(value = "/{spitId}", method = RequestMethod.PUT)
    public Result update(@PathVariable String spitId, @RequestBody Spit spit){
        spit.set_id(spitId);//ID 存在就更新
        spitService.update(spit);
        return new Result(true, StatusCode.OK, "修改成功");
    }


    @RequestMapping(value = "/{spitId}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String spitId){
        spitService.deleteById(spitId);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @RequestMapping(value = "/comment/{parentid}/{page}/{size}", method = RequestMethod.GET)
    public Result comment(@PathVariable String parentid, @PathVariable int page, @PathVariable int size){
        Page<Spit> pageData = spitService.pageQuery(parentid, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Spit>(pageData.getTotalElements(), pageData.getContent()));
    }

    @RequestMapping(value = "/thumbup/{spitId}", method = RequestMethod.PUT)
    public Result addthumbup(@PathVariable String spitId){
        String userid = "11111";
        //先判断该用户是否已经点赞了。
        if(redisTemplate.opsForValue().get("thumbup_"+userid)!=null){
            return new Result(false, StatusCode.REPERROR, "不能重复点赞");
        }
        spitService.addthumbup(spitId);
        redisTemplate.opsForValue().set("thumbup_"+userid, 1);
        return new Result(true, StatusCode.OK, "点赞成功");
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
//        Date time = calendar.getTime();
//        System.out.println("time = " + time);
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE    , 1);
        Date time = calendar.getTime();
        System.out.println("time = " + time);
    }

}
