package food.delivery.work;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Promote_table")
public class Promote {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    //phoneno String 변경
    private String phoneno;
    private String username;
    private String orderid;
    private String orderstatus;
    private String productid;
    //payStatus 변경
    private String deliverytatus;
    private String couponkind;
    private String couponuseyn;
    //userId 추가
    private Long userId;


    @PostPersist
    public void onPostPersist(){
        CouponPublished couponPublished = new CouponPublished();
        BeanUtils.copyProperties(this, couponPublished);
        couponPublished.publishAfterCommit();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }
    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }
    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }
    public String getdeliverytatus() {
        return deliverytatus;
    }

    public void setdeliverytatus(String deliverytatus) {
        this.deliverytatus = deliverytatus;
    }
    public String getCouponkind() {
        return couponkind;
    }

    public void setCouponkind(String couponkind) {
        this.couponkind = couponkind;
    }
    public String getCouponuseyn() {
        return couponuseyn;
    }

    public void setCouponuseyn(String couponuseyn) {
        this.couponuseyn = couponuseyn;
    }

    public String getDeliverytatus() {
        return deliverytatus;
    }

    public void setDeliverytatus(String deliverytatus) {
        this.deliverytatus = deliverytatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    


}