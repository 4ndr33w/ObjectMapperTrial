package trials.itk.mapper.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trials.itk.mapper.data.entity.Product;
import trials.itk.mapper.data.mapper.GenericMapper;
import trials.itk.mapper.data.repository.ProductRepository;
import trials.itk.mapper.exception.ProductNotFoundException;
import trials.itk.mapper.service.ProductService;

import java.util.List;
import java.util.UUID;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;
	private final GenericMapper genericMapper;
	
	@Override
	@Transactional
	public String createProduct(@NonNull String request) {
		Product product = genericMapper.deserialize(request, Product.class);
		Product savedProduct = productRepository.save(product);
		
		return genericMapper.serialize(savedProduct);
	}
	
	@Override
	@Transactional(readOnly = true)
	public String getAllProducts() {
		List<Product> products = productRepository.findAll();
		
		return products.stream()
				.map(genericMapper :: serialize)
				.toList()
				.toString();
	}
	
	@Override
	@Transactional(readOnly = true)
	public String getProductById(@NonNull String productId) {
		UUID id = UUID.fromString(productId);
		Product existingProduct = getExistingProductOrElseThrow(id);
		
		return genericMapper.serialize(existingProduct);
	}
	
	@Override
	@Transactional
	public String updateProduct(@NonNull String productId, String request) {
		UUID id = UUID.fromString(productId);
		
		Product existingProduct = getExistingProductOrElseThrow(id);
		Product updatingData = genericMapper.deserialize(request, Product.class);
		Product updatedProduct = updateProduct(updatingData, existingProduct);
		
		return genericMapper.serialize(updatedProduct);
	}
	
	@Override
	@Transactional
	public void deleteProduct(@NonNull String productId) {
		UUID id = UUID.fromString(productId);
		Product existingProduct = getExistingProductOrElseThrow(id);
		productRepository.delete(existingProduct);
	}
	
	private Product getExistingProductOrElseThrow(UUID id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product not found"));
	}

	// ToDo: вынести в отдельный класс
	private Product updateProduct(@NonNull Product source, @NonNull Product target) {
		if(source.getDescription() != null) {
			target.setDescription(source.getDescription());
		}
		if(source.getPrice() != null) {
			target.setPrice(source.getPrice());
		}
		if(source.getQuantityInStock() != null) {
			target.setQuantityInStock(source.getQuantityInStock());
		}
		if(source.getName() != null) {
			target.setName(source.getName());
		}
		
		return target;
	}
}