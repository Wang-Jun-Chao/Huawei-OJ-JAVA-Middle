package huawei;

public final class Demo {

    public static class EnQueueInf {
        public int enElem;
    }

    public static class DeQueueInf {
        public int deElem;
    }
    /*
	请利用两个栈S1和S2来模拟一个队列。

	已知栈的四个运算定义如下：
	Init(ST): 初始化ST栈，初始化完成后的栈为空，没有任何元素；
	Push(ST,x): 元素x入ST栈；
	Pop(ST,x): ST栈顶元素出栈，赋给变量x；
	IsEmpty(ST): 判ST栈是否为空。

	那么如何利用栈的运算来实现该队列的四个运算：
	InitQueue: 初始化队列，初始化完成后的队列为空，没有任何元素；
	EnQueue: 插入一个元素入队列； 
	DeQueue: 删除一个元素出队列；
	IsEmptyQueue: 判队列是否为空。

	算法说明：
	栈的特点是后进先出，队列的特点是先进先出。所以，用两个栈S1和S2模拟一个队列时，
	S1作输入栈，逐个元素压栈，以此模拟队列元素的入队。当需要出队时，将栈S1退栈并逐
	个压入栈S2中，S1中最先入栈的元素，在S2中处于栈顶。S2退栈，相当于队列的出队，实
	现了先进先出。

	实现要求：
	1、要求两个栈S1和S2的长度都是5，也就是说队列最多可以存放10个元素，超过10个元素需要返回失败。
	2、EnQueue、DeQueue、IsEmptyQueue的返回值请严格按照说明返回，不可以随意变更。
	3、请按照算法说明实现该算法，不要采用其他方式实现队列。
	请严格按照上述要求实现，否则将导致用例执行失败。

	推荐实现步骤：
	1、首先实现栈的算法，也就是栈的四个操作。
	2、然后参考算法说明，通过对两个栈的操作来模拟一个队列。
	*/

    //初始化ST栈，初始化完成后的栈为空，没有任何元素；
    public static int initSt(Object st) {
	    /*在此添加代码*/
        return 0;
    }

    //元素x入ST栈；
    public static int push(Object st, int x) {
	    /*在此添加代码*/
        return 0;
    }

    //ST栈顶元素出栈，赋给变量x；
    public static int pop(Object st, int x) {
	    /*在此添加代码*/
        return 0;
    }

    //判ST栈是否为空。
    public static int isEmpty(Object st) {
	    /*在此添加代码*/
        return 0;
    }

    //初始化队列，初始化完成后的队列为空，没有任何元素；
    public static int initQueue() {
	    /*在此添加代码*/
        return 0;
    }

    //将元素Elem插入队列，若入队列成功返回0，否则返回1。
    public static int enQueue(EnQueueInf elem) {
	    /*在此添加代码*/
        return 0;
    }

    //从队列中取出一个元素放入pElem，若出队列成功返回0，否则返回1。
    public static int deQueue(DeQueueInf elem) {
	    /*在此添加代码*/
        return 0;
    }

    //判用队列是否为空，如果是空则返回1，如果不是空则返回0。
    public static int isEmptyQueue() {
	    /*在此添加代码*/
        return 0;
    }
}