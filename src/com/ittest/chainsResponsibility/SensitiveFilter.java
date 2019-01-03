package com.ittest.chainsResponsibility;

public class SensitiveFilter implements Filter{

    @Override
    public String doFilter(String str) {
        String r = str;
        r = r.replaceAll("被就业", "就业")
                .replaceAll("敏感", "");
        return r;
    }
}
