package ProyectoAlumnos_com.example.Proyecto.Service;

import ProyectoAlumnos_com.example.Proyecto.Entity.Producto;
import ProyectoAlumnos_com.example.Proyecto.Repository.ProductoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
public class ServiceProducto {



    public ServiceProducto(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
        }
    private final ProductoRepository productoRepository;



    public List<Producto> listarProductos() {

        return productoRepository.findAll();

    }

    public Optional<Producto> buscarProductoPorid( Integer id){

        return productoRepository.findById(id);

    }
      /*
        for (Producto p : productos){
            if(Objects.equals(p.getId(),id)){
                return Optional.of(p);
            }

        }
        return Optional.empty();

    }
*/
    //Metodo post desde service
    public Producto anadirProducto(Producto producto) {

        return productoRepository.save(producto);
    }

    public  Optional<Producto> modificarproducto(Producto producto , Integer id) {

    Optional<Producto> idModificar =productoRepository.findById(id);
            if (idModificar.isPresent()){
                Producto productoExistente = idModificar.get();
                productoExistente.setNombre(producto.getNombre());
                productoExistente.setPrecio(producto.getPrecio());
                productoExistente.setTipo(producto.getTipo());
                productoExistente.setImage(producto.getImage());

                return Optional.of(
                        productoRepository.save(productoExistente)

                );
            }
            return Optional.empty();


    }


   public Optional<Producto> eliminarProducto(Integer id){
      Optional<Producto> EliminarProducto  = productoRepository.findById(id);

      if(EliminarProducto.isPresent()){
        productoRepository.deleteById(id);


      }
       return Optional.empty();
      }

    }


