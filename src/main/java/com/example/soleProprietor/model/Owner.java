package com.example.soleProprietor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "owners")
public class Owner extends NamedEntity {
    @Column(name = "status")
    private Integer status;

    public Integer getStatus() {
    	return this.status;
    }
    
    public void setStatus(Integer status) {
    	this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("id", this.getId())
            .append("new", this.isNew())
            .append("name", this.getName())
            .append("status", this.getStatus())
            .toString();
    }
}
