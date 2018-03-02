package com.jdk.util;

/**
 * Map数据类型中的链表
 * @author xh.d
 * @since 2018/3/2 15:15
 */
public class LinkMap {

    private Integer object;
    private LinkMap next;
    private int size;

    public LinkMap() {
    }
    private LinkMap(Integer object, LinkMap next) {
        this.object = object;
        this.next = next;
    }

    //push 链表
    public void push(Integer o){

        LinkMap link = this;
        while (link.next!=null){
            link = link.next;
        }
        LinkMap linkMap = new LinkMap(o, null);
        link.next = linkMap;
        size++;
    }
    public int size(){
        return size;
    }

    //把最后一个弹出来
    public Integer pop() {
        LinkMap map = this.next;
        Integer ro = null;
        while (null != map){
            if (null ==map.next){
                break;
            }
            map = map.next;
        }
        ro = map.object;
        LinkMap map1 = this;
        while (null != map1){
            if (null != map1.next) {
                if (map1.next.equals(map)) {
                    map1.next = null;
                }
                map1 = map1.next;
            }
        }
        return ro;
    }
}
