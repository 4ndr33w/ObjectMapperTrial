package trials.itk.mapper.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import trials.itk.mapper.controller.CustomerController;
import trials.itk.mapper.service.CustomerService;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
public class CustomerControllerImpl implements CustomerController {
	
	private final CustomerService customerService;
	@Override
	public ResponseEntity<String> createCustomerGet(String customer) {
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customer));
	}
	
	@Override
	public ResponseEntity<String> createCustomerPost(String customer) {
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customer));
	}
	
	@Override
	public ResponseEntity<String> getCustomer(String id) {
		return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomer(id));
	}
}