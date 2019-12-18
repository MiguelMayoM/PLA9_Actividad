package com.cifo.pla9_actividad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/")
	/* @GetMapping es una anotación "compuesta" que equivale a @RequestMapping(method = RequestMethod.GET)
	 * Además, la primera es a nivel de método, y la segunda a nivel de clase, como se puede ver */
	public String inicioAdmin() {
		/*página inicio con un enlace a su sección*/
		return "index-admin";
	}
}
