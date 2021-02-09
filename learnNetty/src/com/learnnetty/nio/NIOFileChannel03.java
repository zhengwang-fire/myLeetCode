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
public class NIOFileChannel03 {
    public static void main(String[] args) throws IOException {
        /*复制文件*/
        // 有一个本地文件1.txt 需要复制
        File file1 = new File("d://1.txt");
        // 输入流将文件内容输入到流里
        FileInputStream fileInputStream = new FileInputStream(file1);
        // 获取输入流通道
        FileChannel fileInputStreamChannel = fileInputStream.getChannel();

        // 创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(256);
        // 输入流将文件读取出来放到缓冲区
        fileInputStreamChannel.read(byteBuffer);
        fileInputStream.close();

        // 目标文件
        File file2 = new File("d://2.txt");
        // 输出流 将缓冲区的信息 输出到本地磁盘
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        // 从文件输入流中获取通道 fileChannel
        FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();
        byteBuffer.flip();
        // 输出流将缓冲区的内容写入到磁盘
        fileOutputStreamChannel.write(byteBuffer);
        fileOutputStream.close();
    }
}