package org.opendevup.web;

import org.opendevup.dio.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EtudiantController {
	@Autowired
	EtudiantRepository etudiantRepository;
	@RequestMapping(value="/Index")
	public String Index() {
		return "etudiants";
	}
}
