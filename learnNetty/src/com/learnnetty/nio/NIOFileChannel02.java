package com.learnnetty.nio;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 项目名称：  learnNetty
 * 类名称：  NIOFileChannel01
 * 描述：
 * @author wangzheng
 * 创建时间：  2021/2/5 9:12
 * 修改人： wangzheng  修改日期： 2021/2/5 9:12
 * 修改备注：
 */
public class NIOFileChannel02 {
    public static void main(String[] args) throws IOException {
        /*从文件中读取数据*/
        // 首先得有一个目标文件
        File file = new File("d://1.txt");
        // 然后读取需要输入流
        FileInputStream fileInputStream = new FileInputStream(file);
        // 从文件输入流中获取通道 fileChannel
        FileChannel fileChannel = fileInputStream.getChannel();
        // 创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(256);
        fileChannel.read(byteBuffer);
        fileInputStream.close();
        System.out.println(new String(byteBuffer.array()));
    }
}