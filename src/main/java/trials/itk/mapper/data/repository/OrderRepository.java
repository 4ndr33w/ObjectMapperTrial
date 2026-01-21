package trials.itk.mapper.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trials.itk.mapper.data.entity.Order;

import java.util.UUID;

/**
 * @author 4ndr33w
 * @version 1.0
 */
public interface OrderRepository extends JpaRepository<Order, UUID> {
}