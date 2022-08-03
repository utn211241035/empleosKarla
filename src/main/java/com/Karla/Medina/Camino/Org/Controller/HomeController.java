package com.Karla.Medina.Camino.Org.Controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Karla.Medina.Camino.Org.Model.Categoria;
import com.Karla.Medina.Camino.Org.Model.Perfil;
import com.Karla.Medina.Camino.Org.Model.Usuario;
import com.Karla.Medina.Camino.Org.Model.Vacante;
import com.Karla.Medina.Camino.Org.Service.IntCategorias;
import com.Karla.Medina.Camino.Org.Service.IntVacantes;
import com.Karla.Medina.Camino.Org.Service.intUsuarios;

@Controller
public class HomeController {
	
	@Autowired
	private IntVacantes VacantesServceImp;
	@Autowired
	private IntCategorias CategoriasServceImp;
	
	@Autowired
	private intUsuarios UsuariosServiceJpa;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		List<Vacante> lista = VacantesServceImp.obtenerTodas();
		List<Categoria> catego = CategoriasServceImp.ObtenerTodas();
		model.addAttribute("vacantes", lista);
		model.addAttribute("categorias", catego);
		return "home";
	}
	@GetMapping("/signup")
	public String registrarse(Usuario usuario) {
		return "formRegistro";
	}
	@GetMapping("/login" )
	public String mostrarLogin() {
			return "formLogin";
	}
	@PostMapping("/signup")
	public String guardarRegistro(Usuario usuario, RedirectAttributes attributes) {
		String pwdPlano = usuario.getPassword();
		String pwdEncriptado = passwordEncoder.encode(pwdPlano); 
		usuario.setPassword(pwdEncriptado);	
		usuario.setEstatus(1);
		usuario.setFechaRegistro(LocalDate.now());

		Perfil perfil = new Perfil();
		perfil.setId(3);
		usuario.agregar(perfil);
		UsuariosServiceJpa.guardar(usuario);		
		attributes.addFlashAttribute("msg", "Has sido registrado. ¡Ahora puedes ingresar al sistema!");	
		return "redirect:/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request){
			SecurityContextLogoutHandler logoutHandler =
						new SecurityContextLogoutHandler();
			logoutHandler.logout(request, null, null);
			return "redirect:/";
	}
	
	@GetMapping("/bcript/{texto}")
	@ResponseBody
	public String encriptar(@PathVariable("texto") String texto) {
		return texto + "encriptado en Bcrypt : "+ passwordEncoder.encode(texto);
	}


}
