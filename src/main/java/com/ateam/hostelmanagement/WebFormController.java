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


import com.ateam.hostelmanagement.Validators.HostlerValidator;
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
	@RequestMapping (value="/createHostler",method=RequestMethod.POST)
	public String createHostler(Model model,@ModelAttribute("hostler") Hostler hostler,BindingResult result){
		hostlerValidator.validate(hostler, result);
		if(result.hasErrors()){
			model.addAttribute("hostler",hostler);
			return "createHostler";
		}
		
		hostlerService.saveHostler(hostler);
//		model.addAttribute("host",  hostlerService.getallhostlers());
//		return "home";
		  return "redirect:/web/form/allHostlers";
	
	}
	@RequestMapping(value = "/deleteHostler/{hostlerId}", method = RequestMethod.GET)
	public String deleteHostler( Model model,@PathVariable("hostlerId")Long  hostlerId) {
		hostlerService.deleteHostler(hostlerId);
//		model.addAttribute("host", hostlerService.getallhostlers());
//
//       return "home";
	
		  return "redirect:/web/form/allHostlers";
	}
	
	@RequestMapping(value = "/editHostler", method = RequestMethod.POST)
	public String editHostler( Model model,@ModelAttribute("hostel") Hostler hostler) {
		hostlerService.editHostler(hostler);
		//model.addAttribute("host",hostlerService.getallhostlers());

	       return "redirect:/web/form/allHostlers";

	}
	@RequestMapping(value = "/allHostlers", method = RequestMethod.GET)
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
	
	@RequestMapping (value="/createHostel",method=RequestMethod.POST)
	public String createHostel(Model model,@ModelAttribute("hostel") Hostel hostel){
		hostlerService.saveHostel(hostel);
		return "redirect:/web/form/allHostels";
		
	}
	@RequestMapping(value = "/deleteHostel/{hostelId}", method = RequestMethod.GET)
	public String deleteHostel( Model model,@PathVariable("hostelId")Long  hostleId) {
		hostlerService.deleteHostel(hostleId);

	
		  return "redirect:/web/form/allHostels";
	}
	

	
	@RequestMapping(value = "/editHostel", method = RequestMethod.POST)
	public String editHostel( Model model,@ModelAttribute("hostel") Hostel hostel) {
		hostlerService.editHostel(hostel);
		//model.addAttribute("host",hostlerService.getallhostlers());

	       return "redirect:/web/form/allHostels";

	}
	@RequestMapping(value = "/allHostels", method = RequestMethod.GET)
	public String allHostels(Model model) {
		//hostlerService.editHostler(hostler);
		model.addAttribute("host",hostlerService.getallhostels());

	       return "homeHostel";

	}
	
	@RequestMapping (value="/createRoom",method=RequestMethod.POST)
	public String createRoom(Model model,@ModelAttribute("room") Room room){
		
		hostlerService.saveRoom(room);
		return "redirect:/web/form/allRooms";
		
	}
	@RequestMapping(value = "/deleteRoom/{roomId}", method = RequestMethod.GET)
	public String deleteRoom( Model model,@PathVariable("roomId")Long  roomId) {
		hostlerService.deleteRoom(roomId);

	
		  return "redirect:/web/form/allRooms";
	}
	

	
	@RequestMapping(value = "/editRoom", method = RequestMethod.POST)
	public String editRoom( Model model,@ModelAttribute("room") Room room) {
		hostlerService.editRoom(room);
		//model.addAttribute("host",hostlerService.getallhostlers());

	       return "redirect:/web/form/allRooms";

	}
	@RequestMapping(value = "/allRooms", method = RequestMethod.GET)
	public String allRooms(Model model) {
		//hostlerService.editHostler(hostler);
		model.addAttribute("room",hostlerService.getallrooms());

	       return "homeRoom";

	}
	
	
	@RequestMapping (value="/createExpense",method=RequestMethod.POST)
	public String createExpense(Model model,@ModelAttribute("expense") @Valid Expense expense,BindingResult result){
		
		if(result.hasErrors()){
			
			return "createExpense";
		}
		else{
			model.addAttribute("expense",expense);
		hostlerService.saveExpense(expense);
		return "redirect:/web/allExpenses";
		}
		
	}
	@RequestMapping(value = "/deleteExpense/{expenseId}", method = RequestMethod.GET)
	public String deleteExpense( Model model,@PathVariable("expenseId")Long  expenseId) {
		hostlerService.deleteExpense(expenseId);

	
		  return "redirect:/web/allExpenses";
	}
	

	
	@RequestMapping(value = "/editExpense", method = RequestMethod.POST)
	public String editExpense( Model model,@ModelAttribute("expense") Expense expense) {
		hostlerService.editExpense(expense);
		//model.addAttribute("host",hostlerService.getallhostlers());

	       return "redirect:/web/allExpenses";

	}
	
	@RequestMapping(value="/createHostlerRoomMapping",method=RequestMethod.POST)
	public String createHostlerRoomMappingLand(Model model,@ModelAttribute("hostlerRoomMapping") HostlerRoomMapping hostlerRoomMapping){
		HostlerRoomMapping hostlerRoomMappingFromDb=hostlerService.getAssign(hostlerRoomMapping.getHostlerId());
		
		if(hostlerRoomMappingFromDb==null){
			hostlerService.saveAssign(hostlerRoomMapping);	
		}else{
			hostlerService.editAssign(hostlerRoomMapping);
			
		}
		
		//model.addAttribute("rooms",hostlerService.getallAssigns());
		model.addAttribute("hostlerId",hostlerRoomMapping);
		
		  return "redirect:/web/form/allHostlers";
		
	}


	@RequestMapping(value="/hostlersRooms" ,method=RequestMethod.GET)
	public String hostlersRooms(Model model){
		
		model.addAttribute("hostlersRoom",hostlerService.getHostlersRooms());
		return "hostlersRooms";
		
	}
	
	/*@RequestMapping(value="/payersDetails" ,method=RequestMethod.GET)
	public String payersDetails(Model model){
		model.addAttribute("hostlerRoomMapping",hostlerService.getallAssigns());
		return "selectDetails";
	}*/

	@RequestMapping (value="/createPayment",method=RequestMethod.POST)
	public String createPayment(Model model,@ModelAttribute("payments") Payments payments){
		hostlerService.savePayment(payments);
		return "redirect:/web/form/allPayments";
		
	}
	@RequestMapping(value = "/allPayments", method = RequestMethod.GET)
	public String allPayments(Model model) {
		//hostlerService.editHostler(hostler);
		model.addAttribute("payments",hostlerService.getPaymentDetails());

	       return "Payments";

	}


}
