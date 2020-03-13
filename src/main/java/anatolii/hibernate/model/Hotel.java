package anatolii.hibernate.model;

import java.util.List;
import java.util.Objects;

public class Hotel {
    private int id;
    private String hotelName;
    private String cityName;
    private List<Room> roomList;

    public Hotel(String hotelName, String cityName, List<Room> roomList) {
        this.hotelName = hotelName;
        this.cityName = cityName;
        this.roomList = roomList;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(hotelName, hotel.hotelName) &&
                Objects.equals(cityName, hotel.cityName) &&
                Objects.equals(roomList, hotel.roomList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelName, cityName, roomList);
    }
}
