package pe.edu.cibertec.DSWII_CL2_GilMaritza.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_CL2_GilMaritza.model.bd.Producto;
import pe.edu.cibertec.DSWII_CL2_GilMaritza.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoService {
    private ProductoRepository productoRepository;

    public List<Producto> listarProducto(){

        return productoRepository.findAll();
    }
    public Producto guardar(Producto producto){

        return productoRepository.save(producto);
    }
    public Optional<Producto> obtenerProductoPorId(Integer id){
        Optional<Producto> producto = productoRepository.findById(id);
        if(producto.isEmpty()){
            return Optional.empty();
        }else
            return producto;
    }

    public void eliminarProducto(Integer id){
        productoRepository.deleteById(id);
    }

    public List<Producto> buscarProductoPorNombre(String producto){
        return productoRepository.findByProductoname(producto);
    }

    public List<Producto> buscarProductosEntre10Y100(){
        return productoRepository.findProductoEntre10y100();
    }

    public List<Producto> buscarProductoPorAnio2024(Integer anio){
        return productoRepository.findProductoByYear2024(anio);
    }
}
