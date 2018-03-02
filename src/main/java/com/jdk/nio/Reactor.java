package com.jdk.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by JDKSrcAna
 *
 * @author xh.d
 * @since 2018/3/2 14:37
 */
public class Reactor implements Runnable{

    public int id = 100001;
    public int bufferSize = 2048;

    public void run() {
        try {
            //创建通道
            ServerSocketChannel channel = ServerSocketChannel.open();
            Selector selector = Selector.open();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(
                    InetAddress.getLocalHost(), 21012);
            channel.socket().bind(inetSocketAddress);
            //设置通道非阻塞,设置选择器
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_ACCEPT).attach(id++);
            System.out.println("Server started .... port:21012");
            listener(selector);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listener(Selector selector) throws Exception {
        while (true){
            Thread.sleep(1000);
            selector.select();

            Set<SelectionKey> readySelectionKey = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readySelectionKey.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                if (key.isAcceptable()){
                    //接收
                    accept(selector, key);
                }
                if (key.isConnectable()){
                    //连接
                    System.out.println(key.attachment() + " - 连接事件");
                }
                if (key.isReadable()){
                    //读取
                    read(key);
                }
                if (key.isWritable()){
                    //写入
                    write(key);
                }
            }
        }
    }

    private void write(SelectionKey key) throws IOException {
        System.out.println(key.attachment()
                + " - 写数据事件");
        SocketChannel clientChannel = (SocketChannel) key.channel();
        ByteBuffer sendBuf = ByteBuffer.allocate(bufferSize);
        String sendText = "hello\n";
        sendBuf.put(sendText.getBytes());
        sendBuf.flip();        //写完数据后调用此方法
        clientChannel.write(sendBuf);
    }

    private void accept(Selector selector, SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        serverSocketChannel.accept().configureBlocking(false).register(
                        selector,
                        SelectionKey.OP_READ
                                | SelectionKey.OP_WRITE).attach(id++);
        System.out.println(key.attachment() + " - 已连接");
    }

    private void read(SelectionKey key) throws IOException {
        System.out.println(key.attachment()
                + " - 读数据事件");
        SocketChannel clientChannel=(SocketChannel)key.channel();
        ByteBuffer receiveBuf = ByteBuffer.allocate(bufferSize);
        clientChannel.read(receiveBuf);
        System.out.println(key.attachment() + " - 读取数据：" + getString(receiveBuf));
    }

    public static String getString(ByteBuffer buffer)
    {
        String string = "";
        try
        {
            for(int i = 0; i<buffer.position();i++){
                string += (char)buffer.get(i);
            }
            return string;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return "";
        }
    }
}
