package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    
  @RequestMapping("/transaction")
  public Response greeting(@RequestParam(value="id") String identifier,
		  				   @RequestParam(value="price") int price,
		  				   @RequestParam(value="used", required = false) Boolean used) {
	  
	  Item orderItem = null;
	  if (used == null) {
		 orderItem = new Item(identifier, price);  
	  } else {
		  orderItem = new Item (identifier, price, used);
	  }
	        
      String warehouse = orderItem.warehouseByItemPrice(price);
      
      if (warehouse.equals("A") || warehouse.equals("B")) {
    	  return new Response(0, warehouse);
      } else if (warehouse.equals("N/A")) {
    	  return new Response(1, "Item needs to be processed manually");
      } else {
    	  return new Response(1, "Processing error");
      }
  }    
}
