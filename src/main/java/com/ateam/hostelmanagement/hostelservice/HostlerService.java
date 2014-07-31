package com.ateam.hostelmanagement.hostelservice;

import java.util.List;








import com.ateam.hostelmanagement.bean.CurrentPayers;
import com.ateam.hostelmanagement.bean.HostlerRoomMapping;
import com.ateam.hostelmanagement.bean.Expense;
import com.ateam.hostelmanagement.bean.Hostel;
import com.ateam.hostelmanagement.bean.Hostler;
import com.ateam.hostelmanagement.bean.HostlerSearch;
import com.ateam.hostelmanagement.bean.Payments;
import com.ateam.hostelmanagement.bean.Room;
import com.ateam.hostelmanagement.bean.RoomSearch;

public interface HostlerService {
	
	public void saveHostler(Hostler hostler);
	public List<Hostler>getallhostlers();
	public void deleteHostler(long hostlerId);
    public void editHostler(Hostler hostler);
	public Hostler getHostler(long hostlerId);
	

	public List<Hostler> getHostlerSearch(HostlerSearch hostlerSearch);
	public List<CurrentPayers> getCurrentHostlers();
	
	public void saveHostel(Hostel hostel);
    public List<Hostel>getallhostels();
    public void deleteHostel(long hostelId);
    public void editHostel(Hostel hostel);
    public Hostel getHostel(long hostelId);
    
    public void saveRoom(Room room);
    public List<Room>getallrooms();
    public void deleteRoom(long roomId);
    public void editRoom(Room room);
    public Room getRoom(long roomId);
    public List<Room> getRoomSearch(RoomSearch roomSearch);
	//Hostler getHostler(Long hostlerId);

	
	public void saveExpense(Expense expense);
    public List<Expense> getallExpenses();
    public void deleteExpense(long expenseId);
    public void editExpense(Expense expense);
    public Expense getExpense(long expenseId);
    
    public void saveAssign(HostlerRoomMapping hostlerRoomMapping);
    public List<HostlerRoomMapping> getallAssigns();
    public void deleteAssign(long id);
    public void editAssign(HostlerRoomMapping hostlerRoomMapping);
    public HostlerRoomMapping getAssign(long id);
    
    public List<Room> getAvailableBeds();
    public List<HostlerRoomMapping> getHostlersRooms();
    
    public List<Long> getPaidHostlerIds(String fromDate,String toDate);
    public List<Hostler> getUnPaidHostlerIds(String fromDate,String toDate);
    
    public void savePayment(Payments payments);
    public List<Payments> getPaymentDetails();

}
