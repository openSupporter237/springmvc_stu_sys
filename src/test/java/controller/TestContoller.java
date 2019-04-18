package controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import dao.StuDao;
import dao.impl.StuDaoImpl;
import domain.Student;
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestContoller {
	@Autowired
	private TestController controller;
	@Autowired
	private StuController stuController;
	@Ignore
	public void testView() throws Exception {
		StuController controller = new StuController();
		MockMvc mockmvc = standaloneSetup(controller).build();
		mockmvc.perform(get("/stulist"))
		.andExpect(view().name("studentList"));
	}
	@Ignore
	public void testModel() throws Exception {
		List<Student> expectedStulist = new ArrayList<Student>();
		Student stu = new Student((long)1,"jack","ÄÐ",25);
		expectedStulist.add(stu);
		StuDao stuDao = new StuDaoImpl();
		StuController controller = new StuController();
		controller.setStuDao(stuDao);
		MockMvc mockmvc = standaloneSetup(controller).build();
		mockmvc.perform(get("/stulist"))
		.andExpect(model().attributeExists("stulist"))
		.andExpect(model().attribute("stulist", expectedStulist));
	}
	@Ignore
	public void testCharset() throws UnsupportedEncodingException {
		String encode_str = URLEncoder.encode("ÐÂ","UTF-8");
		System.out.println(encode_str);
	}
	@Ignore
	public void testAop() {
/*		TestController controller = new TestController();*/
		long sid=(long)1;
		controller.testAop(sid);
	}
	@Test
	public void aopController() throws Exception {
		MockMvc mockmvc = standaloneSetup(stuController).build();
		mockmvc.perform(get("/findone/1"));
	}
}
