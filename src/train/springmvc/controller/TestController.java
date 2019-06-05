package train.springmvc.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import train.springmvc.domain.Test;
import train.springmvc.service.TestService;
import train.springmvc.util.Pager;
import freemarker.template.TemplateException;

/**
 * Test Controller
 */
@Controller
@RequestMapping("FreeMarkerSpringMVC")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	Map<String, Object> map = new HashMap<String, Object>();

	// 列表
	@RequestMapping(value = {"", "/list"})
	public ModelAndView list(@RequestParam(value = "p", required = false, defaultValue = "1") int p, HttpServletRequest request) throws IOException, TemplateException {
		ModelAndView mv = new ModelAndView();
		Pager pager = new Pager();
		pager.setPageNo(p);
		pager.setTotalCount(testService.findCount());
		mv.addObject("pager", pager);
		
		mv.addObject("testList", testService.findAll(pager));
		mv.setViewName("test/TestList");
		return mv;
	}
	
	// 搜索
	@RequestMapping("/search")
	public String search(Model model, @RequestParam("k") String k) {
		model.addAttribute("k", k);
		model.addAttribute("testList", testService.getSearchList(k));
		return "test/TestList";
	}
	
	// 添加
	@RequestMapping("/add")
	public ModelAndView add(Test test) {
		test.setTestStatus(false);
		return new ModelAndView("test/TestEdit", "test", test);
	}
	
	// 编辑
	@RequestMapping("/{testId}")
	public ModelAndView edit(@PathVariable String testId) {
		return new ModelAndView("test/TestEdit", "test", testService.findById(testId));
	}
	
	// 保存
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Test test) throws IOException {
		if (0 == test.getTestId()) {
			test.setTestDate(new Date());
			testService.save(test);
		} else {
			testService.update(test);
		}
		return "redirect:/FreeMarkerSpringMVC";
	}
	
	// 删除
	@RequestMapping("/del/{testId}")
	public String delete(@PathVariable String testId) {
		testService.delete(testId);
		return "redirect:/FreeMarkerSpringMVC";
	}
	
}
