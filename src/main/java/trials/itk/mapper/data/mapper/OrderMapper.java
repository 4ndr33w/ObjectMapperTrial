package trials.itk.mapper.data.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import trials.itk.mapper.data.dto.request.OrderRequestDto;
import trials.itk.mapper.data.dto.response.OrderResponseDto;
import trials.itk.mapper.data.entity.Customer;
import trials.itk.mapper.data.entity.Order;
import trials.itk.mapper.data.entity.Product;
import trials.itk.mapper.data.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

/**
*
* @version 1.0
* @author 4ndr33w
*/
@Component
public class OrderMapper {
	
	public Order mapToEntity(
			@NonNull OrderRequestDto requestDto,
			@NonNull List<Product> products,
			@NonNull Customer customer) {
		BigDecimal totalPrice = products.stream()
				.map(Product::getPrice)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		
		return Order.builder()
				.customer(customer)
				.products(products)
				.orderDate(ZonedDateTime.parse(requestDto.orderDate()))
				.shippingAddress(requestDto.shippingAddress())
				.totalPrice(totalPrice)
				.orderStatus(OrderStatus.valueOf(requestDto.orderStatus()))
				.build();
	}
	
	public OrderResponseDto mapToOrderResponseDto(@NonNull Order source) {
		List<UUID> productIds = source.getProducts().stream()
				.map(Product ::getId)
				.toList();
		
		return new OrderResponseDto(
				source.getId(),
				source.getCustomer().getId(),
				productIds,
				source.getOrderDate().toString(),
				source.getShippingAddress(),
				source.getTotalPrice().toString(),
				source.getOrderStatus().toString()
		);
	}
}