package com.learnnetty.nio;

import java.nio.ByteBuffer;

/**
 * 项目名称：  learnNetty
 * 类名称：  ReadOnlyBuffer
 * 描述：
 * @author wangzheng
 * 创建时间：  2021/2/9 13:03
 * 修改人： wangzheng  修改日期： 2021/2/9 13:03
 * 修改备注：
 */
public class ReadOnlyBuffer {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(64);
        for (int i = 0; i < 64; i++) {
            buffer.put((byte) i);
        }
        buffer.flip();
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass());

        while (readOnlyBuffer.hasRemaining()) {
            System.out.print(readOnlyBuffer.get());
        }
        /*  readOnlyBuffer.put((byte)1); //java.nio.ReadOnlyBufferException*/
    }
}