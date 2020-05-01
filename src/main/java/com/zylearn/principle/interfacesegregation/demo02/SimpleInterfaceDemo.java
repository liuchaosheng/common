package com.zylearn.principle.interfacesegregation.demo02;

// 采用了接口隔离原则
// Person类和Worker类都不需要实现多余的方法。
// client使用起来清晰明了，不会产生歧义。
public class SimpleInterfaceDemo {
    public static void main(String[] args) {
        doLive(new Person());
        doWork(new Worker());
    }
    // 只关注生活的方法
    public static void doLive(IPerson person){
        person.eat();
        person.sleep();
    }
    // 只关注工作的方法
    public static void doWork(IWorker worker){
        worker.work();
    }
}

interface IPerson{
    public void eat();
    public void sleep();
}
interface IWorker{
    public void work();
}

class Person implements IPerson{
    @Override
    public void eat() {
        System.out.println("人在家吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("人在家睡觉");
    }

}

class Worker implements IWorker{
    @Override
    public void work() {
        System.out.println("工作，才是我最关心的！！！");
    }
}