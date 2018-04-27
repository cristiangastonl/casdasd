package com.garbarino.productos.controller;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garbarino.productos.entity.Product;
import com.garbarino.productos.service.ProductService;
import com.garbarino.productos.vo.GenericResponse;


/**
 * @author Gaston
 *
 */
@RestController
@RequestMapping("/productos")
public class ProductController {
	private final ProductService productService;

	public ProductController(final ProductService productService) {
		this.productService = productService;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponse<Iterable<Product>>> findAll() {
		return ResponseEntity.ok(new GenericResponse<>(productService.findAll()));
	}

	@GetMapping(value = "/{product_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponse<Product>> get(@PathVariable("product_id") String productId) {
		return ResponseEntity.ok(new GenericResponse<>(productService.get(productId)));
	}

	@DeleteMapping(value = "/{product_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponse<String>> delete(@PathVariable("product_id") String productId) {
		productService.delete(productId);
		return ResponseEntity.ok(new GenericResponse<>(productId));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponse<Product>> create(@RequestBody Product product) {
		Product savedProduct = productService.save(product);
		return ResponseEntity.created(URI.create("/" + product.getId())).body(new GenericResponse<>(savedProduct));
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody Product product) {
		productService.update(product);
		return ResponseEntity.noContent().build();
	}

//	@GetMapping(value = "/{product_id}/ratings", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<GenericResponse<Iterable<Rating>>> getRatings(@PathVariable("product_id") String productId) {
//		return ResponseEntity.ok(new GenericResponse<>(ratingService.getRatingsByProductId(productId)));
//	}
//
//	@GetMapping(value = "/{product_id}/ratings/{rating_id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<GenericResponse<Rating>> getRating(@PathVariable("product_id") String productId,
//			@PathVariable("rating_id") Long ratingId) {
//		return ResponseEntity.ok(new GenericResponse<>(ratingService.get(ratingId)));
//	}
//
//	@PostMapping(value = "/{product_id}/ratings", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<GenericResponse<Rating>> saveRating(@PathVariable("product_id") String productId,
//			@RequestBody Rating rating) {
//		if (!productId.equals(rating.getProductId()))
//			throw new RuntimeException("Ids doesn't match");
//		
//		Rating savedRating = ratingService.save(rating);
//		return ResponseEntity
//				.created(URI.create("/" + savedRating.getProductId() + "/ratings/" + savedRating.getRatingId()))
//				.body(new GenericResponse<>(savedRating));
//	}
//
//	@PutMapping(value = "/{product_id}/ratings/{rating_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<?> updateRating(@PathVariable("product_id") String productId,
//			@PathVariable("rating_id") Long ratingId, @RequestBody Rating rating) {
//		ratingService.update(rating);
//		return ResponseEntity.noContent().build();
//	}
//
//	@DeleteMapping(value = "/{product_id}/ratings/{rating_id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<GenericResponse<Long>> deleteRating(@PathVariable("product_id") String productId,
//			@PathVariable("rating_id") Long ratingId) {
//		ratingService.delete(ratingId);
//		return ResponseEntity.ok(new GenericResponse<>(ratingId));
//	}

}
