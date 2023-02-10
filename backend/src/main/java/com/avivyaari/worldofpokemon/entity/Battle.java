package com.avivyaari.worldofpokemon.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
public class Battle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Trainer trainer1;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Trainer trainer2;
    @ManyToOne
    private Trainer winner;
    @CreationTimestamp
    @Column(nullable = false)
    private Date date;

    public Battle() {
    }

    public Battle(Trainer trainer1, Trainer trainer2, Trainer winner) {
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
        this.winner = winner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trainer getTrainer1() {
        return trainer1;
    }

    public void setTrainer1(Trainer trainer1) {
        this.trainer1 = trainer1;
    }

    public Trainer getTrainer2() {
        return trainer2;
    }

    public void setTrainer2(Trainer trainer2) {
        this.trainer2 = trainer2;
    }

    public Trainer getWinner() {
        return winner;
    }

    public void setWinner(Trainer winner) {
        this.winner = winner;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
