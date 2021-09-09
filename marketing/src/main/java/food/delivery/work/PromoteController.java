package food.delivery.work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



 @RestController
 public class promoteController {
    
    @Autowired
    PromoteRepository promoteRepository;
   
    @RequestMapping(value = "/promotes/publishCoupon", method=RequestMethod.POST)
    public boolean publishCoupon(HttpServletRequest request, HttpServletResponse response) throws Exception{
      
      //order Id, 배송 상태, 사용자 ID, 사용자 전화번호 
       String orderid = request.getParameter("id");
       String status = request.getParameter("status");
       String userid = request.getParameter("userId");
       String phoneno = request.getParameter("phoneno");

       Promote promote = new Promote();

       promote.setOrderid(orderid);
       promote.setdeliverytatus(status);
       promote.setUserId(Long.valueOf(userid));
       promote.setPhoneno(phoneno);

       promoteRepository.save(promote);
       
       return true;
   }
}