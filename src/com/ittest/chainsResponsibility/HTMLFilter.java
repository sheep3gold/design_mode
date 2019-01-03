package com.ittest.chainsResponsibility;

public class HTMLFilter implements Filter {
    @Override
    public String doFilter(String str) {
        String r = str;
        r = r.replaceAll("<", "[")
                .replaceAll(">", "]");
        return r;
    }
}
