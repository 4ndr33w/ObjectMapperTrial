package trials.itk.mapper.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trials.itk.mapper.data.dto.request.OrderRequestDto;
import trials.itk.mapper.data.entity.Customer;
import trials.itk.mapper.data.entity.Order;
import trials.itk.mapper.data.entity.Product;
import trials.itk.mapper.data.mapper.GenericMapper;
import trials.itk.mapper.data.mapper.OrderMapper;
import trials.itk.mapper.data.repository.OrderRepository;
import trials.itk.mapper.data.repository.ProductRepository;
import trials.itk.mapper.exception.OrderNotFoundException;
import trials.itk.mapper.service.CustomerService;
import trials.itk.mapper.service.OrderService;

import java.util.List;
import java.util.UUID;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
	
	private final OrderRepository orderRepository;
	private final ProductRepository productRepository;
	private final CustomerService customerService;
	private final GenericMapper genericMapper;
	private final OrderMapper orderMapper;
	
	@Override
	@Transactional
	public String createOrder(@NonNull String request) {
		OrderRequestDto requestDto = genericMapper.deserialize(request, OrderRequestDto.class);
		String customerString = customerService.getCustomer(requestDto.customerId().toString());
		Customer customer = genericMapper.deserialize(customerString, Customer.class);
		List<Product> products = productRepository.findAllById(requestDto.productIds());
		
		Order order = orderMapper.mapToEntity(requestDto, products, customer);
		Order savedOrder = orderRepository.save(order);
		
		return genericMapper.serialize(savedOrder);
	}
	
	@Override
	public String getOrderById(@NonNull String orderId) {
		UUID id = UUID.fromString(orderId);
		Order existingOrder = orderRepository.findById(id)
				.orElseThrow(() -> new OrderNotFoundException("Order not found"));
		
		return genericMapper.serialize(existingOrder);
	}
}