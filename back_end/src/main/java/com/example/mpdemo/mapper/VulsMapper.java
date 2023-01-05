package com.example.mpdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mpdemo.entity.VulItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VulsMapper extends BaseMapper<VulItem> {
//    @Select("select * from todos")
//    public List<TodoItem> find();
}
