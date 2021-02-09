package com.learnnetty.nio;


import java.io.File;
import java.io.FileNotFoundException;
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
public class NIOFileChannel01 {
    public static void main(String[] args) throws IOException {
        /*将一个字符串写入硬盘文件中*/
        // 首先得有一个字符串
        String msg = "hello,word";
        // 还得有一个目标文件
        File file = new File("d://1.txt");
        // 想往文件里写东西肯定要输出流(FileOutputStream)
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        // 然后在输出流中获取通道
        FileChannel channel = fileOutputStream.getChannel();
        // 创建一个缓冲区 byteBuffer
        byte[] bytes = msg.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
        // 将msg 放入缓冲区
        byteBuffer.put(bytes);
        byteBuffer.flip();
        //将缓冲区中的数据 写入到通道中
        channel.write(byteBuffer);
        fileOutputStream.close();
    }
}