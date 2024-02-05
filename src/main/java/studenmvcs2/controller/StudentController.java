package studenmvcs2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import studenmvcs2.dao.StudentDao;
import studenmvcs2.dto.Student;

@Controller
public class StudentController {
	@Autowired
	private StudentDao dao;

	@RequestMapping("/register")
	public ModelAndView registerStudent() {
		ModelAndView  modelAndView=new ModelAndView();
		
//		empty student object
		modelAndView.addObject("student", new Student());
		modelAndView.setViewName("register.jsp");
		
		
		return modelAndView;
	}
	@RequestMapping("/save")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		ModelAndView modelAndView=new ModelAndView();
		
		dao.saveStudent(student);
		
		
		modelAndView.addObject("list", dao.getAllStudents());
		modelAndView.setViewName("display.jsp");
		
		return modelAndView;
	}
	
}
