package food.delivery.work.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import food.delivery.work.Promote;

import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="marketing", url = "http://localhost:8083", fallback = PromoteServiceFallback.class)
public interface PromoteService {
  
    @RequestMapping(method=RequestMethod.POST, path="/createPromoteInfo")
    public boolean publishCoupon(@RequestBody Promote promote);
}
