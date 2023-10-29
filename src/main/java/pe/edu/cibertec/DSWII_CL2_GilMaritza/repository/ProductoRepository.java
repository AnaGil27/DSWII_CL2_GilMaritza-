package pe.edu.cibertec.DSWII_CL2_GilMaritza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_CL2_GilMaritza.model.bd.Producto;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    Optional<Producto> findByProductoname(String categoryName);

    List<Producto> findByProductonameContainingIgnoreCase(String filtro);

    @Query("SELECT p FROM producto p WHERE c.producto LIKE %:filtro%")
    List<Producto> filtrarProductoPorNombre(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM producto WHERE productoname LIKE %:filtro%",
            nativeQuery = true)
    List<Producto> filtrarProductoPorNombreSQL(@Param("filtro") String filtro);
}
