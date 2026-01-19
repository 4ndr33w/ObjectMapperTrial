package trials.itk.mapper.data.dto.request;

import java.util.List;
import java.util.UUID;

/**
 * @author 4ndr33w
 * @version 1.0
 */
public record OrderRequestDto(
		UUID customerId,
		List<UUID> productIds,
		String orderDate,
		String shippingAddress,
		String orderStatus
) {
}