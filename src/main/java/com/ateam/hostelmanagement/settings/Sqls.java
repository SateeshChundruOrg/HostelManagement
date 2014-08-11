package com.ateam.hostelmanagement.settings;

public interface Sqls {
	
	public static String INSERT_HOSTLER="insert into hostler (name, firstName, lastName, age, sex, qualification, dateOfJoining, mobileNumber, address)	values	(?, ?, ?,?, ?, ?,?, ?, ?)";
	public static String SELECT_HOSTLERS="select * from hostler WHERE deleted=0 LIMIT ?,?";
	public static String SELECT_HOSTLERS_COUNT="select count(*) from hostler WHERE deleted=0";
	public static String DELETE_HOSTLER="update hostler SET deleted=1 WHERE hostlerId=?";
	public static String UPDATE_HOSTLER="update hostler SET name=?,firstName=?,lastName=?,age=?,sex=?,qualification=?,dateOfJoining=?,mobileNumber=?,address=?  WHERE hostlerId=?";
	public static String SELECT_HOSTLER="select * from hostler WHERE hostlerId=?";
    public static String SELECT_HOSTLERS2="select * from hostler WHERE deleted=0";
	
	public static String INSERT_HOSTEL="insert into hostel (hostelName, hostelAddress)values(?,?)";
    public static String SELECT_HOSTELS="select * from hostel WHERE deleted=0 LIMIT ?,?";
    public static String DELETE_HOSTEL="update hostel SET deleted=1 WHERE hostelId=?";
    public static String SELECT_HOSTELS_COUNT="select count(*) from hostel WHERE deleted=0";
    public static String UPDATE_HOSTEL="update hostel SET hostelName=?,hostelAddress=? WHERE hostelId=?";
    public static String SELECT_HOSTEL="select * from hostel WHERE hostelId=?";

    public static String INSERT_ROOM="insert into room (roomNumber, noOfBeds,hostelId)values(?, ?,?)";
    public static String SELECT_ROOMS="select 	r.roomId, r.roomNumber, r.noOfBeds, r.hostelId,h.hostelName from room r join hostel h on(r.hostelId=h.hostelId) where r.deleted=0 LIMIT ?,?";
    public static String DELETE_ROOM="update room SET deleted=1 WHERE roomId=?";
    public static String UPDATE_ROOM="update room SET roomNumber=?,noOfBeds=?,hostelId=? WHERE roomId=?";
    public static String SELECT_ROOM="select * from room WHERE roomId=?";
    public static String SELECT_ROOMS_COUNT="select count(*) from room WHERE deleted=0"; 
   
    
    public static String INSERT_EXPENSE="insert into expense (expense,amount,date) values (?,?,?)";
    public static String SELECT_EXPENSES="select * from expense WHERE deleted=0";
    public static String DELETE_EXPENSE="update expense SET deleted=1 WHERE expenseId=?";
    public static String UPDATE_EXPENSE="update expense SET expense=?,amount=?,date=? WHERE expenseId=?";
    public static String SELECT_EXPENSE="select * from expense WHERE expenseId=?";

    //public static String JOIN_ROOM="select 	r.roomId, r.roomNumber, r.noOfBeds,r.deleted, r.hostelId,h.hostelName from room r join hostel h on(r.hostelId=h.hostelId)";
    public static String INSERT_ASSIGN="insert into RoomHostlerMapping(roomId,hostlerId,dateOfJoining)values(?,?,?)";
    public static String SELECT_ASSIGNS="select * from RoomHostlerMapping WHERE deleted=0";
    public static String DELETE_ASSIGN="update hostler h JOIN RoomHostlerMapping rhm  JOIN Payments p ON h.hostlerId=rhm.hostlerId=p.hostlerId SET rhm.deleted=1,p.deleted=1 where h.hostlerId=?";
    public static String UPDATE_ASSIGN="update RoomHostlerMapping SET roomId=?,hostlerId=?,dateOfJoining=? WHERE hostlerId=? and deleted=0";
    public static String SELECT_ASSIGN="select * from RoomHostlerMapping WHERE hostlerId=? and deleted=0";

   // public static String INSERT_PAYMENT="insert into Payments (paymentId,amount,actualDate,paidDate,hostlerId) values (?,?,?,?,?)";
    
    
    public static String SELECT_ROOM_BEDS_AVAILABLE="select roomId,roomNumber,r.deleted,r.hostelId,noOfBeds,h.hostelName,(noOfBeds-(select count(roomId) as filledcount from RoomHostlerMapping as rhmap where rhmap.deleted=0 and rhmap.roomId=r.roomId)) as availableBeds from room r join hostel h on(r.hostelId=h.hostelId)";
    public static String SELECT_HOSTLER_ROOM="select h.hostelname,rhm.roomId,rhm.hostlerId from  RoomHostlerMapping rhm join hostel h";
    public static String SELECT_PAID_HOSTLERID="SELECT `hostlerId` FROM `Payments` WHERE `actualDate` BETWEEN ? AND ? ";
    public static String SELECT_UNPAID_HOSTLERID="SELECT hr.*,rhm.`dateOfJoining`,CONCAT(YEAR(?),'-',IF(MONTH(?)<10,CONCAT('0',MONTH(?)),MONTH(?)),'-',IF(DAY(rhm.`dateOfJoining`)<10,CONCAT('0',DAY(rhm.`dateOfJoining`)),DAY(rhm.`dateOfJoining`))) AS actualDate FROM  RoomHostlerMapping rhm  INNER JOIN hostler hr  ON (`rhm`.`hostlerId`=hr.`hostlerId`) WHERE DAY(rhm.dateOfJoining) BETWEEN  DAY(?) AND DAY(?) :extraCondition";

    public static String INSERT_PAYMENT="INSERT INTO Payments (paymentId,actualAmount,paidAmount,actualDate,paidDate,hostlerId) VALUES  (?,?,?,?,?,?)" ;
    public static String SELECT_PAYMENTS="SELECT h.`name` AS hostlerName,p.* FROM hostler h JOIN Payments p ON h.`hostlerId`=p.`hostlerId` WHERE p.deleted=0";
   
    public static String SEARCH_HOSTLERS="select * from hostler :where";  
    public static String SEARCH_ROOMS="select r.roomNumber,h.hostelName,(noOfBeds-(select count(roomId) as filledcount from RoomHostlerMapping as rhmap where rhmap.deleted=0 and rhmap.roomId=r.roomId)) as availableBeds from room r join hostel h on(r.hostelId=h.hostelId) where (noOfBeds-(select count(roomId) as filledcount from RoomHostlerMapping as rhmap where rhmap.deleted=0 and rhmap.roomId=r.roomId))>=?";
    
    public static String SELECT_CURRENT_HOSTLERS="select * from RoomHostlerMapping rhm join hostler h ON rhm.hostlerId=h.hostlerId join Payments p where Day(rhm.dateOfJoining)=day(curdate()) and h.hostlerId=p.hostlerId and p.paidDate!=curdate()";

    public static String SELECT_SPENT="SELECT ifnull(sum(amount),0) as Spent FROM expense  WHERE date BETWEEN ? AND ? AND deleted=0 ";
    public static String SELECT_RECIEVED="SELECT ifnull(sum(p.paidAmount),0) from Payments p  WHERE p.paidDate BETWEEN ? AND ?  AND p.deleted=0 ";
    public static String SELECT_PAYMENT_HISTORY="select p.*,h.name as hostlerName from Payments p JOIN hostler h ON p.hostlerId=h.hostlerId where p.hostlerId=? and p.deleted=0";

}
