package com.ateam.hostelmanagement;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;






import com.ateam.hostelmanagement.Validators.ExpenseValidator;
import com.ateam.hostelmanagement.Validators.HostelValidator;
import com.ateam.hostelmanagement.Validators.HostlerValidator;
import com.ateam.hostelmanagement.Validators.PaymentValidator;
import com.ateam.hostelmanagement.Validators.RoomValidator;
import com.ateam.hostelmanagement.bean.Expense;
import com.ateam.hostelmanagement.bean.Hostel;
import com.ateam.hostelmanagement.bean.Hostler;
import com.ateam.hostelmanagement.bean.HostlerRoomMapping;
import com.ateam.hostelmanagement.bean.Payments;
import com.ateam.hostelmanagement.bean.Room;
import com.ateam.hostelmanagement.hostelservice.HostlerService;

@Controller
@Lazy(true)
@RequestMapping(value = "/web/form")
public class WebFormController {
	
	@Autowired
	HostlerService hostlerService;
    @Autowired
    HostlerValidator hostlerValidator;
    @Autowired
    RoomValidator roomValidator;
    @Autowired
    HostelValidator hostelValidator;
    @Autowired
    ExpenseValidator expenseValidator;
    @Autowired
    PaymentValidator paymentValidator;
	
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
	@RequestMapping (value="/hostler/create",method=RequestMethod.POST)
	public String createHostler(Model model,@ModelAttribute("hostler") Hostler hostler,BindingResult result){
		hostlerValidator.validate(hostler, result);
		if(result.hasErrors()){
			model.addAttribute("hostler",hostler);
			return "createHostler";
		}
		
		hostlerService.saveHostler(hostler);
//		model.addAttribute("host",  hostlerService.getallhostlers());
//		return "home";
		  return "redirect:/web/hostler/all";
	
	}
	@RequestMapping(value = "/hostler/delete/{hostlerId}", method = RequestMethod.GET)
	public String deleteHostler( Model model,@PathVariable("hostlerId")Long  hostlerId) {
		hostlerService.deleteHostler(hostlerId);
//		model.addAttribute("host", hostlerService.getallhostlers());
//
//       return "home";
	
		  return "redirect:/web/hostler/all";
	}
	
	@RequestMapping(value = "/hostler/edit", method = RequestMethod.POST)
	public String editHostler( Model model,@ModelAttribute("hostel") Hostler hostler, BindingResult result) {
		hostlerValidator.validate(hostler, result);
		if(result.hasErrors()){
			model.addAttribute("hostler",hostler);
			return "editHostler";
		}
		hostlerService.editHostler(hostler);
		//model.addAttribute("host",hostlerService.getallhostlers());

	       return "redirect:/web/hostler/all";

	}
	
	
	@RequestMapping (value="/hostel/create",method=RequestMethod.POST)
	public String createHostel(Model model,@ModelAttribute("hostel") Hostel hostel,BindingResult result){
		hostelValidator.validate(hostel, result);
		if(result.hasErrors()){
			model.addAttribute("hostel",hostel);
			return "createHostel";
		}
		hostlerService.saveHostel(hostel);
		return "redirect:/web/hostel/all";
		
	}
	@RequestMapping(value = "/hostel/delete/{hostelId}", method = RequestMethod.GET)
	public String deleteHostel( Model model,@PathVariable("hostelId")Long  hostleId) {
		hostlerService.deleteHostel(hostleId);

	
		  return "redirect:/web/hostel/all";
	}
	

	
	@RequestMapping(value = "/hostel/edit", method = RequestMethod.POST)
	public String editHostel( Model model,@ModelAttribute("hostel") Hostel hostel) {
		hostlerService.editHostel(hostel);
		//model.addAttribute("host",hostlerService.getallhostlers());

	       return "redirect:/web/hostel/all";

	}
	
	
	@RequestMapping (value="/hostel/room/create",method=RequestMethod.POST)
	public String createRoom(Model model,@ModelAttribute("room") Room room,BindingResult result){
		roomValidator.validate(room, result);
		if(result.hasErrors()){
			model.addAttribute("room",room);
			return "createRoom";
		}
		hostlerService.saveRoom(room);
		return "redirect:/web/hostel/room/all";
		
	}
	@RequestMapping(value = "/hostel/room/delete/{roomId}", method = RequestMethod.GET)
	public String deleteRoom( Model model,@PathVariable("roomId")Long  roomId) {
		hostlerService.deleteRoom(roomId);

	
		  return "redirect:/web/hostel/room/all";
	}
	

	
	@RequestMapping(value = "/hostel/room/edit", method = RequestMethod.POST)
	public String editRoom( Model model,@ModelAttribute("room") Room room) {
		hostlerService.editRoom(room);
		//model.addAttribute("host",hostlerService.getallhostlers());

	       return "redirect:/web/hostel/room/all";

	}
	
	
	
	@RequestMapping (value="/expense/create",method=RequestMethod.POST)
	public String createExpense(Model model,@ModelAttribute("expense")  Expense expense,BindingResult result){
		expenseValidator.validate(expense, result);
		if(result.hasErrors()){
			model.addAttribute("expense",expense);
			return "createExpense";
		}
		else{
			
		hostlerService.saveExpense(expense);
		return "redirect:/web/expense/all";
		}
		
	}
	@RequestMapping(value = "/expense/delete/{expenseId}", method = RequestMethod.GET)
	public String deleteExpense( Model model,@PathVariable("expenseId")Long  expenseId) {
		hostlerService.deleteExpense(expenseId);

	
		  return "redirect:/web/expense/all";
	}
	

	
	@RequestMapping(value = "/expense/edit", method = RequestMethod.POST)
	public String editExpense( Model model,@ModelAttribute("expense") Expense expense) {
		hostlerService.editExpense(expense);
		//model.addAttribute("host",hostlerService.getallhostlers());

	       return "redirect:/web/expense/all";

	}
	
	@RequestMapping(value="/hostler/room/mapping/create",method=RequestMethod.POST)
	public String createHostlerRoomMappingLand(Model model,@ModelAttribute("hostlerRoomMapping") HostlerRoomMapping hostlerRoomMapping,BindingResult result){
		HostlerRoomMapping hostlerRoomMappingFromDb=hostlerService.getAssign(hostlerRoomMapping.getHostlerId());
		
		if(hostlerRoomMappingFromDb==null){
			hostlerService.saveAssign(hostlerRoomMapping);	
		}else{
			hostlerService.editAssign(hostlerRoomMapping);
			
		}
		
		//model.addAttribute("rooms",hostlerService.getallAssigns());
		model.addAttribute("hostlerId",hostlerRoomMapping);
		
		  return "redirect:/web/hostler/all";
		
	}


	
	/*@RequestMapping(value="/payersDetails" ,method=RequestMethod.GET)
	public String payersDetails(Model model){
		model.addAttribute("hostlerRoomMapping",hostlerService.getallAssigns());
		return "selectDetails";
	}*/

	@RequestMapping (value="/payment/create",method=RequestMethod.POST)
	public String createPayment(Model model,@ModelAttribute("payments") Payments payments,BindingResult result){
		paymentValidator.validate(payments, result);
		if(result.hasErrors()){
			model.addAttribute("payments",payments);
			return "createPayment";
		}
		hostlerService.savePayment(payments);
		return "redirect:/web/payment/all";
		
	}
	


}
