package ru.novichikhin.model;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Collection;
import java.util.Objects;

@Entity(name = "film")
@Table
public class FilmModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_film", nullable = false)
    private int idFilm;
    @Basic
    @Column(name = "film_name", nullable = false, length = 30)
    private String filmName;
    @Basic
    @Column(name = "age_restriction", nullable = true)
    private Integer ageRestriction;
    @Basic
    @Column(name = "duration", nullable = true)
    private int duration;
    @Basic
    @Column(name = "genre", nullable = false, length = 30)
    private String genre;
    @OneToMany(mappedBy = "filmByFilmId")
    private Collection<FilmSessionModel> filmSessionsByIdFilm;

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Integer getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(Integer ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmModel filmModel = (FilmModel) o;
        return idFilm == filmModel.idFilm && Objects.equals(filmName, filmModel.filmName) && Objects.equals(ageRestriction, filmModel.ageRestriction) && Objects.equals(duration, filmModel.duration) && Objects.equals(genre, filmModel.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFilm, filmName, ageRestriction, duration, genre);
    }

    public Collection<FilmSessionModel> getFilmSessionsByIdFilm() {
        return filmSessionsByIdFilm;
    }

    public void setFilmSessionsByIdFilm(Collection<FilmSessionModel> filmSessionsByIdFilm) {
        this.filmSessionsByIdFilm = filmSessionsByIdFilm;
    }
}
