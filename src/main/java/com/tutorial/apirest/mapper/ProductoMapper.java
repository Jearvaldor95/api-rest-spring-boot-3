package com.tutorial.apirest.mapper;

import com.tutorial.apirest.dto.ProductoDto;
import com.tutorial.apirest.model.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    Producto toProducto(ProductoDto productoDto);

    ProductoDto toProductoDto(Producto producto);

    List<ProductoDto> toProductoDtos(List<Producto> productos);


    void updateProducto(@MappingTarget Producto producto, Producto productoDto);
}
