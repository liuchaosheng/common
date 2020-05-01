package com.zylearn.principle.dependencyreversion;

/**
 * 依赖倒置原则
 * 1、抽象应该关注于指定规则和契约，不应该依赖于具体。
 * 2、具体应该依赖于抽闲。
 * 3、应该相对于具体的各种不确定性，抽象更稳定。
 * 4、应用到代码中就是：设计应该基于接口和抽象类。
 * 5、这样设计的好处是程序的可扩展性好了，增加新的类，client端代码不用修改
 */
public class MainDemo {
    public static void main(String[] args) {
        useComputer(new LenevoComputer());
        useComputerNew(new LenevoComputerNew());
    }
    // 方案一 使用电脑的方法(不满足依赖倒置原则)
    public static void useComputer(Object obj){
        if(obj instanceof LenevoComputer){
            LenevoComputer lenevoComputer = (LenevoComputer)obj;
            lenevoComputer.start();
        }else if(obj instanceof HuipuComputer){
            HuipuComputer huipuComputer = (HuipuComputer)obj;
            huipuComputer.start();
        }else{
            // 若增加了新的电脑类，则需要在这里修改代码来使用新的电脑类
            System.out.println("不支持的品牌！");
        }
    }

    // 方案二 使用电脑的方法(满足依赖倒置原则)
    public static void useComputerNew(IComputer computer){
        // 若添加新类，那么该处代码不需要修改
        computer.start();
    }
}
// 不使用该原则设计电脑类
class LenevoComputer{
    public void start(){
        System.out.println("联想电脑启动了！");
    }
}
class HuipuComputer{
    public void start(){
        System.out.println("惠普电脑启动了！");
    }
}

interface IComputer{
    public void start();
}
class LenevoComputerNew implements IComputer{
    @Override
    public void start() {
        System.out.println("联想电脑启动了！");
    }
}
class HuipuComputerNew implements IComputer{
    @Override
    public void start() {
        System.out.println("惠普电脑启动了！");
    }
}
