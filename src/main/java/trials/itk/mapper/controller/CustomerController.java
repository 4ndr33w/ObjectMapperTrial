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
@RequestMapping("/api/v1/customers")
public interface CustomerController {
	
	@GetMapping("/create/{customer}")
	ResponseEntity<String> createCustomerGet(@PathVariable String customer);
	
	@PostMapping
	ResponseEntity<String> createCustomerPost(@RequestBody String customer);
	
	@GetMapping("/{id}")
	ResponseEntity<String> getCustomer(@PathVariable String id);
}