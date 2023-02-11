package com.example.mpdemo.service;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
@Service
public class FaceService {
    public void faceRecognition() throws IOException{
        //前面一半是本地环境下的python的启动文件地址，后面一半是要执行的python脚本地址
        String[] arguments = new String[] {"C:\\Users\\Lzh\\miniconda3\\envs\\TF2.4\\python.exe", "F:\\PycharmProjects\\FinalProject\\test.py"};
        Process proc;
        try {
            proc = Runtime.getRuntime().exec(arguments);// 执行py文件
            //用输入输出流来截取结果
//            FileInputStream errorStream = (FileInputStream)proc.getErrorStream();
//            InputStreamReader isr = new InputStreamReader(errorStream,"gbk");//读取
//            System.out.println(isr.getEncoding());
//            BufferedReader in = new BufferedReader(isr);//缓冲
//            String line = null;
//            System.out.println("读取开始前");
//            System.out.println(in.readLine());
//            while ((line = in.readLine()) != null) {
//                System.out.println(line);
//                System.out.println("读取开始中");
//            }
//            in.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = in.readLine();
            System.out.println(line);
            while(line!=null){
                // 显示结果
                System.out.println("springboot执行python结果:"+line);
                line = in.readLine();
            }
            in.close();
            System.out.println("结束执行");
            proc.waitFor();
            //waitFor是用来显示脚本是否运行成功，1表示失败，0表示成功，还有其他的表示其他错误
            int re = proc.waitFor();
            System.out.println(re);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
