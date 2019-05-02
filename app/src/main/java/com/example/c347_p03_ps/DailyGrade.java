package com.example.c347_p03_ps;

import java.io.Serializable;

public class DailyGrade implements Serializable {

    private String week;
    private String grade;

    public DailyGrade(String week, String grade) {
        this.week = week;
        this.grade = grade;
    }

    public String getWeek() {
        return week;
    }
    public String getGrade() {
        return grade;
    }
}
