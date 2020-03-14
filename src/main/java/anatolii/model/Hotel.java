package anatolii.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
@Table (name = "Hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "hotelName")
    private String hotelName;
    @Column(name = "cityName")
    private String cityName;
    @OneToMany(mappedBy = "hotel")
    private List<Room> roomList;

    public Hotel(){}

    public Hotel(Long id, String hotelName, String cityName, List<Room> roomList) {
        this.id = id;
        this.hotelName = hotelName;
        this.cityName = cityName;
        this.roomList = roomList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", hotelName='" + hotelName + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return id == hotel.id &&
                Objects.equals(hotelName, hotel.hotelName) &&
                Objects.equals(cityName, hotel.cityName) &&
                Objects.equals(roomList, hotel.roomList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hotelName, cityName, roomList);
    }
}