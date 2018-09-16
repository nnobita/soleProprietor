package com.example.soleProprietor.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "notices")
public class Notice extends BaseEntity {
	
	@JsonBackReference
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    
    @Column(name = "content")
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public Owner getOwner() {
        return this.owner;
    }

    protected void setOwner(Owner owner) {
        this.owner = owner;
    }

}
