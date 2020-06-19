package com.virtusa.apigatewaydemo.filters;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PreFilterImpl extends ZuulFilter {
	private static Logger log = LoggerFactory.getLogger(PreFilterImpl.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(request.getRemoteAddr());
        log.info("PreFilter: " + String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        if(!request.getRemoteAddr().equals("0:0:0:0:0:0:0:1")){
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("access denied");
            ctx.setSendZuulResponse(false);

        }
        return null;
    }
}