package trials.itk.mapper.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@Getter
@Setter
@Builder
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private UUID id;
	
	@Column(nullable = false)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String name;
	
	@Column(nullable = false)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String description;
	
	@Column(nullable = false, precision = 10, scale = 2)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private BigDecimal price;
	
	@Column(nullable = false)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Builder.Default
	private Long quantityInStock = 0L;
	
	@ManyToMany(mappedBy = "products")
	@Builder.Default
	@JsonIgnore
	private Set<Order> orders = new HashSet<>();
}