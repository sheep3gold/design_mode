package com.ittest.chainsResponsibility;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();

    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    public String doFilter(String str) {
        String r = str;
        for (Filter filter : filters) {
            r = filter.doFilter(r);
        }
        return r;
    }
}
