package cn.zwq.algorithm.test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * PriorityQueue
 * 1.PriorityQueue是基于优先堆的无界队列，这个优先队列存储的元素可以默认自然排序或者通过提供 Comparator 在队列实例化之时排序
 * 2.优先队列不允许空值，而且不支持 non-comparable 的对象
 * 3.优先队列的头元素是基于自然排序或者 Conparator 排序的最小元素，如果有多个对象拥有同样的排序，
 * 那么就可能随机取其中任意一个，当我们获取队列的时候，返回队列的头元素
 * 4.PriorityQueue 的大小不受限制的，但是在创建的时候可以指定初始大小，
 * 当我们向优先队列增加元素的时候队列大小会自动增加
 * 5.PriorityQueue 是线程不安全的，所以 Java 提供了 PriorityBlockingQueue 用于多线程环境
 * 6.PriorityQueue 通过二叉小顶堆实现，可以用完全二叉树表示，根节点值比左右子节点值都小
 * 7.PriorityQueue 使用 Object[] queue 存储元素，
 * 索引为 i 的左孩子的索引是 2 * i + 1
 * 索引为 i 的右孩子的索引是 2 * i + 2
 * 索引为 i 的父节点的索引是 (i - 1) / 2
 * 8.PriorityQueue 方法
 * jdk1.8 -> add 方法内部调用 offer 方法，offer 方法添加元素，添加成功返返回 true，
 *          两个方法添加元素都判断是不是添加首元素，是的话就直接返回 true，不是的话需要判断并移动新元素，确保满足父节点都小于左右节点
 * jdk1.8 -> peek 方法获取首元素；element 方法也是获取首元素，并且 element 方法内部调用 peek 方法，如果首元素是 null 就抛异常
 * jdk1.8 -> remove 方法获取首元素并删除首元素，首元素为 null 抛异常；poll 方法也是获取首元素并删除首元素
 *          两个方法都是在删除首元素之后，将数组末尾元素替代首元素，然后判断并移动直到满足根节点比左右节点都小
 * jdk1.8 -> remove(Object o) 删除优先队列中与 o 相等的某一个元素（如果有多个相等，只删除一个），
 *          删除分两种情况，删除最后一个元素，直接删除即可；如果删除不是最后元素，需要从删除点开始，以最后一个元素为参照判断并移动元素，
 *          确保满足父节点都小于左右节点
 *
 * @author ZWQ
 */
public class PriorityQueueTest {
    public static void main(String[] args) {

        Queue<Integer> priorityQueue = new PriorityQueue<>(7);
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            priorityQueue.add(random.nextInt(100));
//            priorityQueue.offer(random.nextInt(100));
        }

        //element，peek
        System.out.println(priorityQueue);
        for (int i = 0; i < 7; i++) {
            Integer poll = priorityQueue.peek();
//            Integer poll = priorityQueue.element();
            System.out.println(poll);
        }
        System.out.println(priorityQueue);

        System.out.println(priorityQueue);
        for (int i = 0; i < 7; i++) {
//            Integer poll = priorityQueue.poll();
            Integer poll = priorityQueue.remove();
            System.out.println(poll);
        }
        System.out.println(priorityQueue);

        boolean isRemove = priorityQueue.remove(56);
        System.out.println(isRemove);

        Comparator<? super Customer> idComparator = (a, b) -> {
            return a.getId() - b.getId();
        };
        Queue<Customer> customerPriorityQueue = new PriorityQueue<>(7, idComparator);
        addDataToQueue(customerPriorityQueue);
        System.out.println(customerPriorityQueue);
        pollDataToQueue(customerPriorityQueue);

    }

    private static void pollDataToQueue(Queue<Customer> customerPriorityQueue) {
//        for (int i = 0; i < 7; i++) {
//            Customer customer = priorityQueue.poll();
//            System.out.println(customer);
//        }
        while (true) {
            Customer customer = customerPriorityQueue.poll();
            if (customer == null) {
                break;
            }
            System.out.println(customer);
        }
    }

    private static void addDataToQueue(Queue<Customer> customerPriorityQueue) {
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            int id = random.nextInt(100);
            customerPriorityQueue.add(new Customer(id, "JTravler" + id));
        }
    }

    static class Customer {

        private int id;
        private String name;

        public Customer(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
