package com.learnnetty.nio;

import java.nio.ByteBuffer;

/**
 * 项目名称：  learnNetty
 * 类名称：  NIOByteBufferPutGet
 * 描述：
 * @author wangzheng
 * 创建时间：  2021/2/9 12:56
 * 修改人： wangzheng  修改日期： 2021/2/9 12:56
 * 修改备注：
 */
public class NIOByteBufferPutGet {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(64);
        buffer.putInt(100);
        buffer.putLong(9);
        buffer.putChar('尚');
        buffer.putShort((short) 4);
        buffer.flip();
        System.out.println();
        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());
    }
}