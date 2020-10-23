package com.example.myapplication.bean;


public class HistoryBean {

    /**
     * code : 10498939729513
     * index : 1
     * casetime : 2020-10-16 17:25
     * casecode :
     * casestate : 未处理
     */

    private Long code;
    private Integer index;
    private String casetime;
    private String casecode;
    private String casestate;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getCasetime() {
        return casetime;
    }

    public void setCasetime(String casetime) {
        this.casetime = casetime;
    }

    public String getCasecode() {
        return casecode;
    }

    public void setCasecode(String casecode) {
        this.casecode = casecode;
    }

    public String getCasestate() {
        return casestate;
    }

    public void setCasestate(String casestate) {
        this.casestate = casestate;
    }
}
