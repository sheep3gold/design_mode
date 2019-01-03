package com.ittest.chainsResponsibility;

public class Main {
    public static void main(String[] args) {
        String msg = "大家好:),<script>,敏感,被就业，网络授课没感觉，看不见";
        MsgProcessor mp = new MsgProcessor();
        mp.setMsg(msg);
        FilterChain fc = new FilterChain();
        fc.addFilter(new HTMLFilter()).addFilter(new SensitiveFilter());
        FilterChain fc2 = new FilterChain();
        fc2.addFilter(new FaceFilter());
        fc.addFilter(fc2);
        mp.setFc(fc);
        String result = mp.process();
        System.out.println(result);
    }
}
