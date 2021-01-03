package cn.zwq.algorithm.test;

import java.util.Deque;
import java.util.LinkedList;

public class DequeTest {
    public static void main(String[] args) {

        //存储 Object 类型数据
        Deque deque = new LinkedList();

        deque.addFirst(23);
        deque.addFirst('男');
        deque.addFirst("learn algorithm");
 
		//输出结果：[learn algorithm, 男, 23]
        //addFirst 往队列第一个元素或者栈顶添加元素
        System.out.println(deque);

        deque.addLast(3.14);
        deque.addLast(true);

        //输出结果：[learn algorithm, 男, 23, 3.14, true]
        //addLast 往队列最后一个元素添加元素
        System.out.println(deque);
    }
}