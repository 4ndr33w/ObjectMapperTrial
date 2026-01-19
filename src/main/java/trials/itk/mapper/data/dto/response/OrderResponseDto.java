package trials.itk.mapper.data.dto.response;

import java.util.List;
import java.util.UUID;

/**
 * @author 4ndr33w
 * @version 1.0
 */
public record OrderResponseDto(
		UUID id,
		UUID customerId,
		List<UUID> productIds,
		String orderDate,
		String shippingAddress,
		String totalPrice,
		String orderStatus
) {
}