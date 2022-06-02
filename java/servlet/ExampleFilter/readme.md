# Filter实现自动登录
Servlet有三个高级特性，分别是过滤器、监听器、文件上传和下载  
## 创建一个Filter
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


# Listener实现在线人数统计
web应用中Listener就是一个实现了特定接口的java程序  
通过HttpSessionListener接口监听已登录用户的在线人数  
## 创建一个Listener
example
```java
@WebListener
public class Listener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public Listener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
```
> 几乎所有Java框架都建立在servlet之上，在Servlet3.0之前都需要在`web.xml`中配置，在Servlet3.0之后可以用注解的方式配置web框架，大大简化了web框架的开发  
