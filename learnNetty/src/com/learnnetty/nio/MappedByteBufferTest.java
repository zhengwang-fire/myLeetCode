package com.learnnetty.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.time.temporal.ValueRange;

/**
 * 项目名称：  learnNetty
 * 类名称：  MappedByteBuffer
 * 描述：
 * @author wangzheng
 * 创建时间：  2021/2/9 13:09
 * 修改人： wangzheng  修改日期： 2021/2/9 13:09
 * 修改备注：
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws IOException {
        // MappedByteBuffer 可以让文件直接在内存(堆外内存)修改，操作系统不需要拷贝一次
        RandomAccessFile randomAccessFile = new RandomAccessFile("d:/1.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();
        /**
         * 参数1:FileChannel.MapMode.READ_WRITE 使用读写模式
         * 参数2: 0 可以直接修改的起始位置
         * 参数3: 5 映射到内存的大小 即将1.txt 的多少个字节映射到内存
         * 可以直接修改范围是0-4的下标
         */
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        map.put(0, (byte) 'H');
        map.put(3, (byte) 'W');
        randomAccessFile.close();
        System.out.println("修改成功~~");

    }
}