package com.XS.pojo;

import java.util.List;

public class StudentScoreList {
    String temp;

    private List<StudentScore> list;

    List<String> diff;

    List<String> ability;

    List<String> scope;

    List<String> type;


    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public List<StudentScore> getList() {
        return list;
    }

    public void setList(List<StudentScore> list) {
        this.list = list;
    }

    public void setDiff(List<String> diff) {
        this.diff = diff;
    }

    public void setAbility(List<String> ability) {
        this.ability = ability;
    }

    public void setScope(List<String> scope) {
        this.scope = scope;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public List<String> getDiff() {
        return diff;
    }

    public List<String> getAbility() {
        return ability;
    }

    public List<String> getScope() {
        return scope;
    }

    public List<String> getType() {
        return type;
    }
}
