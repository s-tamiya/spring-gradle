package hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.dto.HelloDto;
import hello.service.HelloService;

/**
 * HelloController
 * @author s-tamiya
 */
@Controller
public class HelloController {
	
	@Autowired
	HelloService helloService;
	
	/**
	 * ����������̂܂܃��N�G�X�g��ɕԋp����
	 * 
	 * @return �����񂪂��̂܂ܕ\�������
	 */
	@RequestMapping( value = "/", method = RequestMethod.GET)
	@ResponseBody
	public String topPage() {
		return "�����񂪂��̂܂ܕ\�������";
	}
	
	/**
	 * Hello World�y�[�W
	 * @return HelloWorld�y�[�W
	 */
	@RequestMapping( value = "/hello", method = RequestMethod.GET)
	public String hello(@RequestParam int num, Model model) {
		List<HelloDto> helloDtoList = helloService.numToFizzbuzzList(num);

		model.addAttribute("helloDtoList", helloDtoList);
		model.addAttribute("msg", "test");
		
		return "hello/hello";
	}
}
