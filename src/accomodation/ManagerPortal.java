/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accomodation;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Crazydude
 */
public class ManagerPortal {
    
//   private final StringProperty leaseNumber;
//   private final StringProperty hallName;
//   private final StringProperty hallNumber;
//   private final StringProperty roomNumber;
//   private final StringProperty studentName;
//   private final StringProperty studentId;
//   private final StringProperty occupancyStatus;
//   private final StringProperty cleaningStatus;
    
  
  String id, leaseNumber, hallName, hallNumber, roomNumber, studentName, studentId,occupancyStatus, cleaningStatus;

    public ManagerPortal(String id, String leaseNumber, String hallName, String hallNumber, String roomNumber, String studentName, String studentId, String occupancyStatus, String cleaningStatus) {
        this.id = id;
        this.leaseNumber = leaseNumber;
        this.hallName = hallName;
        this.hallNumber = hallNumber;
        this.roomNumber = roomNumber;
        this.studentName = studentName;
        this.studentId = studentId;
        this.occupancyStatus = occupancyStatus;
        this.cleaningStatus = cleaningStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLeaseNumber() {
        return leaseNumber;
    }

    public void setLeaseNumber(String leaseNumber) {
        this.leaseNumber = leaseNumber;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(String hallNumber) {
        this.hallNumber = hallNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getOccupancyStatus() {
        return occupancyStatus;
    }

    public void setOccupancyStatus(String occupancyStatus) {
        this.occupancyStatus = occupancyStatus;
    }

    public String getCleaningStatus() {
        return cleaningStatus;
    }

    public void setCleaningStatus(String cleaningStatus) {
        this.cleaningStatus = cleaningStatus;
    }

    
  

   
    

    

    
    
    
    
}
   
   

//    //Default constructor
//    public ManagerPortal(String hName, String studentN, String occupancyS, String cleaningS, String studentI, String leaseN, String roomN, String hallN) {
//        this.leaseNumber = new SimpleStringProperty(leaseN);
//        this.hallName = new SimpleStringProperty(hName);
//        this.hallNumber = new SimpleStringProperty(hallN);
//        this.roomNumber = new SimpleStringProperty(roomN);
//        this.studentName = new SimpleStringProperty(studentN);
//        this.studentId = new SimpleStringProperty(studentI);
//        this.occupancyStatus = new SimpleStringProperty(occupancyS);
//        this.cleaningStatus = new SimpleStringProperty(cleaningS);
//     
//    }
//
//    //Getters
//    public String getLeaseNumber() {
//        return leaseNumber.get();
//    }
//
//    public String getHallName() {
//        return hallName.get();
//    }
//    public String getHallNo() {
//        return hallNumber.get();
//    }
//
//    public String getRoomNo() {
//        return roomNumber.get();
//    }
//    public String getStudentName() {
//        return studentName.get();
//    }
//
//    public String getStudentId() {
//        return studentId.get();
//    }
//    public String getOccupancyStatus() {
//        return occupancyStatus.get();
//    }
//
//    public String getCleaningStatus() {
//        return cleaningStatus.get();
//    }
//
//    //Setters
//    public void setLeaseNumber(String value) {
//        leaseNumber.set(value);
//    }
//
//    public void setHallNamel(String value) {
//        hallName.set(value);
//    }
//    public void setHallNo(String value) {
//        hallNumber.set(value);
//    }
//
//    public void setRoomNo(String value) {
//       roomNumber.set(value);
//    }
//    public void setStudentName(String value) {
//        studentName.set(value);
//    }
//
//    public void setStudentId(String value) {
//        studentId.set(value);
//    }
//    public void setOccupancyStatus(String value) {
//        occupancyStatus.set(value);
//    }
//
//    public void setCleaningStatus(String value) {
//       cleaningStatus.set(value);
//    }
//
//    //Property values
//    public StringProperty leaseNumberProperty() {
//        return leaseNumber;
//    }
//
//    public StringProperty hallNameProperty() {
//        return hallName;
//    }
//    public StringProperty hallNoProperty() {
//        return hallNumber;
//    }
//
//    public StringProperty roomNoProperty() {
//        return roomNumber;
//    }
//    public StringProperty studentNameProperty() {
//        return studentName;
//    }
//
//    public StringProperty studentIdProperty() {
//        return studentId;
//    }
//    public StringProperty occupancyStatusProperty() {
//        return occupancyStatus;
//    }
//
//    public StringProperty cleaningStatusProperty() {
//        return cleaningStatus;
//    }
//
//}
