package com.XS.pojo;

public class StudentScoreWrite {
    private Integer id;

    private Integer examid;

    private Integer studentid;

    private Integer iswrite;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getIswrite() {
        return iswrite;
    }

    public void setIswrite(Integer iswrite) {
        this.iswrite = iswrite;
    }

    @Override
    public String toString() {
        return "StudentScoreWrite{" +
                "id=" + id +
                ", examid=" + examid +
                ", studentid=" + studentid +
                ", iswrite=" + iswrite +
                '}';
    }
}