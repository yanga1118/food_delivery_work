package food.delivery.work;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="stockDeliveries", path="stockDeliveries")
public interface StockDeliveryRepository extends PagingAndSortingRepository<StockDelivery, Integer>{


}
