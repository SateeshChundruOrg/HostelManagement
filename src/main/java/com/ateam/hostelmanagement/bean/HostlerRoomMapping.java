package com.ateam.hostelmanagement.bean;

public class HostlerRoomMapping {
	
	private String id;
	private long roomId;
	private long hostlerId;
	private String dateOfJoining;
	private String hostelName;
	public String getHostelName() {
		return hostelName;
	}

	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}
	private String hostlersRooms;

	public String getHostlersRooms() {
		return hostlersRooms;
	}

	public void setHostlersRooms(String hostlersRooms) {
		this.hostlersRooms = hostlersRooms;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public long getHostlerId() {
		return hostlerId;
	}
	public void setHostlerId(long hostlerId) {
		this.hostlerId = hostlerId;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
//	  @Override
//	public boolean equals(Object obj) {
//        if(obj instanceof Hostler){
//        	Hostler hostler=(Hostler)obj;
//        	return hostler.getHostlerId()==getHostlerId();
//        }else if(obj instanceof HostlerRoomMapping){
//         HostlerRoomMapping hostlerRoomMapping=(HostlerRoomMapping)obj;
//         return hostlerRoomMapping.getHostlerId()==getHostlerId();
//        }
//		  return false;
//	}
}
