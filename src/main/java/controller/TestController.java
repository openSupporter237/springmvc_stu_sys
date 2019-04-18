package controller;

import org.springframework.stereotype.Controller;

@Controller
public class TestController {

	public TestController() {
		// TODO Auto-generated constructor stub
	}
	public void testAop(long sid) {
		System.out.println(sid);
	}
}
