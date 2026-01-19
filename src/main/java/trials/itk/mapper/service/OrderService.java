package trials.itk.mapper.service;

/**
 * @author 4ndr33w
 * @version 1.0
 */
public interface OrderService {
	
	String createOrder(String request);
	String getOrderById(String orderId);
}