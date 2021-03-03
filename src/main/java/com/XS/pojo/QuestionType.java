package com.XS.pojo;

public class QuestionType {
    private Integer id;

    private String qtype;

    private Integer sujectid;

    private Integer gradeid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQtype() {
        return qtype;
    }

    public void setQtype(String qtype) {
        this.qtype = qtype == null ? null : qtype.trim();
    }

    public Integer getSujectid() {
        return sujectid;
    }

    public void setSujectid(Integer sujectid) {
        this.sujectid = sujectid;
    }

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }
}