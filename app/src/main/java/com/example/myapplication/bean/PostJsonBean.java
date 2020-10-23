package com.example.myapplication.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostJsonBean {


    /**
     * state : 0
     * case : [{"code":10497401517239,"index":1,"casetime":"2020-10-16 13:12","casecode":"","casestate":null},{"code":10497401517323,"index":2,"casetime":"2020-10-16 13:31","casecode":"","casestate":null},{"code":10497401517326,"index":3,"casetime":"2020-10-16 13:31","casecode":"","casestate":null},{"code":10497401517341,"index":4,"casetime":"2020-10-16 13:34","casecode":"","casestate":null},{"code":10497401517356,"index":5,"casetime":"2020-10-16 13:37","casecode":"","casestate":null},{"code":10497401517386,"index":6,"casetime":"2020-10-16 13:41","casecode":"","casestate":null},{"code":10498954331699,"index":7,"casetime":"2020-10-16 17:37","casecode":"","casestate":"未处理"},{"code":10503110318179,"index":8,"casetime":"2020-10-20 09:28","casecode":"","casestate":"未处理"},{"code":10503110318207,"index":9,"casetime":"2020-10-20 09:31","casecode":"","casestate":"未处理"},{"code":10503110318424,"index":10,"casetime":"2020-10-20 09:48","casecode":"","casestate":"未处理"},{"code":10503110318469,"index":11,"casetime":"2020-10-20 09:50","casecode":"","casestate":"未处理"},{"code":10503110318880,"index":12,"casetime":"2020-10-20 10:23","casecode":"","casestate":"未处理"},{"code":10503110318896,"index":13,"casetime":"2020-10-20 10:25","casecode":"","casestate":"未处理"},{"code":10503110318910,"index":14,"casetime":"2020-10-20 10:28","casecode":"","casestate":"未处理"},{"code":10503110318916,"index":15,"casetime":"2020-10-20 10:29","casecode":"","casestate":"未处理"},{"code":10503110318931,"index":16,"casetime":"2020-10-20 10:31","casecode":"","casestate":"未处理"},{"code":10503110318969,"index":17,"casetime":"2020-10-20 10:35","casecode":"","casestate":"未处理"},{"code":10503110318992,"index":18,"casetime":"2020-10-20 10:38","casecode":"","casestate":"未处理"},{"code":10503110319010,"index":19,"casetime":"2020-10-20 10:40","casecode":"","casestate":"未处理"},{"code":10503110319028,"index":20,"casetime":"2020-10-20 10:44","casecode":"","casestate":"未处理"},{"code":10503110319040,"index":21,"casetime":"2020-10-20 10:46","casecode":"","casestate":"未处理"},{"code":10503110319072,"index":22,"casetime":"2020-10-20 10:47","casecode":"","casestate":"未处理"},{"code":10503110319087,"index":23,"casetime":"2020-10-20 10:49","casecode":"","casestate":"未处理"},{"code":10503110319097,"index":24,"casetime":"2020-10-20 10:52","casecode":"","casestate":"未处理"},{"code":10503110319100,"index":25,"casetime":"2020-10-20 10:52","casecode":"","casestate":"未处理"},{"code":10503110319278,"index":26,"casetime":"2020-10-20 11:15","casecode":"","casestate":"未处理"},{"code":10503110319287,"index":27,"casetime":"2020-10-20 11:17","casecode":"","casestate":"未处理"},{"code":10504132253062,"index":28,"casetime":"2020-10-20 14:07","casecode":"","casestate":"未处理"},{"code":10504132253064,"index":29,"casetime":"2020-10-20 14:07","casecode":"","casestate":"未处理"},{"code":10504132253131,"index":30,"casetime":"2020-10-20 14:12","casecode":"","casestate":"未处理"},{"code":10504132253416,"index":31,"casetime":"2020-10-20 14:47","casecode":"","casestate":"未处理"}]
     */

    private Integer state;
    private List<CaseBean> caseX;


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<CaseBean> getCaseX() {
        return caseX;
    }

    public void setCaseX(List<CaseBean> caseX) {
        this.caseX = caseX;
    }

    public static class CaseBean {
        /**
         * code : 10497401517239
         * index : 1
         * casetime : 2020-10-16 13:12
         * casecode :
         * casestate : null
         */

        private Long code;
        private Integer index;
        private String casetime;
        private String casecode;
        private Object casestate;

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

        public Object getCasestate() {
            return casestate;
        }

        public void setCasestate(Object casestate) {
            this.casestate = casestate;
        }
    }
}
