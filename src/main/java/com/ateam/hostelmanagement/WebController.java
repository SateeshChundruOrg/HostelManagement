package com.ateam.hostelmanagement;

import java.text.DateFormat;
import java.util.Date;
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

import com.ateam.hostelmanagement.bean.Expense;
import com.ateam.hostelmanagement.bean.Hostel;
import com.ateam.hostelmanagement.bean.Hostler;
import com.ateam.hostelmanagement.bean.Payments;
import com.ateam.hostelmanagement.bean.Room;
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
	@RequestMapping(value="/createHostlerLand",method=RequestMethod.GET)
	public String createHostlerLand(Model model){
		model.addAttribute("hostler",new Hostler());
		return "createHostler";
}
	@RequestMapping(value="/editHostlerLand/{hostlerId}",method=RequestMethod.GET)
	public String editHostlerLand(Model model ,@PathVariable String hostlerId){
		//model.addAttribute("hostel", new Hostel());
		//Hostel hostel=hostlerService.getHostel(Long.parseLong(hostelId));
		Hostler hostler=hostlerService.getHostler(Long.parseLong(hostlerId));
		model.addAttribute("hostler",hostler);
		return "editHostler";
	}
	@RequestMapping(value="/createHostelLand",method=RequestMethod.GET)
	public String createHostelLand(Model model){
		model.addAttribute("hostel", new Hostel());
		
		return "createHostel";
}
	
	@RequestMapping(value="/editHostel/{hostelId}",method=RequestMethod.GET)
	public String editHostel(Model model ,@PathVariable String hostelId){
		//model.addAttribute("hostel", new Hostel());
		Hostel hostel=hostlerService.getHostel(Long.parseLong(hostelId));
		model.addAttribute("hostel",hostel);
		return "editHostel";
}
	@RequestMapping(value="/createRoomLand",method=RequestMethod.GET)
	public String createRoomLand(Model model){
		model.addAttribute("room",new Room());
		model.addAttribute("hostels",hostlerService.getallhostels());
		return "createRoom";
}
	@RequestMapping(value="/editRoom/{roomId}",method=RequestMethod.GET)
	public String editRoom(Model model ,@PathVariable String roomId){
		//model.addAttribute("hostel", new Hostel());
		model.addAttribute("hostels",hostlerService.getallhostels());
		Room room=hostlerService.getRoom(Long.parseLong(roomId));
		model.addAttribute("room",room);
		return "editRoom";
}
 @RequestMapping(value="/createExpenseLand",method=RequestMethod.GET)	
	public String createExpenseLand(Model model){
    model.addAttribute("expense",new Expense());
    return "createExpense";
 
 }
 @RequestMapping(value="/editExpense/{expenseId}",method=RequestMethod.GET)
 public String editExpense(Model model,@PathVariable String expenseId){
	 model.addAttribute("expenses",hostlerService.getallExpenses());
	 Expense expense=hostlerService.getExpense(Long.parseLong(expenseId));
	 model.addAttribute("expense",expense);
	 return "editExpense";
 }
 @RequestMapping(value = "/allExpenses", method = RequestMethod.GET)
	public String allExpenses(Model model) {
		
		model.addAttribute("expenses",hostlerService.getallExpenses());

	       return "Expense";

	}
 @RequestMapping(value="/createHostlerRoomMappingLand/{hostlerId}",method=RequestMethod.GET)
	public String createHostlerRoomMappingLand(Model model,@PathVariable
			Long hostlerId ){
	 model.addAttribute("hostlerRoomMapping",hostlerService.getAssign(hostlerId));
	 
		model.addAttribute("rooms",hostlerService.getAvailableBeds());
		model.addAttribute("hostlerId",hostlerId);
		return "createHostlerRoomMapping";
}

 @RequestMapping(value = "/unpaidHostlerSearchLand", method = RequestMethod.GET)
	public String getUnpaidHostlerSearchLand(Model model) {
		

	       return "selectDate";
 }

 
 @RequestMapping(value = "/unpaidHostlers", method = RequestMethod.GET)
	public String paymentDetails(Model model,@RequestParam(value="fromDate" ,required=false,defaultValue="1970-01-01")String fromDate,@RequestParam(value="toDate" ,required=false,defaultValue="2099-01-01")String toDate) {
		
		model.addAttribute("hostlers",hostlerService.getUnPaidHostlerIds(fromDate, toDate));
        model.addAttribute("unpaid",1);
	       return "home";

	}
 @RequestMapping(value="/hostler/createPaymentLand/{hostlerId}",method=RequestMethod.GET)
 public String createpaymentLand(Model model,@PathVariable Long hostlerId,@RequestParam(value="actualDate",required=false)String actualDate){
	 model.addAttribute("actualDate",actualDate);
model.addAttribute("payments",new Payments());
model.addAttribute("hostlerId",hostlerId);
 return "createPayment";
 }
 
 }
 

	


