package com.zylearn.student;

public class GenerateToStringBuilder implements ToStringBuilder{
    @Override
    public String buildBefore() {
        return "【";
    }

    @Override
    public String buildEnd() {
        return "】";
    }

    @Override
    public String buildKeySepValue() {
        return "=";
    }

    @Override
    public String buildNextSep() {
        return "\n";
    }
}
