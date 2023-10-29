package pe.edu.cibertec.DSWII_CL2_GilMaritza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_CL2_GilMaritza.model.bd.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
