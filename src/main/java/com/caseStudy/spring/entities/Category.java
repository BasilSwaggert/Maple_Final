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
public class Category implements Serializable{
	
	//Necessary static variable
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    private boolean status;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Tickets> ticket = new HashSet<Tickets>(0);

    public Category() {
        super();
    }

    public Category(String name, boolean status) {
        this.name = name;
        this.status = status;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

	public Set<Tickets> getTicket() {
		return ticket;
	}

	public void setTicket(Set<Tickets> ticket) {
		this.ticket = ticket;
	}
}