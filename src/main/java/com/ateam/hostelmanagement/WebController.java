package com.ateam.hostelmanagement;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;











import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ateam.hostelmanagement.bean.CurrentPayers;
import com.ateam.hostelmanagement.bean.Expense;
import com.ateam.hostelmanagement.bean.Hostel;
import com.ateam.hostelmanagement.bean.Hostler;
import com.ateam.hostelmanagement.bean.HostlerRoomMapping;
import com.ateam.hostelmanagement.bean.HostlerSearch;
import com.ateam.hostelmanagement.bean.Payments;
import com.ateam.hostelmanagement.bean.Room;
import com.ateam.hostelmanagement.bean.RoomSearch;
import com.ateam.hostelmanagement.hostelservice.HostlerService;


@Controller
@Lazy(true)
@RequestMapping(value = "/web")
public class WebController {
	@Autowired
	HostlerService hostlerService;
	
	
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value="/hostler/create",method=RequestMethod.GET)
	public String createHostlerLand(Model model){
		model.addAttribute("hostler",new Hostler());
		return "createHostler";
}
	@RequestMapping(value="/hostler/edit/{hostlerId}",method=RequestMethod.GET)
	public String editHostlerLand(Model model ,@PathVariable String hostlerId){
		//model.addAttribute("hostel", new Hostel());
		//Hostel hostel=hostlerService.getHostel(Long.parseLong(hostelId));
		Hostler hostler=hostlerService.getHostler(Long.parseLong(hostlerId));
		model.addAttribute("hostler",hostler);
		return "editHostler";
	}
	@RequestMapping(value = "/hostler/all", method = RequestMethod.GET)
	public String allHostlers(Model model) {
		//hostlerService.editHostler(hostler);
		List<HostlerRoomMapping> hostlerRoomMappings=hostlerService.getallAssigns();
		List<Hostler> hostlers=hostlerService.getallhostlers();
	  for (Hostler hostler : hostlers) {
		if(hostlerRoomMappings.contains(hostler)){
			hostler.setRoomAssigned(true);
		}
	}
	
		model.addAttribute("hostlers",hostlers);

	       return "home";

	}
	@RequestMapping(value="/hostler/search",method=RequestMethod.GET)
	public String hostlerSearch(Model model){
	     
		model.addAttribute("search",new HostlerSearch());
		return "hostlerSearch";
	}
	@RequestMapping(value="/hostler/search",method=RequestMethod.POST)
	public String hostlerSearch2(Model model,HostlerSearch hostlerSearch){
	     
		model.addAttribute("search",new HostlerSearch());
		model.addAttribute("hostlers",hostlerService.getHostlerSearch(hostlerSearch));
	       return "home";
	}
	@RequestMapping(value = "/hostler/current/payers", method = RequestMethod.GET)
	public String currentPayers(Model model) {
		
		List<CurrentPayers> hostlers=hostlerService.getCurrentHostlers();
          model.addAttribute("hostlers",hostlers);
	       return "hostlerCurrentPayers";
	}
	@RequestMapping(value="/hostel/create",method=RequestMethod.GET)
	public String createHostelLand(Model model){
		model.addAttribute("hostel", new Hostel());
		
		return "createHostel";
}
	
	@RequestMapping(value="/hostel/edit/{hostelId}",method=RequestMethod.GET)
	public String editHostel(Model model ,@PathVariable String hostelId){
		//model.addAttribute("hostel", new Hostel());
		Hostel hostel=hostlerService.getHostel(Long.parseLong(hostelId));
		model.addAttribute("hostel",hostel);
		return "editHostel";
}
	@RequestMapping(value = "/hostel/all", method = RequestMethod.GET)
	public String allHostels(Model model) {
		//hostlerService.editHostler(hostler);
		model.addAttribute("host",hostlerService.getallhostels());

	       return "homeHostel";

	}
	@RequestMapping(value="/hostel/room/create",method=RequestMethod.GET)
	public String createRoomLand(Model model){
		model.addAttribute("room",new Room());
		model.addAttribute("hostels",hostlerService.getallhostels());
		return "createRoom";
}
	@RequestMapping(value="/hostel/room/edit/{roomId}",method=RequestMethod.GET)
	public String editRoom(Model model ,@PathVariable String roomId){
		//model.addAttribute("hostel", new Hostel());
		model.addAttribute("hostels",hostlerService.getallhostels());
		Room room=hostlerService.getRoom(Long.parseLong(roomId));
		model.addAttribute("room",room);
		return "editRoom";
}
	@RequestMapping(value = "/hostel/room/all", method = RequestMethod.GET)
	public String allRooms(Model model) {
		//hostlerService.editHostler(hostler);
		model.addAttribute("room",hostlerService.getallrooms());

	       return "homeRoom";

	}
	@RequestMapping(value="/hostel/room/search",method=RequestMethod.GET)
	public String roomSearch(Model model){
	     
		model.addAttribute("search",new RoomSearch());
		return "roomSearch";
	}
	@RequestMapping(value="/hostel/room/search",method=RequestMethod.POST)
	public String roomSearch(Model model,RoomSearch roomSearch){
	     
		model.addAttribute("search",new RoomSearch());
		model.addAttribute("rooms",hostlerService.getRoomSearch(roomSearch));
	       return "availableBeds";
	}
 @RequestMapping(value="/expense/create",method=RequestMethod.GET)	
	public String createExpenseLand(Model model){
    model.addAttribute("expense",new Expense());
    return "createExpense";
 
 }
 @RequestMapping(value="/expense/edit/{expenseId}",method=RequestMethod.GET)
 public String editExpense(Model model,@PathVariable String expenseId){
	 model.addAttribute("expenses",hostlerService.getallExpenses());
	 Expense expense=hostlerService.getExpense(Long.parseLong(expenseId));
	 model.addAttribute("expense",expense);
	 return "editExpense";
 }
 @RequestMapping(value = "/expense/all", method = RequestMethod.GET)
	public String allExpenses(Model model) {
		
		model.addAttribute("expenses",hostlerService.getallExpenses());

	       return "Expense";

	}
 @RequestMapping(value="/hostler/room/mapping/create/{hostlerId}",method=RequestMethod.GET)
	public String createHostlerRoomMappingLand(Model model,@PathVariable
			Long hostlerId ){
	 model.addAttribute("hostlerRoomMapping",hostlerService.getAssign(hostlerId));
	 
		model.addAttribute("rooms",hostlerService.getAvailableBeds());
		model.addAttribute("hostlerId",hostlerId);
		return "createHostlerRoomMapping";
}
 @RequestMapping(value="/hostler/room" ,method=RequestMethod.GET)
	public String hostlersRooms(Model model){
		
		model.addAttribute("hostlersRoom",hostlerService.getHostlersRooms());
		return "hostlersRooms";
		
	}
	

 @RequestMapping(value = "/hostler/unpaid/search", method = RequestMethod.GET)
	public String getUnpaidHostlerSearchLand(Model model) {
		

	       return "unpaidHostlerSearch";
 }

 
 @RequestMapping(value = "/hostler/unpaid", method = RequestMethod.GET)
	public String paymentDetails(Model model,@RequestParam(value="fromDate" ,required=false,defaultValue="1970-01-01")String fromDate,@RequestParam(value="toDate" ,required=false,defaultValue="2099-01-01")String toDate) {
		
		model.addAttribute("hostlers",hostlerService.getUnPaidHostlerIds(fromDate, toDate));
        model.addAttribute("unpaid",1);
	       return "home";

	}
 @RequestMapping(value="/hostler/payment/create/{hostlerId}",method=RequestMethod.GET)
 public String createpaymentLand(Model model,@PathVariable Long hostlerId,@RequestParam(value="actualDate",required=false)String actualDate){
	 model.addAttribute("actualDate",actualDate);
model.addAttribute("payments",new Payments());
model.addAttribute("hostlerId",hostlerId);
 return "createPayment";
 }
 @RequestMapping(value = "/payment/all", method = RequestMethod.GET)
	public String allPayments(Model model) {
		//hostlerService.editHostler(hostler);
		model.addAttribute("payments",hostlerService.getPaymentDetails());

	       return "Payments";

	}
 @RequestMapping(value = "/hostel/expense/amount1", method = RequestMethod.GET)
	public String getExpenseAmount(Model model) {
		

	       return "expenseSearch";
}
@RequestMapping(value = "/hostel/expense/amount", method = RequestMethod.GET)
	public String expenseAmount(Model model,@RequestParam(value="startDate" ,required=false,defaultValue="1970-01-01")String startDate,@RequestParam(value="endDate" ,required=false,defaultValue="2099-01-01")String endDate) {
	 BigDecimal amountSpent=hostlerService.getSpent(startDate, endDate);
	 BigDecimal amountReceived=hostlerService.getReceived(startDate, endDate);
		model.addAttribute("amountSpent",amountSpent.toString());
		model.addAttribute("amountReceived",amountReceived.toString());
		model.addAttribute("availableAmount",amountReceived.subtract(amountSpent).toString());
		
		
 
	       return "percentage";

}
 
 }
 

	


