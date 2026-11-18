package ProyectoAlumnos_com.example.Proyecto.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "suscripciones",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_suscripciones_email",
                        columnNames = "email"
                )
        }
)
public class Suscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String email;

    @Column(nullable = false)
    private LocalDateTime fechaRegistro;

    public Suscripcion() {
    }

    public Suscripcion(String email) {
        this.email = email;
        this.fechaRegistro = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

