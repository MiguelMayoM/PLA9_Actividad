package com.cifo.pla9_actividad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/editor")
public class EditorController {

	@GetMapping("/")
	public String inicioEditor() {
		/*página inicio con un enlace a su sección*/
		return "index-editor";
	}
}
