
package com.prizy.pricer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

	@RequestMapping("/")
	public String getHome() {
		return "Welcome!! \n Refer readme.md file, to use application";
	}
}
