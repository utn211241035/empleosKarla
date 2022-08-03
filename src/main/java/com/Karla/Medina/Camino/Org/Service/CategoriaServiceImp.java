package com.Karla.Medina.Camino.Org.Service;


//import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Karla.Medina.Camino.Org.Model.Categoria;
import com.Karla.Medina.Camino.Org.Repositorio.CategoriasRepository;

@Service
@Primary
public class CategoriaServiceImp implements IntCategorias {
	
	@Autowired
	private CategoriasRepository repoCategorias;
	
	//private List<Categoria> lista = null;
	/*
	public CategoriaServiceImp() {

		
		lista = new LinkedList<Categoria>();
		
		Categoria cs = new  Categoria();
		cs.setId(1);
		cs.setNombre("TICS");
		cs.setDescripcion("Relaionado con Infomratica,telecomunicacion,iot");
		
		Categoria cs1 = new  Categoria();
		cs1.setId(2);
		cs1.setNombre("Seguridad");
		cs1.setDescripcion("Relaionado con la proteccion");
		
		Categoria cs2 = new  Categoria();
		cs2.setId(3);
		cs2.setNombre("Automotriz");
		cs2.setDescripcion("Relaionado con diseño de autos,mecanica,etc");
		
		lista.add(cs);
		lista.add(cs1);
		lista.add(cs2);
	}*/
	
	@Override
	public List<Categoria> ObtenerTodas() {
		return (List<Categoria>) repoCategorias.findAll();
	}

	@Override
	public void agregar(Categoria categoria) {
		repoCategorias.save(categoria);

	}
	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		Optional<Categoria> optional= repoCategorias.findById(idCategoria);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	@Override
	public void eliminar(Integer idCtargoria) {
		 repoCategorias.deleteById(idCtargoria);

	}

	@Override
	public int totaCategorias() {
		return (int) repoCategorias.count();
	}
	
	@Override
	public Page<Categoria> buscarTodas(Pageable page) {
		return  repoCategorias.findAll(page);
		//return repoCategorias.findAll(page);
	}
	/*
	@Override
	public int ids() {
		int id=0;
		for(Categoria cat:lista) {
			id = cat.getId();
		}
		return id;
	}
	
	@Override
	public void modificar(int posicion, Categoria cat) {
		lista.set(posicion, cat);
		
	}
	
	public int buscarPosicion(Categoria categoria) {
		int index = 0; Categoria aux = null;
		int posicion = -1;
		while(index < lista.size()) {
			aux = lista.get(index);
			if(aux.getId()==categoria.getId()) {
				posicion= index;
				break;
		} index++;
		
	} return posicion;
}
*/
	public int buscarPosicion(Categoria categoria) {
		return 0;
		
	}

	@Override
	public int ids() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modificar(int posicion, Categoria cat) {
		// TODO Auto-generated method stub
		
	}

}
