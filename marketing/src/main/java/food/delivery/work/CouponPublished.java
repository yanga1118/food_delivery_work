package food.delivery.work;

public class CouponPublished extends AbstractEvent {

    private Long id;
    private Integer phoneno;
    private String username;
    private String orderid;
    private String orderstatus;
    private String productid;
    private String paystatus;
    private String couponkind;
    private String couponuseyn;

    public CouponPublished(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(Integer phoneno) {
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
    public String getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(String paystatus) {
        this.paystatus = paystatus;
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
}
