package com.ciberfarma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ciberfarma.model.Usuario;
import com.ciberfarma.repository.IUsuarioRepository;

@Controller
public class ProyectoController {
	// Controlador para "Cerrar Session"
	@GetMapping("/logout")
	public String login(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}

	@Autowired
	private IUsuarioRepository repoUsu;

	// Controlador para leer los datos del Formulario
	@PostMapping("/login")
	public String acceso(@ModelAttribute Usuario usuario, Model model) {
		System.out.print(usuario);
		// valida con la bd --> obtener segun lo
		Usuario u = repoUsu.findByCorreoAndClave(usuario.getCorreo(), usuario.getClave());
		System.out.print(u);
		if (u != null) {
			return "principal";
		} else {
			model.addAttribute("mensaje","Usuario o clave Incorrecto");
			model.addAttribute("mensaje","alert alert-danger");
		}
		return "login";
	}
}
