package trials.itk.mapper.service;

/**
 * @author 4ndr33w
 * @version 1.0
 */
public interface ProductService {
	
	String createProduct(String request);
	String getAllProducts();
	String getProductById(String productId);
	String updateProduct(String productId, String request);
	void deleteProduct(String productId);
}