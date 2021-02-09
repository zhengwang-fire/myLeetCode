package com.learnnetty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * 项目名称：  learnNetty
 * 类名称：  ScatteringAndGatheringTest
 * 描述：Scattering 将数据写入到buffer时，可以采用buffer数组，依次写入【分散】
 * Gathering 从buffer读取数据时，可以采用buffer数组，依次读
 * @author wangzheng
 * 创建时间：  2021/2/9 13:40
 * 修改人： wangzheng  修改日期： 2021/2/9 13:40
 * 修改备注：
 */
public class ScatteringAndGatheringTest {
    public static void main(String[] args) throws IOException {
        // 使用ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);
        // 绑定接口到socket并启动
        serverSocketChannel.socket().bind(inetSocketAddress);


        // 创建buffer数组
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        // 等待客户端连接(telnet)
        SocketChannel socketChannel = serverSocketChannel.accept();
        // 假定从客户端获取8个字符
        int messageLength = 8;
        while (true) {
            int byteRead = 0;
            while (byteRead < messageLength) {
                long read = socketChannel.read(byteBuffers);
                // 累计获取字节数
                byteRead += read;
                System.out.println("byteRead=" + byteRead);
                Arrays.asList(byteBuffers).stream()
                      .map(buffer -> "postion=" + buffer.position() + ",limit=" + buffer.limit())
                      .forEach(System.out::println);
            }

            // 将所有的buffer进行filp
            Arrays.asList(byteBuffers).forEach(buffer -> buffer.flip());

            //将数据读出显示到客户端
            long byteWrite = 0;
            while (byteWrite < messageLength) {
                long write = socketChannel.write(byteBuffers);
                byteWrite += write;
            }

            Arrays.asList(byteBuffers).forEach(buffer -> {
                buffer.clear();
            });
            System.out.println("byteRead=" + byteRead + " byteWrite=" + byteWrite + " messageLength" + messageLength);
        }

    }
}