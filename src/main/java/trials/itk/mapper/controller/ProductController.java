package trials.itk.mapper.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@RequestMapping("/api/v1/products")
public interface ProductController {
	
	@GetMapping("/create/{product}")
	ResponseEntity<String> createProductGet(@PathVariable String product);
	
	@PostMapping
	ResponseEntity<String> createProductPost(@RequestBody String product);
	
	@GetMapping
	ResponseEntity<String> getAllProducts();
	
	@GetMapping("/{productId}")
	ResponseEntity<String> getProductById(@PathVariable String productId);
	
	@PutMapping("/{productId}")
	ResponseEntity<String> updateProduct(@PathVariable String productId, @RequestBody String product);
	
	@DeleteMapping("/{productId}")
	ResponseEntity<Void> deleteProduct(@PathVariable String productId);
}