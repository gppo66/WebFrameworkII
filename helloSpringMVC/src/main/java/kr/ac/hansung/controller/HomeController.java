package kr.ac.hansung.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		//trace > debug > info > warn > error
	logger.trace("Trace Level");
	logger.debug("debug Level");
	logger.info("info Level");
	logger.warn("warn Level");
	logger.error("error Level");
	String url = request.getRequestURL().toString();
	String clientIP = request.getRemoteAddr();
	logger.info("Request URL: {}, Client IP: {}",url,clientIP);
		return "home";
	}
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newHome() {

		return "index";
	}
}
