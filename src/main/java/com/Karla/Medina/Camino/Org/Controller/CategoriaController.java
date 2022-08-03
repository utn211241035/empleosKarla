package com.Karla.Medina.Camino.Org.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Karla.Medina.Camino.Org.Model.Categoria;
import com.Karla.Medina.Camino.Org.Service.IntCategorias;

@RequestMapping("/categoria")
@Controller
public class CategoriaController{
	
		@Autowired
		private IntCategorias CategoriaService;
		
		//@GetMapping("/index")
		@GetMapping("/indexPaginado")
		public String mostrarIndex(Model model,Pageable page){
			//List<Categoria> lista = CategoriaService.ObtenerTodas();
			Page<Categoria> lista = CategoriaService.buscarTodas(page);
			System.out.println(lista);
			model.addAttribute("categorias",lista);
			return "categorias/listCategorias";
		}
		/*
		@PostMapping("/modificar")
		public String nuevaCataegoria(@RequestParam("id") int id,@RequestParam("nombre") String nombre,@RequestParam("descripcion") String decripcion) {
			Categoria c = new Categoria();
			c.setId(id);
			c.setNombre(nombre);
			c.setDescripcion(decripcion);
			CategoriaService.modificar(id, c);
			return "redirect:/categoria/index";
		}*/
		@PostMapping("/guardar")
		public String guardar(
				@Valid
				Categoria categoria, 
				BindingResult result,
				RedirectAttributes model) {
			if(result.hasErrors()) {
				System.out.println("Error");
				return "categorias/formCategoria";
			}else {/*
			//System.out.println(categoria);
			if ( categoria.getId() == null) {
				int index = CategoriaService.ObtenerTodas().size()-1;
				Categoria aux = CategoriaService.ObtenerTodas().get(index);
				categoria.setId(aux.getId()+1);
				model.addFlashAttribute("msg", "Se guardo la categoria");
				CategoriaService.agregar(categoria);
			}else {
				/*int posicion = CategoriaService.buscarPosicion(categoria);
				//System.out.println(posicion);
				model.addFlashAttribute("msg", "Se modifico³ la categoria");
				CategoriaService.modificar(posicion, categoria);
			}
		/*	categoria.setId(categoriaService.obtenerTodas().size()+1);
			System.out.println(categoria);
			categoriaService.agregar(categoria);*/
			model.addFlashAttribute("msg", "Se modifico³ la categoria");
			CategoriaService.agregar(categoria);
			
			return "redirect:/categoria/indexPaginado";
		}
		}
		@GetMapping("/eliminar")
		public String eliminar(@RequestParam("id")int idCategoria) {
			CategoriaService.eliminar(idCategoria);
			return "redirect:/categoria/indexPaginado";
		}
		/*
		@GetMapping("/editar")
		public String editar(@RequestParam("id") int idCategoria , Model model) {
			Categoria categoria = CategoriaService.buscarPorId(idCategoria);
			model.addAttribute(categoria);
			return "categorias/formCategoria";
		}
		*/
		@GetMapping("/consultar")
		public String consultar(@RequestParam("id")int idCategoria,Model model) {
			Categoria categoria = CategoriaService.buscarPorId(idCategoria);
			model.addAttribute("categoria",categoria);
			return "categorias/formCategoria";
		}
		@GetMapping("/crear")
		public String nuevaCategoria(Categoria c) {
			return "categorias/formCategoria";
		}
}
