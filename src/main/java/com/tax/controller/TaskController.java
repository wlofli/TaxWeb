package com.tax.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tax.service.SpiderTaskService;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
@RequestMapping("task")
@Controller
public class TaskController {
	
	@Resource
	private SpiderTaskService spiderTaskService;
	
	
	@RequestMapping(value={"task"},produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getTask(HttpServletRequest request){
		String result = new String();
		try {
			result = spiderTaskService.begin(request);
			spiderTaskService.updateTask(request, null);
		} catch (Exception e) {
			// TODO: handle exception
			spiderTaskService.updateTask(request, e.getMessage());
			result = "[err]"+e.getMessage();
		}
		return result;
	}

	
	
	
	
}
