package trials.itk.mapper.data.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@Getter
@RequiredArgsConstructor
public enum OrderStatus {
	
	CREATED("Created"),
	CANCELED("Canceled"),
	IN_PROGRESS("In progress"),
	SHIPPED("Shipped"),
	DELIVERED("Delivered");
	
	private final String value;
}