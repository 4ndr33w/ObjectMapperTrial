package trials.itk.mapper.data.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import trials.itk.mapper.data.dto.response.OrderResponseDto;
import trials.itk.mapper.data.entity.Order;
import trials.itk.mapper.exception.MappingException;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@Component
@RequiredArgsConstructor
public class GenericMapper {
	
	private final ObjectMapper objectMapper;
	private final OrderMapper orderMapper;
	
	public <T> T deserialize(String source, Class<T> target) {
		try {
			return objectMapper.readValue(source, target);
		}
		catch(JsonProcessingException e) {
			throw new MappingException(e.getMessage());
		}
	}
	
	public<T> String serialize(T source) {
		try {
			if(source instanceof Order) {
				OrderResponseDto orderResponseDto = orderMapper.mapToOrderResponseDto((Order)source);
				return objectMapper.writeValueAsString(orderResponseDto);
			}
			return objectMapper.writeValueAsString(source);
		} catch(JsonProcessingException e) {
			throw new MappingException(e.getMessage());
		}
	}
}