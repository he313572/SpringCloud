package com.honpe.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AccessFilter extends ZuulFilter {

	private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		logger.info("send {} request to {}", request.getMethod(), request.getRequestURI().toString());
		String token = request.getParameter("token");
		if (StringUtils.isBlank(token)) {
			logger.warn("token is empty");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			return null;

		}
		logger.info("token is ok");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// 该过滤器是否需要被执行
		return true;
	}
	
	@Override
	public int filterOrder() {
		// 过滤器的顺序
		return 0;
	}
	
	@Override
	public String filterType() {
		//定义过滤器的类型 表面请求前置执行
		return "pre";
	}

}
