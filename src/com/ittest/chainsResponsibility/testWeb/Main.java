package com.ittest.chainsResponsibility.testWeb;

public class Main {
    public static void main(String[] args) {
        String msg = "大家好:),<script>,敏感,被就业，网络授课没感觉，看不见";
        Request request = new Request();
        request.setRequestStr(msg);
        Response response = new Response();
        response.setResponseStr("response");

        FilterChain fc = new FilterChain();
        fc.addFilter(new HTMLFilter()).addFilter(new SensitiveFilter())
                .addFilter(new FaceFilter());
        fc.doFilter(request, response,fc);
        System.out.println(request.requestStr);
        System.out.println(response.getResponseStr());
    }
}
