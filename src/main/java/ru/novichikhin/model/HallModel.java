package ru.novichikhin.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "hall", schema = "public", catalog = "cinema_db")
public class HallModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "hall_number", nullable = false)
    private int hallNumber;
    @Basic
    @Column(name = "number_rows", nullable = true)
    private Integer numberRows;
    @Basic
    @Column(name = "number_seats_in_row", nullable = true)
    private Integer numberSeatsInRow;
    @OneToMany(mappedBy = "hallById")
    private Collection<FilmSessionModel> filmSessionsByHallNumber;

    public int getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    public Integer getNumberRows() {
        return numberRows;
    }

    public void setNumberRows(Integer numberRows) {
        this.numberRows = numberRows;
    }

    public Integer getNumberSeatsInRow() {
        return numberSeatsInRow;
    }

    public void setNumberSeatsInRow(Integer numberSeatsInRow) {
        this.numberSeatsInRow = numberSeatsInRow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HallModel hallModel = (HallModel) o;
        return hallNumber == hallModel.hallNumber && Objects.equals(numberRows, hallModel.numberRows) && Objects.equals(numberSeatsInRow, hallModel.numberSeatsInRow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hallNumber, numberRows, numberSeatsInRow);
    }

    public Collection<FilmSessionModel> getFilmSessionsByHallNumber() {
        return filmSessionsByHallNumber;
    }

    public void setFilmSessionsByHallNumber(Collection<FilmSessionModel> filmSessionsByHallNumber) {
        this.filmSessionsByHallNumber = filmSessionsByHallNumber;
    }
}
