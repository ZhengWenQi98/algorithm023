学习笔记

这周学习到了新的数据结构，图数据结构还不是很好的掌握，刷算法变得熟练起来，还是得持续努力。

1. 哈希表

   哈希函数：决定元素在数组的索引位置

   jdk1.7：数组 + 链表

   jdk1.8：数组 + 链表 + 红黑树

   Map

   1. HashMap
   2. TreeMap：红黑树
   3. ConcurrentHashMap：线程安全的 HashMap

2. 集合

   TreeSet：底层依赖 TreeMap

   HashMap：底层依赖 HashMap

3. 堆

   PriorityQueue：Java 二叉堆实现

   大根堆：根节点是最大的元素

   小根堆：根节点是最小的元素
   
4. 树

   二叉树

   ​	前：根->左->右

   ​	中：->左->右

   ​	后：左->右->根

   二叉搜索树（BST）

   ​	左子树一定比根节点小，右子树一定比根节点大

   N 叉树

   ​	根节点有 N 个元素

上面总结的好不是很好，慢慢积累完善齐全。