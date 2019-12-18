package com.cifo.pla9_actividad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/")
	/* @GetMapping es una anotaci�n "compuesta" que equivale a @RequestMapping(method = RequestMethod.GET)
	 * Adem�s, la primera es a nivel de m�todo, y la segunda a nivel de clase, como se puede ver */
	public String inicioAdmin() {
		/*p�gina inicio con un enlace a su secci�n*/
		return "index-admin";
	}
}
