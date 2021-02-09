package com.learnnetty.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 项目名称：  learnNetty
 * 类名称：  NIOFileChannel04
 * 描述：
 * @author wangzheng
 * 创建时间：  2021/2/9 12:46
 * 修改人： wangzheng  修改日期： 2021/2/9 12:46
 * 修改备注：
 */
public class NIOFileChannel04 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("d:/a.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("d:/b.jpg");
        // 获取对应流的对应channel
        FileChannel sourceCh = fileInputStream.getChannel();
        FileChannel destCh = fileOutputStream.getChannel();
        //使用transferForm完成拷贝
        destCh.transferFrom(sourceCh,0,sourceCh.size());
        //关闭相关流
        sourceCh.close();
        destCh.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}