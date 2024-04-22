package com.tutorial.apirest.service;

import com.tutorial.apirest.exception.AppException;
import com.tutorial.apirest.dto.ProductoDto;
import com.tutorial.apirest.mapper.ProductoMapper;
import com.tutorial.apirest.model.Producto;
import com.tutorial.apirest.repository.ProductoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImple implements ProductoService{
    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    public ProductoServiceImple(ProductoRepository productoRepository, ProductoMapper productoMapper){
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }
    @Override
    public ProductoDto save(ProductoDto productoDto) {
        Boolean existeProducto = productoRepository.existsByNombre(productoDto.getNombre());

        if (!existeProducto){
            Producto producto = productoMapper.toProducto(productoDto);
            return productoMapper.toProductoDto(productoRepository.save(producto));

        }else {
            throw new AppException("El producto existe", HttpStatus.CONFLICT);
        }

    }

    @Override
    public List<ProductoDto> getProductos() {
        return productoMapper.toProductoDtos(productoRepository.findAll());
    }

    @Override
    public ProductoDto getProducto(Long productoId) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(()-> new AppException("Producto not found", HttpStatus.NOT_FOUND));

        return productoMapper.toProductoDto(producto);
    }

    @Override
    public List<ProductoDto> getProductosCategoria(String categoria) {
        List<Producto> productos = productoRepository.findByCategoria(categoria);
        if (!productos.isEmpty()){
            return productoMapper.toProductoDtos(productos);
        }else {
            throw new AppException("No hay productos con esa categoria", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ProductoDto update(Long productoId, ProductoDto productoDto) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(()-> new AppException("Producto not found", HttpStatus.NOT_FOUND));
        productoMapper.updateProducto(producto, productoMapper.toProducto(productoDto));
        return productoMapper.toProductoDto(productoRepository.save(producto));
    }

    @Override
    public ProductoDto delete(Long productoId) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(()-> new AppException("Producto not found", HttpStatus.NOT_FOUND));
        ProductoDto productoDto = productoMapper.toProductoDto(producto);
        productoRepository.deleteById(productoId);
        return productoDto;
    }
}
