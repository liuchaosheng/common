package com.zylearn.principle.demeter;

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
public class Client {
    public static void main(String[] args) {
        new PersonPrinter().doPrint();
    }
}

// 违背原则的案例 PersonPrinter类对Person类和Car类形成了很强的耦合关系。
// 这样会导致Person类和Car类一旦有修改
// 那么PersonPrinter类也会跟着需要很大的改动。
class PersonPrinter {
    public void doPrint() {
        Car car = new Car("宝马", 450000.0, "白色");
        Person person = new Person(car, "小明", 30);
        String personStr = String.format("person【姓名=%s，年龄：%d】\r\n\tcar【品牌=%s，价格=%f，颜色=%s】",
                person.getName(), person.getAge(), person.getCar().getCarBand(), person.getCar().getPrice(),
                person.getCar().getColor());
        System.out.println(personStr);
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
}




