package com.zylearn.principle.interfacesegregation.demo01;

/**
 * 不适用接口隔离原则的接口往往方法比较多
 * 存在的问题：
 * 1、当前设计中，对于人，我们只关注其生活的方面，并不关注work()方法
 * 2、对于工人，我们只关注其工作的方面，并不关注eat()和sleep()方法。
 * 3、但是二者都实现了这个“大接口”，做了没必要的实现。
 *
 * 解决的方法：
 * 1、抽离成两个接口IPerson,IWorker
 * 2、这样看起来就比较清晰。
 */
public interface IBigInterface {
    public void eat();
    public void sleep();
    public void work();
}

class Person implements IBigInterface{
    @Override
    public void eat() {
        System.out.println("人在家吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("人在家睡觉");
    }

    @Override
    public void work() {
        System.out.println("工作。。。。我不一定要去。。。。");
    }
}

class Worker implements IBigInterface{
    @Override
    public void eat() {
        System.out.println("工人在职工食堂吃工作餐");
    }

    @Override
    public void sleep() {
        System.out.println("工人貌似的下班才吃饭");
    }

    @Override
    public void work() {
        System.out.println("工人拿着工具干活了，这才是重点");
    }
}
class client{
    public static void main(String[] args) {
        doLive(new Person());
        doWork(new Worker());
    }
    // 只关注生活的方法
    public static void doLive(IBigInterface person){
        person.eat();
        person.sleep();
    }
    // 只关注工作的方法
    public static void doWork(IBigInterface worker){
        worker.work();
    }
}
