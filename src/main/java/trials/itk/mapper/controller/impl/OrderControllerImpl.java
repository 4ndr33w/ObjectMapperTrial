package trials.itk.mapper.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import trials.itk.mapper.controller.OrderController;
import trials.itk.mapper.service.OrderService;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
public class OrderControllerImpl implements OrderController {
	
	private final OrderService orderService;
	@Override
	public ResponseEntity<String> createOrderGet(String order) {
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(order));
	}
	
	@Override
	public ResponseEntity<String> createOrderPost(String order) {
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(order));
	}
	
	@Override
	public ResponseEntity<String> getOrderById(String orderId) {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderById(orderId)) ;
	}
}