package com.ittest.chainsResponsibility.testWeb;

public class FaceFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response,FilterChain chain) {
        request.requestStr = request.requestStr.replaceAll(":\\)", "^v^")
                + "---FaceFilter()";
        chain.doFilter(request, response, chain);
        response.responseStr += "---FaceFilter()";
    }
}
