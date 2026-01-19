package trials.itk.mapper.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@RequestMapping("/api/v1/orders")
public interface OrderController {
	
	@GetMapping("/create/{order}")
	ResponseEntity<String> createOrderGet(@PathVariable String order);
	
	@PostMapping
	ResponseEntity<String> createOrderPost(@RequestBody String order);
	
	@GetMapping("/{orderId}")
	ResponseEntity<String> getOrderById(@PathVariable String orderId);
}