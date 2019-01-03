package com.ittest.chainsResponsibility.testWeb;

public class HTMLFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response,FilterChain chain) {
        request.requestStr = request.requestStr.replaceAll("<", "[")
                .replaceAll(">", "]") + "---HTMLFilter()";
        chain.doFilter(request, response, chain);
        response.responseStr += "---HTMLFilter()";
    }
}
