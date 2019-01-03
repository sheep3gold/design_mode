package com.ittest.chainsResponsibility.testWeb;

public class SensitiveFilter implements Filter {


    @Override
    public void doFilter(Request request, Response response,FilterChain chain) {
        request.requestStr = request.requestStr.replaceAll("被就业", "就业")
                .replaceAll("敏感", "") + "---SensitiveFilter()";
        chain.doFilter(request, response, chain);
        response.responseStr += "---SensitiveFilter()";
    }
}
