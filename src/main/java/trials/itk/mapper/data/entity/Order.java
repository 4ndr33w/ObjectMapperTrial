package trials.itk.mapper.data.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import trials.itk.mapper.data.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@Getter
@Setter
@Builder
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private UUID id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "order_products",
			joinColumns = @JoinColumn(name = "order_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id")
	)
	@Builder.Default
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Product> products = new ArrayList<>();
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private ZonedDateTime orderDate;
	
	@Column(nullable = false)
	private String shippingAddress;
	
	@Column(nullable = false, precision = 10, scale = 2)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private BigDecimal totalPrice;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Builder.Default
	private OrderStatus orderStatus = OrderStatus.CREATED;
}