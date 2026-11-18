package ProyectoAlumnos_com.example.Proyecto.Controller;

import ProyectoAlumnos_com.example.Proyecto.Entity.Producto;
import ProyectoAlumnos_com.example.Proyecto.Service.ServiceProducto;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class ProductoController {


private final ServiceProducto serviceProducto;

    public ProductoController(ServiceProducto serviceProducto) {
        this.serviceProducto = serviceProducto;
    }

    @GetMapping("/productos")
    public List<Producto> getMappingProductos(){

        return serviceProducto.listarProductos();


    }

    @GetMapping("{id}")
    public ResponseEntity<?> getProductosId(@PathVariable Integer id){



        return  ResponseEntity.ok(serviceProducto.buscarProductoPorid(id));

    }

    //agregar un producto
    @PostMapping("/anadirProducto")
    public ResponseEntity<?> postProducto(@RequestBody Producto producto) {

        Producto productoPost =
                serviceProducto.anadirProducto(producto);

        return ResponseEntity.status(HttpStatus.CREATED).body(productoPost);

    }

    //put modifica los elementos del array
    @PutMapping("{id}")
    public ResponseEntity<?> putProductos(@RequestBody Producto producto , @PathVariable Integer id) {



          return ResponseEntity.ok(serviceProducto.modificarproducto(producto,id));
       // return ResponseEntity.notFound().build();

    }
    //expetacular

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProductos(@PathVariable Integer id) {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(serviceProducto.eliminarProducto(id));


     //   return new ResponseEntity<>("Elemento eliminado", HttpStatus.OK);

    }

         @GetMapping(value = "/imprimir-texto", produces = MediaType.TEXT_PLAIN_VALUE)
        public ResponseEntity<String> imprimirTexto() {
            String texto = "Hola mundo";
            return ResponseEntity.ok(texto);


        }


        @GetMapping(value = "/sumar")
        public ResponseEntity<Long> sumar() {
            long numero1 = 10;
            long numero2 = 30;

            long resultado = numero1 + numero2;

            return ResponseEntity.ok(resultado);


        }


        @GetMapping(value = "/restar")
        public ResponseEntity<Long> restar() {
            long numero1 = 20;
            long numero2 = 40;
            long resultado = numero1 - numero2;
            return ResponseEntity.ok(resultado);

        }

    }