package co.com.certification.serenitydemo.models;

public class MeetingDataModel {

    private String businessUnits;
    private String businessMeeting;
    private String meetingType;
    private String meetingNumber;
    private String location;
    private String organizedBy;


    public String getBusinessUnits() {
        return businessUnits;
    }

    public void setBusinessUnits(String businessUnits) {
        this.businessUnits = businessUnits;
    }

    public String getBusinessMeeting() {
        return businessMeeting;
    }

    public void setBusinessMeeting(String businessMeeting) {
        this.businessMeeting = businessMeeting;
    }

    public String getMeetingType() {
        return meetingType;
    }

    public void setMeetingType(String meetingType) {
        this.meetingType = meetingType;
    }

    public String getMeetingNumber() {
        return meetingNumber;
    }

    public void setMeetingNumber(String meetingNumber) {
        this.meetingNumber = meetingNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrganizedBy() {
        return organizedBy;
    }

    public void setOrganizedBy(String organizedBy) {
        this.organizedBy = organizedBy;
    }
}
