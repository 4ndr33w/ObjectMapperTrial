package trials.itk.mapper.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trials.itk.mapper.data.entity.Customer;
import trials.itk.mapper.data.mapper.GenericMapper;
import trials.itk.mapper.data.repository.CustomerRepository;
import trials.itk.mapper.exception.CustomerNotFoundException;
import trials.itk.mapper.service.CustomerService;

import java.util.UUID;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
	
	private final CustomerRepository customerRepository;
	private final GenericMapper genericMapper;
	
	@Override
	@Transactional
	public String createCustomer(@NonNull String request) {
		Customer customer = genericMapper.deserialize(request, Customer.class);
		Customer savedCustomer = customerRepository.save(customer);
		
		return genericMapper.serialize(savedCustomer);
	}
	
	@Override
	@Transactional(readOnly = true)
	public String getCustomer(@NonNull String id) {
		// При неверном формате UUID выпадает TargetInvocationException
		// который обрабатывается в GlobalExceptionHandler
		UUID uuid = UUID.fromString(id);

		Customer existingCustomer = customerRepository.findById(uuid)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
		
		return genericMapper.serialize(existingCustomer);
	}
}