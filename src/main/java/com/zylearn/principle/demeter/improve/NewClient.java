package com.zylearn.principle.demeter.improve;


/**
 * 迪米特法则
 * 1、一个对象应该对其他对象保持最小的了解。
 * 2、被依赖的类应该足够封装，通过public暴露必要的方法给别的类使用。
 * 3、只和简单朋友通信：
 * 成员变量，方法参数，方法返回值的关系称为直接朋友。
 * 否则称为陌生类。
 * 该法则主要是要分清直接朋友和陌生朋友。
 * 尽量避免在局部变量中出现陌生类。
 */
public class NewClient {
    public static void main(String[] args) {
        Car car = new Car("宝马", 450000.0, "白色");
        Person person = new Person(car, "小明", 30);
        new PersonPrinter().doPrint(person);
    }
}

class PersonPrinter {
    public void doPrint(Person person) {
        // 不满足迪米特法则的代码
//        Car car = new Car("宝马", 450000.0, "白色");
//        Person person = new Person(car, "小明", 30);
//        String personStr = String.format("person【姓名=%s，年龄：%d】\r\n\tcar【品牌=%s，价格=%f，颜色=%s】",
//                person.getName(), person.getAge(), person.getCar().getCarBand(), person.getCar().getPrice(),
//                person.getCar().getColor());
//        System.out.println(personStr);


        // 将上述注释的打印程序进行修改，看起就好很多，PersonPrinter对Person类的耦合度降低
        // 无论Person类怎么更改，我们基本不会修改PersonPrinter类的代码
        System.out.println(person.toString());
    }
}

class Person {
    private Car car;
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(Car car, String name, Integer age) {
        this.car = car;
        this.name = name;
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("person【姓名=%s，年龄：%d】\r\n\t%s",this.name,this.age,this.car.toString());
    }
}

class Car {
    private String carBand;
    private Double price;
    private String color;

    public Car() {

    }

    public Car(String carBand, Double price, String color) {
        this.carBand = carBand;
        this.price = price;
        this.color = color;
    }

    public void setCarBand(String carBand) {
        this.carBand = carBand;
    }

    public String getCarBand() {
        return carBand;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("car【品牌=%s，价格=%f，颜色=%s】",this.carBand,this.price,this.color);
    }
}




