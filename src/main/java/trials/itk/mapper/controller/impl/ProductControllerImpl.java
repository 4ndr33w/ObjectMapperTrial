package trials.itk.mapper.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import trials.itk.mapper.controller.ProductController;
import trials.itk.mapper.service.ProductService;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {
	
	private final ProductService productService;
	
	@Override
	public ResponseEntity<String> createProductGet(String product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
	}
	
	@Override
	public ResponseEntity<String> createProductPost(String product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
	}
	
	@Override
	public ResponseEntity<String> getAllProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
	}
	
	@Override
	public ResponseEntity<String> getProductById(String productId) {
		return ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(productId));
	}
	
	@Override
	public ResponseEntity<String> updateProduct(String productId, String product) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.updateProduct(productId, product));
	}
	
	@Override
	public ResponseEntity<Void> deleteProduct(String productId) {
		productService.deleteProduct(productId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}