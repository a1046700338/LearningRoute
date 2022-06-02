# Filter实现自动登录
Servlet有三个高级特性，分别是过滤器、监听器、文件上传和下载  
# 创建一个Filter
example
```java
@WebFilter(name="ExampleFilter",urlPatterns="/ExampleFilter")
public class ExampleFilter implements Filter{
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException,ServletException{
		PrintWriter out = response.getWriter();
		out.write("Hello MyFilter");
	}
}

```
`@WebFilter`注解与`@WebServlet`类似，通过`urlPatterns`属性指定过滤器要拦截的url，值得注意的是Filter的执行顺序是按照类名控制的  
