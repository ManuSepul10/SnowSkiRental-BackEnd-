package ProyectoAlumnos_com.example.Proyecto.Service;
import ProyectoAlumnos_com.example.Proyecto.Entity.Suscripcion;
import ProyectoAlumnos_com.example.Proyecto.Repository.SuscripcionRepository;
import ProyectoAlumnos_com.example.Proyecto.exeption.SuscripcionDuplicadaException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;


@Service
public class EmailService {

    private final SuscripcionRepository suscripcionRepository;
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String remitentes;

    public EmailService(
            JavaMailSender mailSender,
            SuscripcionRepository suscripcionRepository) {

        this.mailSender = mailSender;
        this.suscripcionRepository = suscripcionRepository;
    }

    // Envío de correo de bienvenida
    public void enviarCorreoPrueba(String destinatario) {

        SimpleMailMessage mensaje = new SimpleMailMessage();

        mensaje.setFrom(remitentes);
        mensaje.setTo(destinatario);
        mensaje.setSubject("¡Bienvenido a Snow Ski Rental!");

        mensaje.setText(
                "¡Hola! Bienvenido a SNOW-SKI.\n\n" +
                        "Nos encanta tenerte aquí.\n" +
                        "Pronto vas a recibir nuestras promociones.\n\n" +
                        "¡Tenés un 15% de descuento en tu próxima compra" +
                        "por suscribirte!\n\n" +
                        "Gracias por confiar en nosotros.\n" +
                        "Snow Ski Rental"
        );

        mailSender.send(mensaje);
    }

     public Optional<Suscripcion> eliminarSuscripcion(Long id){
         Optional<Suscripcion> suscripcion =
                 suscripcionRepository.findById(id);

         suscripcion.ifPresent(suscripcionRepository::delete);

         return suscripcion;
     }


    // Registrar una suscripción
    @Transactional
    public Suscripcion registrarSuscripcion(String email) {

        String emailNormalizado = email.trim().toLowerCase();

        if (suscripcionRepository.existsByEmailIgnoreCase(emailNormalizado)) {
            throw new SuscripcionDuplicadaException(
                    "Este correo ya está registrado"
            );
        }

        Suscripcion nuevaSuscripcion =
                new Suscripcion(emailNormalizado);

        try {
            Suscripcion suscripcionGuardada =
                    suscripcionRepository.saveAndFlush(nuevaSuscripcion);

            // Enviar correo después de guardar
            enviarCorreoPrueba(suscripcionGuardada.getEmail());

            return suscripcionGuardada;

        } catch (DataIntegrityViolationException exception) {

            throw new SuscripcionDuplicadaException(
                    "Este correo ya está registrado"
            );
        }
    }


}
