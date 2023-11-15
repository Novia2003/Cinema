package ru.novichikhin.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity(name = "client")
@Table
public class ClientModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_client", nullable = false)
    private int idClient;
    @Basic
    @Column(name = "name", nullable = true, length = 30)
    private String name;
    @Basic
    @Column(name = "birthdate", nullable = true)
    private Date birthdate;
    @OneToMany(mappedBy = "clientByClientId")
    private Collection<TicketModel> ticketsByIdClient;

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientModel that = (ClientModel) o;
        return idClient == that.idClient && Objects.equals(name, that.name) && Objects.equals(birthdate, that.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, name, birthdate);
    }

    public Collection<TicketModel> getTicketsByIdClient() {
        return ticketsByIdClient;
    }

    public void setTicketsByIdClient(Collection<TicketModel> ticketsByIdClient) {
        this.ticketsByIdClient = ticketsByIdClient;
    }
}
