package app01a;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ServletConfigServlet", 
	urlPatterns = { "/servletConfigDemo" },
	initParams = {
		@WebInitParam(name = "admin", value = "Harry Taciak"),
		@WebInitParam(name = "email", value = "admin@example.com")
	}
)
public class ServletConfigDemoServlet implements Servlet{
	
	private transient ServletConfig servletConfig;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.servletConfig;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "ServletConfig Demo";
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.servletConfig = servletConfig;
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//返回请求主体中的字节数，如果不知道字节的长度,该方法返回-1
		int length = request.getContentLength();
		System.out.println("字节长度:" + length);
		//返回请求主体的MIME类型，如果不知道类型，则返回null
		String contentType = request.getContentType();
		System.out.println("MIME类型:" + contentType);
		//返回这个HTTP请求的协议名称和版本号
		System.out.println("协议名称、版本号:" + request.getProtocol());
		//返回指定请求参数的值
		String id = request.getParameter("id");
		System.out.println("id=" + id);
		//getParameterMap
		Map<String, String[]> map = request.getParameterMap();
		System.out.println(map.toString());
		//getParameterNames
		Enumeration<String> keys = request.getParameterNames();
		while(keys.hasMoreElements()){
			String name = (String) keys.nextElement();
			String value = request.getParameter(name);
			System.out.println(name + "=:" + value);
		}
		//getParameterValues
		String[] str = request.getParameterValues("checkbox");
		
		ServletConfig servletConfig = getServletConfig();
		
		String admin = servletConfig.getInitParameter("admin");
		
		String email = servletConfig.getInitParameter("email");
		
		response.setContentType("text/html");
		
		PrintWriter writer = response.getWriter();
		
		writer.print("<html><head></head><body>Admin:" + admin + "</br>Email:" + email + "</body></html>");
	}
	

}
