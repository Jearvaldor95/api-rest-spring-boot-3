package com.tutorial.apirest.service;

import com.tutorial.apirest.dto.ProductoDto;

import java.util.List;

public interface ProductoService {

    public ProductoDto save(ProductoDto productoDto);

    public List<ProductoDto> getProductos();

    public ProductoDto getProducto(Long productoId);

    public List<ProductoDto> getProductosCategoria(String categoria);

    public ProductoDto update(Long productoId, ProductoDto productoDto);

    public ProductoDto delete(Long productoId);
}
