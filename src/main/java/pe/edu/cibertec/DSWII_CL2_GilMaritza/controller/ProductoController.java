package pe.edu.cibertec.DSWII_CL2_GilMaritza.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DSWII_CL2_GilMaritza.exception.ResourceNotFoundException;
import pe.edu.cibertec.DSWII_CL2_GilMaritza.model.bd.Producto;
import pe.edu.cibertec.DSWII_CL2_GilMaritza.service.ProductoService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/producto")
public class ProductoController {
    private ProductoService productoService;

    @GetMapping("")
    public ResponseEntity<List<Producto>> listarProducto(){
        List<Producto> productoList = new ArrayList<>();
        productoService.listarProducto()
                .forEach(productoList::add);
        if(productoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProducto(
            @PathVariable("id") Integer id){
        Producto producto = productoService
                .obtenerProductoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El producto con el Id Nro. "+
                        id + " no existe."));

        return new ResponseEntity<>(producto, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Producto> registrarProducto(
            @RequestBody Producto producto
    ){
        return new ResponseEntity<>(
                productoService.guardar(producto), HttpStatus.CREATED
        );
    }

    @GetMapping("/productoname/{filtro}")
    public ResponseEntity<List<Producto>> filtrarProductoPorNombre(
            @PathVariable("filtro") String filtro
    ){
        List<Producto> productoList = new ArrayList<>();
        productoService.obtenerProductoPorFiltro(filtro)
                .forEach(productoList::add);
        if(productoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productoList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable("id") Integer id,
            @RequestBody Producto producto
    ){
        Producto oldProducto = productoService
                .obtenerProductoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El producto con el Id Nro. "+
                        id + " no existe."));
        oldProducto.setProducto(producto.getProducto());
        oldProducto.setDescripcion(producto.getProducto());
        oldProducto.setCantidad(producto.getCantidad());
        oldProducto.setFechavencimiento(producto.getFechavencimiento());
        return new ResponseEntity<>(
                productoService.guardar(oldProducto), HttpStatus.OK
        );
    }

}
