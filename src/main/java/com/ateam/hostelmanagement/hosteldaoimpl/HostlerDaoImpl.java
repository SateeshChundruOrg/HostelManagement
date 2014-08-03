package com.ateam.hostelmanagement.hosteldaoimpl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ateam.hostelmanagement.bean.HostlerRoomMapping;
import com.ateam.hostelmanagement.bean.Expense;
import com.ateam.hostelmanagement.bean.Hostel;
import com.ateam.hostelmanagement.bean.Hostler;
import com.ateam.hostelmanagement.bean.Payments;
import com.ateam.hostelmanagement.bean.Room;
import com.ateam.hostelmanagement.hosteldao.HostlerDao;
import com.ateam.hostelmanagement.settings.Sqls;
import com.ateam.hostelmanagement.util.Api;
import com.mysql.jdbc.Statement;
@Repository
public class HostlerDaoImpl implements HostlerDao {

	Configuration cofig;
	@Autowired
	private JdbcTemplate jdbcTemplet;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveHostler(final Hostler hostler) {
		
		Session session=sessionFactory.getCurrentSession();
		session.save(hostler);
		
		
		
//		KeyHolder keyholder=new GeneratedKeyHolder();
//		
//		int update=jdbcTemplet.update(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con)
//					throws SQLException {
//			
//				
//				PreparedStatement ps = con.prepareStatement(Sqls.INSERT_HOSTLER, Statement.RETURN_GENERATED_KEYS);
//				ps.setString(1, hostler.getName());
//				ps.setString(2, hostler.getFirstName());
//				ps.setString(3, hostler.getLastName());
//				ps.setString(4, hostler.getAge());
//				ps.setString(5, hostler.getSex());
//				ps.setString(6, hostler.getQualification());
//				ps.setString(7, hostler.getDateOfJoining());
//				ps.setString(8, hostler.getMobileNumber());
//				ps.setString(9, hostler.getAddress());
//				
//				return ps;
//			}
//		},keyholder);
		long key=hostler.getHostlerId();
		
	}
	public List<Hostler> getallhostlers() {
		
		List<Hostler> hostlers=jdbcTemplet.query(Sqls.SELECT_HOSTLERS,new Object[]{},new BeanPropertyRowMapper<Hostler>(Hostler.class));
		return hostlers;
	}
	@Override
	public void deleteHostler(long hostlerId) {
		
		jdbcTemplet.update(Sqls.DELETE_HOSTLER,new Object[]{hostlerId});
		
	}
	@Override
	public void editHostler(Hostler hostler) {
		
		jdbcTemplet.update(Sqls.UPDATE_HOSTLER,new Object[]{hostler.getName(),hostler.getFirstName(),hostler.getLastName(),hostler.getAge(),hostler.getSex(),hostler.getQualification(),hostler.getDateOfJoining(),hostler.getMobileNumber(),hostler.getAddress(),hostler.getHostlerId()});
		
	}
	@Override
	public Hostler getHostler(long hostlerId) {
		
		return jdbcTemplet.queryForObject(Sqls.SELECT_HOSTLER, new Object[]{hostlerId},new BeanPropertyRowMapper<Hostler>(Hostler.class));
		
	}
	
	@Override
	public void saveHostel(final Hostel hostel) {
		
		
		KeyHolder keyHolder=new GeneratedKeyHolder();
		int update=jdbcTemplet.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				
				PreparedStatement ps1=con.prepareStatement(Sqls.INSERT_HOSTEL,Statement.RETURN_GENERATED_KEYS);
				ps1.setString(1,(String) hostel.getHostelName());
				ps1.setString(2, hostel.getHostelAddress());
				return ps1;
			}
		},keyHolder);
		
	}
	@Override
	public List<Hostel> getallhostels() {
		
		List<Hostel> hostels=jdbcTemplet.query(Sqls.SELECT_HOSTELS,new Object[]{},new BeanPropertyRowMapper<Hostel>(Hostel.class));
		return hostels;
	}
	@Override
	public void deleteHostel(long hostelId) {
		
		jdbcTemplet.update(Sqls.DELETE_HOSTEL, new Object[]{hostelId});
	}
	@Override
	public void editHostel(Hostel hostel) {
		
		jdbcTemplet.update(Sqls.UPDATE_HOSTEL,new Object[]{hostel.getHostelName(),hostel.getHostelAddress(),hostel.getHostelId()});
	}
	@Override
	public Hostel getHostel(long hostelId) {
		
		return jdbcTemplet.queryForObject(Sqls.SELECT_HOSTEL,new Object[]{hostelId},new BeanPropertyRowMapper<Hostel>(Hostel.class));
	}
	@Override
	public void saveRoom(final Room room) {
		
		KeyHolder keyHolder=new GeneratedKeyHolder();
		
		int update=jdbcTemplet.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				
				PreparedStatement ps2=con.prepareStatement(Sqls.INSERT_ROOM,Statement.RETURN_GENERATED_KEYS);
				ps2.setString(1,room.getRoomNumber());
				ps2.setString(2, room.getNoOfBeds());
				ps2.setString(3,room.getHostelId());
				return ps2;
			}
		}, keyHolder);
		
	}
	@Override
	public List<Room> getallrooms() {
		
		List<Room> rooms=jdbcTemplet.query(Sqls.SELECT_ROOMS,new Object[]{},new BeanPropertyRowMapper<Room>(Room.class));
		return rooms;
	}
	@Override
	public void deleteRoom(long roomId) {
		
		jdbcTemplet.update(Sqls.DELETE_ROOM,new Object[]{roomId});
		
	}
	@Override
	public void editRoom(Room room) {
		
		jdbcTemplet.update(Sqls.UPDATE_ROOM,new Object[]{room.getRoomNumber(),room.getNoOfBeds(),room.getHostelId(),room.getRoomId()});
		
	}
	@Override
	public Room getRoom(long roomId) {
		
		return jdbcTemplet.queryForObject(Sqls.SELECT_ROOM,new Object[]{roomId},new BeanPropertyRowMapper<Room>(Room.class));
	}

	
	@Override
	public void saveExpense(final Expense expense) {
		
		KeyHolder keyHolder=new GeneratedKeyHolder();
		int update=jdbcTemplet.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				
				PreparedStatement ps3=arg0.prepareStatement(Sqls.INSERT_EXPENSE,Statement.RETURN_GENERATED_KEYS);
				ps3.setString(1, expense.getExpense());
				ps3.setString(2,expense.getAmount());
				ps3.setString(3,expense.getDate());
				return ps3;
			}
		},keyHolder);
	}
	
	@Override
	public List<Expense> getallExpenses() {
		
		List<Expense> expense=  jdbcTemplet.query(Sqls.SELECT_EXPENSES, new Object[]{},new BeanPropertyRowMapper<Expense>(Expense.class));
	    return  expense;
	}
	@Override
	public void deleteExpense(long expenseId) {
		
		jdbcTemplet.update(Sqls.DELETE_EXPENSE,new Object[]{expenseId});
	}
	@Override
	public void editExpense(Expense expense) {
		
	jdbcTemplet.update(Sqls.UPDATE_EXPENSE,new Object[]{expense.getExpense(),expense.getAmount(),expense.getDate(),expense.getExpenseId()});	
	}
	@Override
	public Expense getExpense(long expenseId) {
		
		return jdbcTemplet.queryForObject(Sqls.SELECT_EXPENSE, new Object[]{expenseId},new BeanPropertyRowMapper<Expense>(Expense.class));
	}
	@Override
	public void saveAssign(final HostlerRoomMapping hostlerRoomMapping) {
		
		KeyHolder keyHolder=new GeneratedKeyHolder();
		int update=jdbcTemplet.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				
				PreparedStatement ps=arg0.prepareStatement(Sqls.INSERT_ASSIGN,Statement.RETURN_GENERATED_KEYS);
				ps.setLong(1, hostlerRoomMapping.getRoomId());
				ps.setLong(2, hostlerRoomMapping.getHostlerId());
				ps.setString(3, hostlerRoomMapping.getDateOfJoining());
				return ps;
			}
		},keyHolder);
		
	}
	@Override
	public List<HostlerRoomMapping> getallAssigns() {
		
		List<HostlerRoomMapping> hostlerRoomMapping=jdbcTemplet.query(Sqls.SELECT_ASSIGNS,new Object[]{},new BeanPropertyRowMapper<HostlerRoomMapping>(HostlerRoomMapping.class));
		return hostlerRoomMapping;
	}
	@Override
	public void deleteAssign(long id) {
		
		jdbcTemplet.update(Sqls.DELETE_ASSIGN,new Object[]{id});
	}
	@Override
	public void editAssign(HostlerRoomMapping hostlerRoomMapping) {
		
	jdbcTemplet.update(Sqls.UPDATE_ASSIGN,new Object[]{hostlerRoomMapping.getRoomId(),hostlerRoomMapping.getHostlerId(),hostlerRoomMapping.getDateOfJoining(),hostlerRoomMapping.getHostlerId()});	
	}
	@Override
	public HostlerRoomMapping getAssign(long id) {
		
		try
		{
		return  jdbcTemplet.queryForObject(Sqls.SELECT_ASSIGN, new Object[]{id},new BeanPropertyRowMapper<HostlerRoomMapping>(HostlerRoomMapping.class));
	}
		catch(Exception e)
		{
			return null;
		}
		}
	
	@Override
	public List<Room> getAvailableBeds() {
		
		List<Room> beds=jdbcTemplet.query(Sqls.SELECT_ROOM_BEDS_AVAILABLE,new Object[]{},new BeanPropertyRowMapper<Room>(Room.class));
		return beds;
	}
	@Override
	public List<HostlerRoomMapping> getHostlersRooms() {
		
		List<HostlerRoomMapping> hostlersRooms=jdbcTemplet.query(Sqls.SELECT_HOSTLER_ROOM,new Object[]{},new BeanPropertyRowMapper<HostlerRoomMapping>(HostlerRoomMapping.class));
		
		return hostlersRooms;
	}
	@Override
	public List<Long> getPaidHostlerIds(String fromDate, String toDate) {
		List<Long> listOfPaidHostlerIds=jdbcTemplet.queryForList(Sqls.SELECT_PAID_HOSTLERID,new Object[]{fromDate,toDate},Long.class);
	   return listOfPaidHostlerIds;
	}
	@Override
	public List<Hostler> getUnPaidHostlerIds(String fromDate, String toDate) {
		List<Long> listOfPaidHostlerIds=getPaidHostlerIds(fromDate, toDate);
		String csvListOfPaidHostlerIds=Api.toCSV(listOfPaidHostlerIds);
		String sql=Sqls.SELECT_UNPAID_HOSTLERID;
		if(!Api.isEmptyString(csvListOfPaidHostlerIds)){
			sql=sql.replace(":extraCondition", "AND hr.hostlerId NOT IN ("+csvListOfPaidHostlerIds+")");
			
		}else{
			sql=sql.replace(":extraCondition", "");
		}
		
		List<Hostler> unpaidHostlers=jdbcTemplet.query(sql,new  Object[]{fromDate,fromDate,fromDate,fromDate,fromDate,toDate},new BeanPropertyRowMapper<Hostler>(Hostler.class));
		return unpaidHostlers;
	}
	@Override
	public void savePayment(final Payments payments) {
		
		KeyHolder keyHolder= new GeneratedKeyHolder();
		int update=jdbcTemplet.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement ps=arg0.prepareStatement(Sqls.INSERT_PAYMENT,Statement.RETURN_GENERATED_KEYS);
				ps.setLong(1, payments.getPaymentId());
				ps.setString(2, payments.getActualAmount());
				ps.setString(3,payments.getPaidAmount());
				ps.setString(4, payments.getActualDate());
				ps.setString(5,payments.getPaidDate());
				ps.setLong(6,payments.getHostlerId());
				return ps;
			}
		},keyHolder);
		
	}
	@Override
	public List<Payments> getPaymentDetails() {
	
		List<Payments> payments=jdbcTemplet.query(Sqls.SELECT_PAYMENTS,new Object[]{},new BeanPropertyRowMapper<Payments>(Payments.class));
		return payments;
	}
	@Override
	public BigDecimal getSpent(String startDate, String endDate) {
		return jdbcTemplet.queryForObject(Sqls.SELECT_SPENT,new Object[]{startDate,endDate},BigDecimal.class);
	}
	@Override
	public BigDecimal getReceived(String startDate, String endDate) {
		return jdbcTemplet.queryForObject(Sqls.SELECT_RECIEVED,new Object[]{startDate,endDate},BigDecimal.class);
	}
	
	
	
	

}
