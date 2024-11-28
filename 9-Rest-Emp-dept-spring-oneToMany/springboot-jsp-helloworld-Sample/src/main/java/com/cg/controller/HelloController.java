package com.cg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.model.Employee;

@Controller
public class HelloController {
    @GetMapping({"/", "/hello"})
    public String hello(Model model, @RequestParam(value="uname", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }
    
    @GetMapping("/demo")
    public String hello1() {
        return "declaration";
    }
    
    @PostMapping("/login")
    public String handleLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model) {
       
        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
            model.addAttribute("username", username);
            return "welcome"; // welcome.jsp
        }
 
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.jsp
    }
    @GetMapping("/testRequest")
    public String testRequestObject(HttpServletRequest request) {
       
        request.setAttribute("message", "Hello from the Request Object!");
        return "testRequest";
    }
    @GetMapping("/testResponse")
    public String testResponseObject(HttpServletResponse response, Model model) throws IOException {
        response.setHeader("X-Custom-Header", "This is a custom header!");
        response.setStatus(HttpServletResponse.SC_OK); // 200 OK status
        response.setContentType("text/html;charset=UTF-8");
 
        model.addAttribute("responseMessage", "Response object test successful!");
        model.addAttribute("responseContentType", response.getContentType());
        model.addAttribute("responseStatus", response.getStatus());
        model.addAttribute("customHeader", response.getHeader("X-Custom-Header"));
 
        
        response.getWriter().write("<h1>This is written directly to the response output stream!</h1>");
 
        // Forward to JSP page
        return "testResponse"; // Forward to testResponse.jsp
    }
    
    @Value("${app.name}")
    private String appName;
    
    
    @GetMapping("/configTest")
    public String showConfigParameter(Model model) {
        model.addAttribute("appName", appName); // Add the appName value to the model
        return "configTest";  // Forward to configTest.jsp
    }
    @Value("${company}")
    private String company;
    
    @Value("${myname}")
    private String myname;
    
 
    @GetMapping("/mypage") //PageContext
    public String welcome( Model model) {
        model.addAttribute("myname", myname);
        model.addAttribute("company", company);
        return "callme";  // Forward to welcome.jsp
    }
    
    @GetMapping("/emp")
    public String showEmployeeProfile(Model model) {
       
        Employee employee = new Employee(1, "Anshu", "Anshu@gmail.com");
        model.addAttribute("employee", employee);
        return "emp";  
    }
    
    @GetMapping("/forwardDemo")
    public void forwardRequest(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        model.addAttribute("message", "This is forwarded from the original controller.");
 
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/forwardPage.jsp");
        dispatcher.forward(request, response);
    }
    @GetMapping("/includeDemo")
    public String includeRequest(Model model) {
        model.addAttribute("message", "This message is included from another page.");
        return "login1";  
    }
}
