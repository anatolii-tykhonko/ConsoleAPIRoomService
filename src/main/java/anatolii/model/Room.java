package anatolii.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "person")
    private int persons;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "availableFrom")
    private LocalDate availableFrom;
    @Column(name = "reserveBefore")
    private LocalDate reserveBefore;
    @ManyToOne
    @JoinColumn(name = "id_hotel", referencedColumnName = "id")
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    private Client client;
    @Column(name ="isAvailable")
    private boolean status;

    public Room() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(LocalDate availableFrom) {
        this.availableFrom = availableFrom;
    }

    public LocalDate getReserveBefore() {
        return reserveBefore;
    }

    public void setReserveBefore(LocalDate reserveBefore) {
        this.reserveBefore = reserveBefore;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "К-тво спальных мест: " + persons +
                ", цена: " + price +
                ", " + (status ? "забронирована с: " + availableFrom + " по " + reserveBefore : "свободна с: " + availableFrom);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return persons == room.persons &&
                status == room.status &&
                Objects.equals(price, room.price) &&
                Objects.equals(availableFrom, room.availableFrom) &&
                Objects.equals(reserveBefore, room.reserveBefore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(persons, price, hotel, availableFrom, reserveBefore, status);
    }
}
