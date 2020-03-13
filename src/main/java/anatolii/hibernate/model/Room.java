package anatolii.hibernate.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Room {
    private int id;
    private int persons;
    private BigDecimal price;
    private LocalDate availableFrom;
    private LocalDate reserveBefore;
    private boolean status;

    public Room(int persons, BigDecimal price, LocalDate availableFrom) {
        this.persons = persons;
        this.price = price;
        this.availableFrom = availableFrom;
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

    @Override
    public String toString() {
        return "К-тво спальных мест: " + persons +
                ", цена: " + price +
                ", " + (status?"забронирована с: "+availableFrom+" по "+ reserveBefore : "свободна с: "+availableFrom);

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
        return Objects.hash(persons, price, availableFrom, reserveBefore, status);
    }
}
