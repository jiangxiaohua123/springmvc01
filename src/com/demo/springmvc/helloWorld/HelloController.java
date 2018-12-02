package com.demo.springmvc.helloWorld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
