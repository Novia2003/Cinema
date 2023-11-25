package ru.novichikhin.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "film_session", schema = "public", catalog = "cinema_db")
public class FilmSessionModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_session", nullable = false)
    private int idSession;
/*
    @Basic
    @Column(name = "film_id", nullable = true)
    private Integer filmId;
    @Basic
    @Column(name = "hall_id", nullable = true)
    private Integer hallId;
*/

    @ManyToOne
    @JoinColumn(name = "film_id")
    private FilmModel filmById;
    @ManyToOne
    @JoinColumn(name = "hall_id")
    private HallModel hallById;
    @Basic
    @Column(name = "price", nullable = true)
    private Integer price;
    @Basic
    @Column(name = "start_time", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime startTime;
//    @ManyToOne
//    @JoinColumn(name = "film_id" /* referencedColumnName = "id_film"*/)
//    private FilmModel filmByFilmId;
//    @ManyToOne
//    @JoinColumn(/*name = "hall_id",*/ referencedColumnName = "hall_number")
//    private HallModel hallByHallId;
    @OneToMany(mappedBy = "sessionById")
    private Collection<TicketModel> ticketsByIdSession;

    public int getIdSession() {
        return idSession;
    }

    public void setIdSession(int idSession) {
        this.idSession = idSession;
    }

//    public Integer getFilmId() {
//        return filmId;
//    }
//
//    public void setFilmId(Integer filmById) {
//        this.filmId = filmId;
//    }
//
//    public Integer getHallById() {
//        return hallId;
//    }
//
//    public void setHallById(Integer hallById) {
//        this.hallById = hallId;
//    }

    @Override
    public String toString() {
        return "FilmSessionModel{" +
                "idSession=" + idSession +
                ", filmById=" + filmById +
                ", hallById=" + hallById +
                ", price=" + price +
                ", startTime=" + startTime +
                ", ticketsByIdSession=" + ticketsByIdSession +
                '}';
    }

    public FilmModel getFilmById() {
        return filmById;
    }

    public void setFilmById(FilmModel filmById) {
        this.filmById = filmById;
    }

    public HallModel getHallById() {
        return hallById;
    }

    public void setHallById(HallModel hallById) {
        this.hallById = hallById;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmSessionModel that = (FilmSessionModel) o;
        return idSession == that.idSession && Objects.equals(filmById, that.filmById) && Objects.equals(hallById, that.hallById) && Objects.equals(price, that.price) && Objects.equals(startTime, that.startTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSession, filmById, hallById, price, startTime);
    }

//    public FilmModel getFilmByFilmId() {
//        return filmByFilmId;
//    }
//
//    public void setFilmByFilmId(FilmModel filmByFilmId) {
//        this.filmByFilmId = filmByFilmId;
//    }
//
//    public HallModel getHallByHallId() {
//        return hallByHallId;
//    }
//
//    public void setHallByHallId(HallModel hallByHallId) {
//        this.hallByHallId = hallByHallId;
//    }

    public Collection<TicketModel> getTicketsByIdSession() {
        return ticketsByIdSession;
    }

    public void setTicketsByIdSession(Collection<TicketModel> ticketsByIdSession) {
        this.ticketsByIdSession = ticketsByIdSession;
    }
}
