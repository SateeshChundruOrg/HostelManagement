package com.ateam.hostelmanagement.hostlerserviceimpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;















import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ateam.hostelmanagement.bean.CurrentPayers;
import com.ateam.hostelmanagement.bean.Expense;
import com.ateam.hostelmanagement.bean.Hostel;
import com.ateam.hostelmanagement.bean.Hostler;
import com.ateam.hostelmanagement.bean.HostlerRoomMapping;
import com.ateam.hostelmanagement.bean.HostlerSearch;
import com.ateam.hostelmanagement.bean.Payments;
import com.ateam.hostelmanagement.bean.Room;
import com.ateam.hostelmanagement.bean.RoomSearch;
import com.ateam.hostelmanagement.hosteldao.HostlerDao;
import com.ateam.hostelmanagement.hostelservice.HostlerService;
import com.ateam.hostelmanagement.settings.Constants;
import com.ateam.hostelmanagement.util.Api;
@Service
public class HostlerServiceImpl implements HostlerService{

	@Autowired
	HostlerDao hostlerDao;
	@Autowired
	Constants constants;
	@Override
	public void saveHostler(Hostler hostler) {
		System.out.println(hostler.getName());
		hostlerDao.saveHostler(hostler);
		
	}
	@Override
	public List<Hostler> getallhostlers(int page) {
		int offSet=(page-1)*constants.pageSize;
		
		return hostlerDao.getallhostlers(offSet,constants.pageSize);
	}
	@Override
	public void deleteHostler(long hostlerId) {
		// TODO Auto-generated method stub
		hostlerDao.deleteHostler(hostlerId);
		
	}
	@Override
	public void editHostler(Hostler hostler) {
		// TODO Auto-generated method stub
		hostlerDao.editHostler(hostler);
		
	}
	@Override
	public Hostler getHostler(long hostlerId) {
		// TODO Auto-generated method stub
		return hostlerDao.getHostler(hostlerId);
	}
	@Override
	public void saveHostel(Hostel hostel) {
		// TODO Auto-generated method stub
		hostlerDao.saveHostel(hostel);
	}
	@Override
	public List<Hostel> getallhostels(int page) {
		int offSet=(page-1)*constants.pageSize;
		
		return hostlerDao.getallhostels(offSet,constants.pageSize);
	}
//	@Override
//	public List<Hostel> getallhostels() {
//		// TODO Auto-generated method stub
//		return hostlerDao.getallhostels(offSet, pageSize)();
//	}
	@Override
	public void deleteHostel(long hostelId) {
		// TODO Auto-generated method stub
		hostlerDao.deleteHostel(hostelId);
		
	}
	@Override
	public void editHostel(Hostel hostel) {
		// TODO Auto-generated method stub
		hostlerDao.editHostel(hostel);
		
	}
	@Override
	public Hostel getHostel(long hostelId) {
		// TODO Auto-generated method stub
		return hostlerDao.getHostel(hostelId);
	}
	@Override
	public void saveRoom(Room room) {
		// TODO Auto-generated method stub
		hostlerDao.saveRoom(room);
		
	}
	//@Override
//	public List<Room> getallrooms() {
//		// TODO Auto-generated method stub
//		return hostlerDao.getallrooms();
//	}
	@Override
	public void deleteRoom(long roomId) {
		// TODO Auto-generated method stub
		hostlerDao.deleteRoom(roomId);
		
	}
	@Override
	public void editRoom(Room room) {
		// TODO Auto-generated method stub
		hostlerDao.editRoom(room);
	}
	@Override
	public Room getRoom(long roomId) {
		// TODO Auto-generated method stub
		return hostlerDao.getRoom(roomId);
	}
	@Override
	public void saveExpense(Expense expense) {
		// TODO Auto-generated method stub
	hostlerDao.saveExpense(expense);	
	}
	@Override
	public List<Expense> getallExpenses() {
		// TODO Auto-generated method stub
		return hostlerDao.getallExpenses();
	}
	@Override
	public void deleteExpense(long expenseId) {
		// TODO Auto-generated method stub
		hostlerDao.deleteExpense(expenseId);
	}
	@Override
	public void editExpense(Expense expense) {
		// TODO Auto-generated method stub
		hostlerDao.editExpense(expense);
	}
	@Override
	public Expense getExpense(long expenseId) {
		// TODO Auto-generated method stub
		return hostlerDao.getExpense(expenseId);
	}
	@Override
	public void saveAssign(HostlerRoomMapping hostlerRoomMapping) {
		// TODO Auto-generated method stub
		hostlerDao.saveAssign(hostlerRoomMapping);
	}
	@Override
	public List<HostlerRoomMapping> getallAssigns() {
		// TODO Auto-generated method stub
		return hostlerDao.getallAssigns();
	}
	@Override
	public void deleteAssign(long hostlerId) {
		// TODO Auto-generated method stub
		hostlerDao.deleteAssign(hostlerId);
	}
	@Override
	public void editAssign(HostlerRoomMapping hostlerRoomMapping) {
		// TODO Auto-generated method stub
	hostlerDao.editAssign(hostlerRoomMapping);	
	}
	@Override
	public HostlerRoomMapping getAssign(long id) {
		// TODO Auto-generated method stub
		return hostlerDao.getAssign(id);
	}
	@Override
	public List<Room> getAvailableBeds() {
		// TODO Auto-generated method stub
		return hostlerDao.getAvailableBeds();
	}
	@Override
	public List<HostlerRoomMapping> getHostlersRooms() {
		// TODO Auto-generated method stub
		return hostlerDao.getHostlersRooms();
	}
	@Override
	public List<Long> getPaidHostlerIds(String fromDate, String toDate) {
		// TODO Auto-generated method stub
		return hostlerDao.getPaidHostlerIds(fromDate, toDate);
	}
	@Override
	public List<Hostler> getUnPaidHostlerIds(String fromDate, String toDate) {
		// TODO Auto-generated method stub
		return hostlerDao.getUnPaidHostlerIds(fromDate, toDate);
	}
	@Override
	public void savePayment(Payments payments) {
		// TODO Auto-generated method stub
		hostlerDao.savePayment(payments);
		
	}
	@Override
	public List<Payments> getPaymentDetails() {
		// TODO Auto-generated method stub
		return hostlerDao.getPaymentDetails();
	}
	@Override
	public List<Hostler> getHostlerSearch(HostlerSearch hostlerSearch) {
		// TODO Auto-generated method stub
		return hostlerDao.getHostlerSearch(hostlerSearch);
	}
	@Override
	public List<Hostler> getCurrentHostlers() {

		int day=-Api.getGivenFieldFromDateAndTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd"), Api.DateType.DAY);
		Date fromDate=DateUtils.addDays(new Date(), day);
		Date todate=new Date();
		String fromDateInSting=DateFormatUtils.format(fromDate, "yyyy-MM-dd");
		String toDateInstring=DateFormatUtils.format(todate, "yyyy-MM-dd");
		
		
		
		
		
		
		return hostlerDao.getUnPaidHostlerIds(fromDateInSting, toDateInstring);
	}
	@Override
	public List<Room> getRoomSearch(RoomSearch roomSearch) {
		// TODO Auto-generated method stub
		return hostlerDao.getRoomSearch(roomSearch);
	}

	@Override
	public BigDecimal getSpent(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return hostlerDao.getSpent(startDate, endDate);
	}
	@Override
	public BigDecimal getReceived(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return hostlerDao.getReceived(startDate, endDate);
	}
	@Override
	public List<Payments> getPaymentHistory(long hostlerId) {
		// TODO Auto-generated method stub
		return hostlerDao.getPaymentHistory(hostlerId);
	}
	@Override
	public long getHostlersCount() {
		return hostlerDao.getHostlersCount();
	}
	
	@Override
	public long getHostelsCount() {
		// TODO Auto-generated method stub
		return hostlerDao.getHostelsCount();
	}
	@Override
	public long getRoomsCount() {
		// TODO Auto-generated method stub
		return hostlerDao.getRoomsCount();
	}
	@Override
	public List<Room> getallrooms(int page) {
		// TODO Auto-generated method stub
int offSet=(page-1)*constants.pageSize;
		
		return hostlerDao.getallrooms(offSet,constants.pageSize);
	}
	@Override
	public List<Hostler> getallHostlers2() {
		// TODO Auto-generated method stub
		return hostlerDao.getallHostlers2();
	}


}
