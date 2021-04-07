package com.caseStudy.spring.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Status implements Serializable {
	
	//Necessary static variable
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    private boolean display;
    private String color;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Tickets> tickets = new HashSet<Tickets>(0);

    public Status() {
        super();
    }

    public Status(String name, boolean display, String color) {
        this.name = name;
        this.display = display;
        this.color = color;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

	public Set<Tickets> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Tickets> tickets) {
		this.tickets = tickets;
	}
}