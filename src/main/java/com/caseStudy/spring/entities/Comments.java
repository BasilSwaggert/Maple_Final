package com.caseStudy.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

//This class is the Comments Entity and it maps to the database, this overall is not yet implemented
@Entity
public class Comments implements Serializable {
	
	//Necessary static variable
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "content", nullable = false)
    private String content;
    private Date createdDate;
    @JoinColumn(name = "ticket_id")
    private Tickets ticket_id;
    @JoinColumn(name = "user_id")
    private Users user_id;
    
    public Comments() {
        super();
    }

    public Comments(Users user, Tickets ticket_id, String content, Date createdDate) {
        this.user_id = user;
        this.ticket_id = ticket_id;
        this.content = content;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Users getAccount() {
        return user_id;
    }

    public void setAccount(Users account) {
        this.user_id = account;
    }

    public Tickets getTicket() {
        return ticket_id;
    }

    public void setTicket(Tickets ticket) {
        this.ticket_id = ticket;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}