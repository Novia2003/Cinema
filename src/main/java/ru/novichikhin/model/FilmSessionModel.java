package ru.novichikhin.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "film_session", schema = "public", catalog = "cinema_db")
public class FilmSessionModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_session", nullable = false)
    private int idSession;
    @Basic
    @Column(name = "film_id", nullable = true)
    private Integer filmId;
    @Basic
    @Column(name = "hall_id", nullable = true)
    private Integer hallId;
    @Basic
    @Column(name = "price", nullable = true)
    private Integer price;
    @Basic
    @Column(name = "start_time", nullable = false)
    private Timestamp startTime;
    @ManyToOne
    @JoinColumn(/*name = "film_id",*/ referencedColumnName = "id_film")
    private FilmModel filmByFilmId;
    @ManyToOne
    @JoinColumn(/*name = "hall_id",*/ referencedColumnName = "hall_number")
    private HallModel hallByHallId;
    @OneToMany(mappedBy = "filmSessionBySessionId")
    private Collection<TicketModel> ticketsByIdSession;

    public int getIdSession() {
        return idSession;
    }

    public void setIdSession(int idSession) {
        this.idSession = idSession;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmSessionModel that = (FilmSessionModel) o;
        return idSession == that.idSession && Objects.equals(filmId, that.filmId) && Objects.equals(hallId, that.hallId) && Objects.equals(price, that.price) && Objects.equals(startTime, that.startTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSession, filmId, hallId, price, startTime);
    }

    public FilmModel getFilmByFilmId() {
        return filmByFilmId;
    }

    public void setFilmByFilmId(FilmModel filmByFilmId) {
        this.filmByFilmId = filmByFilmId;
    }

    public HallModel getHallByHallId() {
        return hallByHallId;
    }

    public void setHallByHallId(HallModel hallByHallId) {
        this.hallByHallId = hallByHallId;
    }

    public Collection<TicketModel> getTicketsByIdSession() {
        return ticketsByIdSession;
    }

    public void setTicketsByIdSession(Collection<TicketModel> ticketsByIdSession) {
        this.ticketsByIdSession = ticketsByIdSession;
    }
}
