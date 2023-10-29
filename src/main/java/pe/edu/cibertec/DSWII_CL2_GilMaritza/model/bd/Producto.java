package pe.edu.cibertec.DSWII_CL2_GilMaritza.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "producto")
    private String producto;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "fechavencimiento")
    private Date fechavencimiento;


}
