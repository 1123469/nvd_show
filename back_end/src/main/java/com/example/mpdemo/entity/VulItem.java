package com.example.mpdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("vuls")
public class VulItem {
    @TableId(type = IdType.AUTO)
    private  Integer id;
    private String contents;
    private String type;
    private boolean wrong;

    public boolean isWrong() {
        return wrong;
    }

    public void setWrong(boolean wrong) {
        this.wrong = wrong;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }






    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "VulItem{" +
                "id=" + id +
                ", contents='" + contents + '\'' +
                ", wrong=" + wrong +
                '}';
    }
}
