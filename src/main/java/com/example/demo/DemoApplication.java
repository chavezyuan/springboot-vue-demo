package com.example.demo;

import com.example.demo.mapper.PersonMapper;
import com.example.demo.mapper.extend.PersonMapperExtend;
import com.example.demo.object.Person;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


@SpringBootApplication
@Controller
@MapperScan("com.example.demo.mapper.**")
public class DemoApplication {

	@Resource
	private PersonMapperExtend personMapperExtend;

	@Resource
	private PersonMapper personMapper;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("hello")
	@ResponseBody
	public Person hello() {

		Person person = personMapper.selectByPrimaryKey(1);

		List<Person> persons = personMapperExtend.findAll();
		return persons.get(0);
	}

	@GetMapping("index")
	public String index() {
		return "index.html";
	}

}
