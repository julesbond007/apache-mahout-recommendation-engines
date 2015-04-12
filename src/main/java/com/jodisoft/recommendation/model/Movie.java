package com.jodisoft.recommendation.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.jodisoft.recommendation.model.enums.MovieGenre;

/**
 * Movie entity for hibernate database persistence. Movie details can be fetched
 * from the IMDB API with a rest call like this:
 *
 * http://www.omdbapi.com/?t=planes
 *
 * @author Jay Paulynice
 */
@Entity(name = "items")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Integer id;

    @Column(name = "imdb_id")
    private String imdb_id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private MovieGenre genre;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "taste_item_similarity", joinColumns = { @JoinColumn(
            name = "item_id_a") }, inverseJoinColumns = { @JoinColumn(
            name = "item_id_b") })
    private Set<Movie> similarMovies;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the genre
     */
    public MovieGenre getGenre() {
        return genre;
    }

    /**
     * @param name the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(final MovieGenre genre) {
        this.genre = genre;
    }

    /**
     * @return the imdb_id
     */
    public String getImdb_id() {
        return imdb_id;
    }

    /**
     * @param imdb_id the imdb_id to set
     */
    public void setImdb_id(final String imdb_id) {
        this.imdb_id = imdb_id;
    }

    /**
     * @return the similarMovies
     */
    public Set<Movie> getSimilarMovies() {
        return similarMovies;
    }

    /**
     * @param similarMovies the similarMovies to set
     */
    public void setSimilarMovies(final Set<Movie> similarMovies) {
        this.similarMovies = similarMovies;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((imdb_id == null) ? 0 : imdb_id.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Movie other = (Movie) obj;
        if (imdb_id == null) {
            if (other.imdb_id != null)
                return false;
        } else if (!imdb_id.equals(other.imdb_id))
            return false;
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Movie [id=" + id + ", imdb_id=" + imdb_id + ", name=" + name
                + ", genre=" + genre + "]";
    }
}
