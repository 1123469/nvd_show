package com.example.mpdemo.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

@Service
public class MyService {
    public void faceRecognition() throws IOException {
        String vul_summary = "A cross site scripting vulnerability exists when Microsoft Dynamics 365 (on-premises) does not properly sanitize a specially crafted web request to an affected Dynamics server, aka 'Microsoft Dynamics 365 (On-Premise) Cross Site Scripting Vulnerability'.";
        //前面一半是本地环境下的python的启动文件地址，后面一半是要执行的python脚本地址
        String[] arguments = new String[]{"C:\\Users\\Lzh\\miniconda3\\envs\\tf2.4_show\\python.exe", "F:\\PycharmProjects\\nvd_reload\\classify\\wv\\reload_demo.py",vul_summary};
        Process proc;
        try {
            proc = Runtime.getRuntime().exec(arguments);// 执行py文件
            //用输入输出流来截取结果
            FileInputStream errorStream = (FileInputStream)proc.getErrorStream();
            InputStreamReader isr = new InputStreamReader(errorStream,"gbk");//读取
            System.out.println(isr.getEncoding());
            BufferedReader in = new BufferedReader(isr);//缓冲
            String line = null;
            LinkedList<String> outputline = new LinkedList<>();
            while ((line = in.readLine()) != null) {
//                System.out.println(line);
                outputline.addLast(line);
            }
            System.out.println("最后输出是");
            String lastExceptin = outputline.getLast();
            String[] last = lastExceptin.split(" ");
            System.out.println(last[last.length-1]);
            in.close();
            //waitFor是用来显示脚本是否运行成功，1表示失败，0表示成功，还有其他的表示其他错误
            int re = proc.waitFor();
            System.out.println("运行成功输出0");
            System.out.println(re);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        try {
//            proc = Runtime.getRuntime().exec(arguments);// 执行py文件
//            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
//            System.out.println("开始获取");
//            String line = in.readLine();
//            System.out.println(line);
//            while (line != null) {
//                // 显示结果
//                System.out.println("springboot执行python结果:" + line);
//                line = in.readLine();
//            }
//            in.close();
//            System.out.println("结束执行");
//            proc.waitFor();
//            //waitFor是用来显示脚本是否运行成功，1表示失败，0表示成功，还有其他的表示其他错误
//            int re = proc.waitFor();
//            System.out.println(re);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
    public String getCVEType(String vulSummary) throws IOException {
        String vul_summary = "A cross site scripting vulnerability exists when Microsoft Dynamics 365 (on-premises) does not properly sanitize a specially crafted web request to an affected Dynamics server, aka 'Microsoft Dynamics 365 (On-Premise) Cross Site Scripting Vulnerability'.";
        //前面一半是本地环境下的python的启动文件地址，后面一半是要执行的python脚本地址
//        String[] arguments = new String[]{"C:\\Users\\Lzh\\miniconda3\\envs\\tf2.4_show\\python.exe", "F:\\PycharmProjects\\nvd_reload\\classify\\wv\\reload_demo.py",vulSummary};
        String[] arguments = new String[]{"C:\\Users\\Lzh\\miniconda3\\envs\\tf2.4_show\\python.exe", "E:\\软件开发实践\\毕设项目\\NVDProject\\nvd_core\\classify\\wv\\reload_all.py",vulSummary};
        Process proc;
        try {
            proc = Runtime.getRuntime().exec(arguments);// 执行py文件
            //用输入输出流来截取结果
            FileInputStream errorStream = (FileInputStream)proc.getErrorStream();
            InputStreamReader isr = new InputStreamReader(errorStream,"gbk");//读取
            System.out.println(isr.getEncoding());
            BufferedReader in = new BufferedReader(isr);//缓冲
            String line = null;
            LinkedList<String> outputline = new LinkedList<>();
            while ((line = in.readLine()) != null) {
                outputline.addLast(line);
            }
            System.out.println("最后输出是");
            String lastExceptin = outputline.getLast();
            String[] last = lastExceptin.split(" ");
            System.out.println(last[last.length-1]);
            in.close();
            //waitFor是用来显示脚本是否运行成功，1表示失败，0表示成功，还有其他的表示其他错误
            int re = proc.waitFor();
            System.out.println("运行成功输出0");
            System.out.println(re);
            return last[last.length-1];
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}

