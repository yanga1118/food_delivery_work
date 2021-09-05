package food.delivery.work;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="OrderStatus_table")
public class OrderStatus {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String username;
        private String orderStatus;
        private String userId;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }
        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

}
