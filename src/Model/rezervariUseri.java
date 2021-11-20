package Model;

import java.sql.Date;

public class rezervariUseri {
    private int id;
    private String username;
    private int sala;
    private String film;
    private Date data;

    public rezervariUseri() {
    }

    public rezervariUseri(int id, String username, int sala, String film, Date data) {
        this.id = id;
        this.username = username;
        this.sala = sala;
        this.film = film;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "rezervariUseri{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sala=" + sala +
                ", film='" + film + '\'' +
                ", data=" + data +
                '}';
    }
}
