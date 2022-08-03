package com.Karla.Medina.Camino.Org.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Karla.Medina.Camino.Org.Model.Categoria;
import com.Karla.Medina.Camino.Org.Model.Vacante;
import com.Karla.Medina.Camino.Org.Repositorio.VacantesRepository;

@Service
@Primary
public class VacantesServceImp implements IntVacantes {
	
	@Autowired
	public VacantesRepository repoVacantes;
/*	
	private List<Vacante> lista;
	private List<Categoria> cat;	
	public VacantesServceImp() {
		lista = new LinkedList<Vacante>();
		DateTimeFormatter formato= DateTimeFormatter.ofPattern("dd/mm/yy");
		
		try {
			Vacante v = new Vacante();
			v.setId(1);
			v.setNombre("Desarrollador Web");
			v.setDescripcion("Desarrollo de apps mediante lenguajes de programacion");
			v.setFecha(LocalDate.of(1998, 02, 05));
			v.setSalario(5000.00);
			v.setDestacado(1);
			v.setImagen("logo1.png");
			v.setDetalles("<h2>Ofrecemos</h2>"+"<ul><li>Salario Atractvo</li>"+"<li>Oportunidad de desarrollo</li></ul>");
			
			Categoria cate = new Categoria();
			cate.setId(1);
			cate.setNombre("TICS");
			cate.setDescripcion("Relaionado con Infomratica,telecomunicacion,iot");
			
			v.setCategoria(cate);
			
			Vacante v1 = new Vacante();
			v1.setId(2);
			v1.setNombre(" Web Desarrollador");
			v1.setDescripcion("Desarrollo de apps mediante lenguajes de programacion");
			v1.setFecha(LocalDate.of(1998, 02, 05));
			v1.setSalario(5000.00);
			v1.setDestacado(0);
			v1.setImagen("logo8.png");
			v1.setDetalles("<h2>Ofrecemos</h2>"+"<ul><li>Salario Atractvo</li>"+"<li>Oportunidad de desarrollo</li></ul>");
			
			Categoria cate1 = new Categoria();
			cate1.setId(2);
			cate1.setNombre("TICS");
			cate1.setDescripcion("Relaionado con Infomratica,telecomunicacion,iot");
			
			v1.setCategoria(cate1);
			Vacante v2 = new Vacante();
			v2.setId(3);
			v2.setNombre(" Seguridad");
			v2.setDescripcion(" Relaionado con la proteccion");
			v2.setFecha(LocalDate.of(1998, 02, 05));
			v2.setSalario(5000.00);
			v2.setDestacado(1);
			v2.setImagen("logo7.png");
			v2.setDetalles("<h2>Ofrecemos</h2>"+"<ul><li>Salario Atractvo</li>"+"<li>Oportunidad de desarrollo</li></ul>");
			
			Categoria cate3 = new Categoria();
			cate3.setId(3);
			cate3.setNombre("Automotriz");
			cate3.setDescripcion("Relaionado con diseño de autos,mecanica,etc");
			
			v2.setCategoria(cate3);
			
			lista.add(v);
			lista.add(v1);
			lista.add(v2);
		}catch(DateTimeParseException ex) {
			System.out.println("Error: "+ ex.getMessage());
		}

	}
	*/
	@Override
	public List<Vacante> obtenerTodas() {
		return (List<Vacante>) repoVacantes.findAll();
	}

	@Override
	public void guardar(Vacante vaca) {
		repoVacantes.save(vaca);
		
	}

	@Override
	public void eliminar(Integer idVacante) {
		repoVacantes.deleteById(idVacante);
		
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		Optional<Vacante> optional= repoVacantes.findById(idVacante);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@Override
	public int numVacantes() {
		return (int) repoVacantes.count();
	}
	/*
	@Override
	public void modificar(int posicion, Vacante v) {
		lista.set(posicion, v);
		
	}
	
	@Override
	public int buscarPosicion(Vacante v) {
		int index = 0; Vacante aux = null;
		int posicion = -1;
		while(index < lista.size()) {
			aux = lista.get(index);
			if(aux.getId()==v.getId()) {
				posicion= index;
				break;
		} index++;
		
	} return posicion;
}*/

	@Override
	public Page<Vacante> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return repoVacantes.findAll(page);
	}

}
