package com.zylearn.principle.liskovsubstitution;

public class MainDemo {
    public static void main(String[] args) {
        eat(new NormalEat());
        eat(new ExNormalEat());
    }
    public static void eat(EatBase eat){
        eat.doEat(1);
        eat.doEat(16);
    }
}

abstract class EatBase{
    // 交给子类实现
    protected abstract void eatSimpleFood();
    protected abstract void eatRichFood();

    protected abstract void doEat(int money);
}

class NormalEat extends EatBase{
    // 假设根据传入的钱的多少决定吃什么食物
    @Override
    public void doEat(int money){
        if(money < 15){
            eatSimpleFood();
        }else{
            eatRichFood();
        }
    }
    @Override
    protected void eatRichFood() {
        System.out.println("来条鱼，再来个红烧狮子头！！！牛逼啊");
    }

    @Override
    protected void eatSimpleFood() {
        System.out.println("哎，一盘青菜，一碗米饭吧。。。。");
    }
}

class ExNormalEat extends NormalEat{
    @Override
    public void doEat(int money){
        // 重写了父类的方法 导致父类中定义的逻辑被修改
        System.out.println("我重写了doEat方法，结果导致，拿我我的实例替换父类实例的时候代码运行结果不一致了！！！");
    }
    @Override
    protected void eatSimpleFood() {
        System.out.println("哎，我就喜欢喝点白开水");
    }
}