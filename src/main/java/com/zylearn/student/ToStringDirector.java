package com.zylearn.student;

public class ToStringDirector {
    private StringBuilder stringBuilder;
    public ToStringDirector(){
        stringBuilder = new StringBuilder();
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public void setStringBuilder(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    // 传入建造者
    public String doBuild(ToStringBuilder builder,Person person){
        stringBuilder.append(person.getClass().getName());
        stringBuilder.append(builder.buildBefore());
        stringBuilder.append(builder.buildNextSep());

        stringBuilder.append("name");
        stringBuilder.append(builder.buildKeySepValue());
        stringBuilder.append(person.getName());
        stringBuilder.append(builder.buildNextSep());

        stringBuilder.append("age");
        stringBuilder.append(builder.buildKeySepValue());
        stringBuilder.append(person.getAge());
        stringBuilder.append(builder.buildNextSep());

        stringBuilder.append(builder.buildEnd());
        stringBuilder.append(builder.buildNextSep());
        return stringBuilder.toString();
    }
}
