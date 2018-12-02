package com.demo.springmvc.helloWorld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	
	@RequestMapping("/hello")
	public String handleHelo() {
		System.out.println("hello spring mvc");
		return "success";
	}
	
	/**
	 * REST GET
	 */
	@RequestMapping(value="/order/{id}",method=RequestMethod.GET)
	public String testRestGET(@PathVariable("id") String id) {
		System.out.println("REST GET: "+ id);
		return "success";
	}
	
	/**
	 * REST DELETE
	 */
	@RequestMapping(value="/order/{id}",method=RequestMethod.DELETE)
	public String testRestDELETE(@PathVariable("id") String id) {
		System.out.println("REST DELETE:  "+id);
		return "success";
	}
	
	/**
	 * REST POST
	 */
	@RequestMapping(value="/order",method=RequestMethod.POST)
	public String testPOST() {
		System.out.println("REST POST");
		return "success";
	}

	/**
	 * REST PUT
	 */
	@RequestMapping(value="/order",method=RequestMethod.PUT)
	public String testPUT() {
		System.out.println("REST PUT");
		return "success";
	}
	
	/**
	 * @RequestParam 映射请求参数到请求方法的形参
	 * 1、如果请求参数名与形参名一致，则可以省略@RequestParam的指定
	 * 2、@RequestParam 注解标注的形参必须要赋值。必须要能从请求对象中获取到对应的请求参数。
	 * 可以使用required来设置为不是必须的。
	 * 
	 * 3、可以使用defaultValue来指定一个默认值取代null
	 * 客户端的请求：testRequestParam?username=Tom&age=22
	 */
	@RequestMapping("/testRequestParam")
	public String testRequestParam(@RequestParam("username")String username,
			@RequestParam(value="age",required=false,defaultValue="0")int age) {
		System.out.println(username + " , " + age);
		return "success";
	}
	
	
	/**
	 * @RequestHead 映射请求头信息到请求处理方法的形参中
	 */
	@RequestMapping("testRequestHeader")
	public String testRequestHeader(@RequestHeader("Accept-Language")String acceptLanguage) {
		System.out.println("acceptLanguage:"+acceptLanguage);
		return "success";
		
	}
	
	/**
	 * @CookieValue 映射cookie信息到请求处理方法的形参中
	 */
	@RequestMapping("/testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID")String sessionId) {
		System.out.println("sessionId : "+sessionId);
		return "success";
	}
}
