package com.garbarino.productos.jpa;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garbarino.productos.entity.Product;


/**
 * @author Gaston
 *
 */
@Transactional
public interface ProductRepository extends JpaRepository<Product, String> {

}
