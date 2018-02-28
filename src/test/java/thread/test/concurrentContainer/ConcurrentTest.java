package thread.test.concurrentContainer;

/**
 * 同步类容器都是线程安全的，但是在某些场景下可能需要加锁来保护
 * 复合操作，复合类操作如迭代，跳转，条件运算，这些复合操作在多
 * 线程并发地修改容器时，可能会表现出意外的行为，最经典的就是
 * ConcurrentModificationException，原因是当容器迭代过程中，
 * 被并发修改了内容，这是由于早期的迭代器设计的时候没有考虑并发
 * 修改的问题
 *
 * ConcurrentHashMap内部使用段（Segment）来表示这些不同的部分，
 * 每个段其实就是一个小的HashTable,它们有自己的锁。只要多个修改
 * 操作发生在不同的段上，它们就可以并发进行。把一个整体分成16个段
 * 也就是最高支持16个线程的并发修改操作。这也是在多线程场景时减小
 * 锁的粒度从而降低锁竞争的一种方案，并且代码中大多共享变量使用
 * volatile关键字声明，目的是第一时间获取修改的内容，性能非常好。
 *
 * COW：CopyOnWrite,一种用于程序设计中的优化策略
 * JDK中的COW容器有两种，CopyOnWriteArrayList/CopyOnWriteArraySet
 * CopyOnWrite容器即写时复制容器，通俗的理解就是当我们往一个容器添加
 * 元素的时候，不直接往当前容器添加，而是先将当前容器进行Copy,复制一个
 * 新的容器，然后往新的容器添加元素，添加完元素后再将原容器的引用指向
 * 新的容器。这样做的好处就是可以对CopyOnWrite容器进行并发的读，而不需要
 * 加锁，因为当前容器不会添加任何元素。所以CopyOnWrite容器也是一种读写分离
 * 容器
 */
public class ConcurrentTest {
}
