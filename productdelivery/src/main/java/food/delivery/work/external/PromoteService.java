package food.delivery.work.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="marketing", url = "http://loalhost:8083")
public interface PromoteService {
  
    @RequestMapping(method=RequestMethod.POST, path="/promotes/createPromoteInfo" , consumes="aplication/json")
    public boolean publishCoupon(@RequestParam String Id, @RequestParam String userid , @RequestParam String status ,  @RequestParam String phoneno );

}
