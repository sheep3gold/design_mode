package com.ittest.chainsResponsibility;

public class MsgProcessor {
    private String msg;
//    Filter[] filters = {new HTMLFilter(), new SensitiveFilter(),
//            new FaceFilter()};

    private FilterChain fc;

    public FilterChain getFc() {
        return fc;
    }

    public void setFc(FilterChain fc) {
        this.fc = fc;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String process() {
       /* //process the html tag
        String r = new HTMLFilter().doFilter(msg);
        //process the sensitive words
        r = new SensitiveFilter().doFilter(r);*/
        String r = msg;
        r = fc.doFilter(r);
        return r;
    }
}
