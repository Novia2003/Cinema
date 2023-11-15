package ru.novichikhin.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ticket", schema = "public", catalog = "cinema_db")
public class TicketModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_ticket", nullable = false)
    private int idTicket;
    @Basic
    @Column(name = "client_id", nullable = true)
    private Integer clientId;
    @Basic
    @Column(name = "session_id", nullable = true)
    private Integer sessionId;
    @Basic
    @Column(name = "line_number", nullable = true)
    private Integer lineNumber;
    @Basic
    @Column(name = "seat_number", nullable = true)
    private Integer seatNumber;
    @ManyToOne
    @JoinColumn(/*name = "client_id",*/ referencedColumnName = "id_client")
    private ClientModel clientByClientId;
    @ManyToOne
    @JoinColumn(/*name = "session_id",*/ referencedColumnName = "id_session")
    private FilmSessionModel filmSessionBySessionId;

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketModel that = (TicketModel) o;
        return idTicket == that.idTicket && Objects.equals(clientId, that.clientId) && Objects.equals(sessionId, that.sessionId) && Objects.equals(lineNumber, that.lineNumber) && Objects.equals(seatNumber, that.seatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTicket, clientId, sessionId, lineNumber, seatNumber);
    }

    public ClientModel getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(ClientModel clientByClientId) {
        this.clientByClientId = clientByClientId;
    }

    public FilmSessionModel getFilmSessionBySessionId() {
        return filmSessionBySessionId;
    }

    public void setFilmSessionBySessionId(FilmSessionModel filmSessionBySessionId) {
        this.filmSessionBySessionId = filmSessionBySessionId;
    }
}
