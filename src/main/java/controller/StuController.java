package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import dao.StuDao;
import domain.Student;

@Controller
//@RequestMapping(value="/stu")
@SessionAttributes(names={"stulist"})
public class StuController {
	@Autowired
	private StuDao stuDao;
	public void setStuDao(StuDao stuDao) {
		this.stuDao = stuDao;
	}
	/*@RequestMapping(value="/stulist.do",method=RequestMethod.GET)
	public String stulist(Model model,@RequestParam("offset") int offset,@RequestParam int size) {
		List<Student> studentList = stuDao.getStudentList(offset, size);
		model.addAttribute("stulist", studentList);
		return "studentList";
	}*/
	@RequestMapping(value="/stulist.do",method=RequestMethod.GET)
	public String stulist(Model model,HttpServletRequest request) {
		int offset = Integer.valueOf(request.getParameter("offset"));
		int size = Integer.valueOf(request.getParameter("size"));
		List<Student> studentList = stuDao.getStudentList(offset, size);
		model.addAttribute("stulist", studentList);
		return "studentList";
	}
	/*@RequestMapping(value="/stulist.do",method=RequestMethod.GET)
	public String stulist() {
		return "studentList";
	}*/
	@RequestMapping(value="/findone/{sid}",method=RequestMethod.GET)
	public String findOne(@PathVariable("sid") long sid,Model model,HttpServletResponse response) {
		Student stu=stuDao.getOneStudent(sid);
		model.addAttribute("student", stu);
		return "student";
	}
	@RequestMapping(value="/regist.do",method=RequestMethod.GET)
	public String showRegistForm() {
		return "addStudent";
	}
	@RequestMapping(value="/addOne.do",method=RequestMethod.GET)
	public String addOne(Student stu,Model model) {
		stuDao.addStudent(stu);
		return "redirect:/stulist.do?offset=0&size=10";
	}
	/*@RequestMapping(value="/submitPhoto.do",method=RequestMethod.POST)
	public String submitPhoto(@RequestParam("file") MultipartFile file,Model model,HttpServletRequest request) throws IllegalStateException, IOException {
		String dest=request.getSession().getServletContext().getRealPath("/")+"/photos/";
		String oldname=file.getOriginalFilename();
		String ext=oldname.substring(oldname.lastIndexOf(".")+1, oldname.length());
		String newFilename=String.valueOf(System.currentTimeMillis());
		newFilename=newFilename+"."+ext;
		dest=dest+newFilename;
		file.transferTo(new File(dest));
		String visitPath=request.getContextPath()+"/photos/"+newFilename;
		model.addAttribute("photoPath", visitPath);
		return "showPhoto";
	}*/
	@RequestMapping(value="/submitPhoto.do",method=RequestMethod.POST)
	public String submitPhoto(@RequestPart MultipartFile file,Model model) {
		/*String dest="/photos/";
		String newFilename=String.valueOf(System.currentTimeMillis());
		dest+=dest+newFilename;
		System.out.println("filesize="+file.length/1024+"KB");*/
		System.out.println("filename="+file.getOriginalFilename());
		return "showPhoto";
	}
	@RequestMapping(value="/choosePhoto.do",method=RequestMethod.GET)
	public String choosePhoto() {
		return "submitPhoto";
	}
	@RequestMapping(value="/submitPhoto2.do",method=RequestMethod.POST)
	@ResponseBody
	public String submitPhoto2(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException {
		String dest=request.getSession().getServletContext().getRealPath("/")+"/photos/";
		String oldname=file.getOriginalFilename();
		String ext=oldname.substring(oldname.lastIndexOf(".")+1, oldname.length());
		String newFilename=String.valueOf(System.currentTimeMillis());
		newFilename=newFilename+"."+ext;
		newFilename="ÐÂ"+newFilename;
		dest=dest+newFilename;
		file.transferTo(new File(dest));
		String visitPath=request.getContextPath()+"/photos/"+newFilename;
		return visitPath;
	}
	@RequestMapping(value="/searchStudent.do",method=RequestMethod.POST)
	@ResponseBody
	public List<Student> searchStudent(@RequestParam("name") String name) {
		List<Student> list = stuDao.getOneStudent(name);
		return list;
	}
	
	
}
