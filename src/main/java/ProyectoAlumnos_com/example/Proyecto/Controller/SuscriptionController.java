package ProyectoAlumnos_com.example.Proyecto.Controller;

import ProyectoAlumnos_com.example.Proyecto.Service.EmailService;
import ProyectoAlumnos_com.example.Proyecto.dto.SuscripcionRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/suscripciones")
public class SuscriptionController {
    //realizar peticion con spting segurity
    private final EmailService emailService;

    public SuscriptionController(EmailService emailService) {
        this.emailService = emailService;

    }

    @PostMapping("/prueba-email")
    public ResponseEntity<String> enviarPrueba(
            @RequestParam String destino) {

        emailService.enviarCorreoPrueba(destino);

        return ResponseEntity.ok("Correo enviado correctamente");
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProductos(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(emailService.eliminarSuscripcion(id));




    }



    @PostMapping
    public ResponseEntity<Map<String, String>> registrar(
            //Activa las validaciones del codigo
            @Valid @RequestBody SuscripcionRequest request) {

        emailService.registrarSuscripcion(request.email());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of(
                        "mensaje", "Suscripción registrada correctamente"
                ));
    }

}
