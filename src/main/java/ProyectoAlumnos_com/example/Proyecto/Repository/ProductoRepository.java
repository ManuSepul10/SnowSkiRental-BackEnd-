package ProyectoAlumnos_com.example.Proyecto.Repository;

import ProyectoAlumnos_com.example.Proyecto.Entity.Producto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.mapping.JpaPersistentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {

/*
Método	Para qué sirve
findAll()	Recuperar todos los productos.
findById(id)	Buscar un producto por su identificador.
save(producto)	Guardar un producto nuevo o actualizar uno existente.
deleteById(id)	Eliminar un producto por su identificador.
existsById(id)	Comprobar si existe ese identificador.
 */

   // public List<Producto> findAll();

}
