package com.coderiver.codeforum.web.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by Shiyu Rao on 08/03/2019.
 * 这个类的作用是 将请求头内信息 放入Zuul channel的请求头中
 */
@Component
public class WebPreFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(WebPreFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();

        Map<String, String> zuulRequestHeaders = currentContext.getZuulRequestHeaders();
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            zuulRequestHeaders.put(headerName, request.getHeader(headerName));
        }
        logger.debug("webPreFilter works....");
        return null;
    }
}
