package com.ans.indoornavigation.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "building")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;
    //    private List<Position> entrances;
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "building")
    private List<Level> levels;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User admin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    //NOTE:: relations functions
    public void addLevel(Level level){
        if(levels == null)
            levels = new ArrayList<>();
        levels.add(level);
        level.setBuilding(this);
    }
}
