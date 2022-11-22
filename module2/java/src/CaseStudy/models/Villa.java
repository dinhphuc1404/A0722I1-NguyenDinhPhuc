package CaseStudy.models;

public class Villa extends Facility{
    private String roomStandard; //phòng tiêu chuẩn
    private int numberOfFloors; //số tầng
    private String poolArea; //diện tích hồ bơi

    public Villa() {
    }


    public Villa(String name, double price, String rentalType, String usableArea, String roomStandard, int numberOfFloors, String poolArea) {
        super(name, price, rentalType, usableArea);
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
        this.poolArea = poolArea;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    @Override
    public String toString() {
        return "Villa= "+super.toString() +
                ", RoomStandard: " + roomStandard +
                ", NumberOfFloors: " + numberOfFloors +
                ", PoolArea: " + poolArea ;

    }
}
