package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

/**
 * Created by jay chen on 2016/8/24.
 */
@WebFilter(filterName = "wordFilter",urlPatterns = "/*",
        initParams = {@WebInitParam(name="encoding",value="GBK")})
public class wordFilter implements Filter {
    //非法字符数组
    private String words[];
    //字符编码
    private String encoding;

    public void destroy() {
        this.words=null;
        this.encoding=null;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //System.out.print("1");
        if (encoding != null) {
            // 设置request字符编码
            req.setCharacterEncoding(encoding);
            // 将request转换为重写后的Request对象
            req=new Request((HttpServletRequest) req);

            // 设置response字符编码
            resp.setContentType("text/html; charset="+encoding);
        }
        chain.doFilter(req, resp);
    }

    class Request extends HttpServletRequestWrapper{

        public Request(HttpServletRequest request) {
            super(request);
        }
        @Override
        public String getParameter(String name){
            return filter(super.getRequest().getParameter(name));
        }

        @Override public String[] getParameterValues(String name){
            String[] values=super.getRequest().getParameterValues(name);
            for(int i=0;i<values.length;i++){
                values[i]=filter(values[i]);
            }
            return values;
        }
    }

    public String filter(String param){
        try {
            // 判断非法字符是否被初始化
            if(words != null && words.length > 0){
                // 循环替换非法字符
                for (int i = 0; i < words.length; i++) {
                    // 判断是否包含非法字符
                    if(param.indexOf(words[i]) != -1){
                        // 将非法字符替换为"****"
                        param = param.replaceAll(words[i], "****");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return param;
    }

    public void init(FilterConfig config) throws ServletException {

        //获取字符编码
        this.encoding=config.getInitParameter("encoding");
        // 初始化非法字符数组
        words = new String[]{"糟糕","混蛋"};
    }

}
