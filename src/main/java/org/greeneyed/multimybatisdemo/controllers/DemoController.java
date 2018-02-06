package org.greeneyed.multimybatisdemo.controllers;

import java.util.HashMap;
import java.util.Map;

import org.greeneyed.multimybatisdemo.mappers.AnotherMapper;
import org.greeneyed.multimybatisdemo.mappers.OneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@Data
public class DemoController {

	@Autowired
	OneMapper oneMapper;

	@Autowired
	AnotherMapper anotherMapper;

	@RequestMapping("/test_mappers")
	public Map<String, String> testMappers() {
		Map<String, String> result = new HashMap<>();
		result.put("Mapper", "Database version");
		result.put("oneMapper", oneMapper.getVersion());
		result.put("anotherMapper", anotherMapper.getVersion());
		return result;
	}

}
