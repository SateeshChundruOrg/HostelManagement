package com.ateam.hostelmanagement.hosteldao;

import java.math.BigDecimal;
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



public interface HostlerDao {
	
	public void saveHostler(Hostler hostler);
	public List<Hostler>getallhostlers(int offset, int pageSize);
	public void deleteHostler(long hostlerId);
	public void editHostler(Hostler hostler);
	public Hostler getHostler(long hostlerId);
	public long getHostlersCount();
	public List<Hostler>getallHostlers2();

	public List<Hostler> getHostlerSearch(HostlerSearch hostlerSearch);
    public List<CurrentPayers> getCurrentHostlers();
	
	
    public void saveHostel(Hostel hostel);
    public List<Hostel>getallhostels(int offSet, int pageSize);
    public void deleteHostel(long hostelId);
    public void editHostel(Hostel hostel);
    public Hostel getHostel(long hostelId);
    public long getHostelsCount();
    
    public void saveRoom(Room room);
    public void deleteRoom(long roomId);
    public void editRoom(Room room);
    public Room getRoom(long roomId);
    public List<Room> getRoomSearch(RoomSearch roomsearch);
    public long getRoomsCount();
    public List<Room>getallrooms(int offset, int pageSize);
	
    public void saveExpense(Expense expense);
    public List<Expense> getallExpenses();
    public void deleteExpense(long expenseId);
    public void editExpense(Expense expense);
    public Expense getExpense(long expenseId);
    
    public void saveAssign(HostlerRoomMapping assign);
    public List<HostlerRoomMapping> getallAssigns();
    public void deleteAssign(long hostlerId);
    public void editAssign(HostlerRoomMapping assign);
    public HostlerRoomMapping getAssign(long id);
    
    public List<Room> getAvailableBeds();

    public List<HostlerRoomMapping> getHostlersRooms();
    
    public List<Long> getPaidHostlerIds(String fromDate,String toDate);
    public List<Hostler> getUnPaidHostlerIds(String fromDate,String toDate);
    
    public void savePayment(Payments payments);
    public List<Payments> getPaymentDetails();
    
    public List<Payments> getPaymentHistory(long hostlerId);
    
    public BigDecimal getSpent(String startDate,String endDate);
    public BigDecimal getReceived(String startDate,String endDate);
	
}
