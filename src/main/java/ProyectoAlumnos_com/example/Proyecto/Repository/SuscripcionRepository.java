package ProyectoAlumnos_com.example.Proyecto.Repository;

import ProyectoAlumnos_com.example.Proyecto.Entity.Suscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuscripcionRepository extends JpaRepository<Suscripcion,Long> {

    boolean existsByEmailIgnoreCase(String email);


}
