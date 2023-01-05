package com.example.mpdemo.contoller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mpdemo.entity.VulItem;
import com.example.mpdemo.mapper.VulsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class VulController {
    @Autowired
    private VulsMapper vulsMapper;
    @GetMapping("/hello")
    public String hello(){
        return "Hello, Vul App!";
    }
    @GetMapping("/getAllTodos")
    public List getAllTodos(){
        List<VulItem> list = vulsMapper.selectList(null);
//        System.out.println(list);
        return list;
    }

    @PostMapping("/addTodos")
    public String addTodos(@RequestBody VulItem vulItem){
        int res = vulsMapper.insert(vulItem);
        System.out.println(vulItem);
        if(res>0)
            return res+" Insertion Succeeded!";
        else
            return "Insertion Failed!";
    }

    @PostMapping("/deleteTodos")
    public String deleteTodos(@RequestBody VulItem todoItem){
        int res = vulsMapper.deleteById(todoItem.getId());
        if(res>0)
            return res+" Deletion Succeeded!";
        else
            return "Deletion Failed!";
    }

    @PostMapping("/updateTodos")
    public String updateTodos(@RequestBody VulItem todoItem){
        VulItem old = vulsMapper.selectById(todoItem.getId());
        todoItem.setWrong(!old.isWrong());
        int res = vulsMapper.updateById(todoItem);
        if(res>0)
            return res+"Updation Succeeded!";
        else
            return "Updation Failed!";
    }

    @PostMapping("/updateAllTodos")
    public String updateAllTodos(@RequestBody VulItem todoItem){
        int success=0;
        boolean done = todoItem.isWrong();
        List<VulItem> list = vulsMapper.selectList(null);
        for(VulItem i:list){
            i.setWrong(done);
            success+=vulsMapper.updateById(i);
        }
        return success+" Updation Succeeded! "+(list.size()-success)+" Updation Failed!";
    }
    @GetMapping("/deleteAllDoneTodos")
    public String deleteAllDoneTodos(){
        int success = 0;
        QueryWrapper<VulItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("wrong",true);
        List<VulItem> list  = vulsMapper.selectList(queryWrapper);
        for(VulItem i:list)
            success+=vulsMapper.deleteById(i.getId());
        return success+" Deletion Succeeded! "+(list.size()-success)+" Deletion Failed!";
    }
}
