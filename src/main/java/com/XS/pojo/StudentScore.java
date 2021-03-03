package com.XS.pojo;

public class StudentScore {
    private Integer id;

    private Integer examid;

    private Integer studentid;

    private Integer questionnum;

    private Float score;

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

    public Integer getQuestionnum() {
        return questionnum;
    }

    public void setQuestionnum(Integer questionnum) {
        this.questionnum = questionnum;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentScore{" +
                "id=" + id +
                ", examid=" + examid +
                ", studentid=" + studentid +
                ", questionnum=" + questionnum +
                ", score=" + score +
                '}';
    }
}