package com.ittest.chainsResponsibility.testWeb;

public interface  Filter {
    void doFilter(Request request,Response response,FilterChain chain);
}
