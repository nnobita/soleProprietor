package com.example.soleProprietor.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "owners")
public class Owner extends NamedEntity {
    @Column(name = "status")
    @NotEmpty
    private Integer status;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Notice> notices;

    public Integer getStatus() {
    	return this.status;
    }
    
    public void setStatus(Integer status) {
    	this.status = status;
    }

    protected Set<Notice> getNoticesInternal() {
        if (this.notices == null) {
            this.notices = new HashSet<>();
        }
        return this.notices;
    }

    protected void setNoticesInternal(Set<Notice> notices) {
        this.notices = notices;
    }

    public List<Notice> getNotices() {
        List<Notice> sortedNotices = new ArrayList<>(getNoticesInternal());
        PropertyComparator.sort(sortedNotices, new MutableSortDefinition("lastUpdate", true, true));
        return Collections.unmodifiableList(sortedNotices);
    }

    public void addNotice(Notice notice) {
        getNoticesInternal().add(notice);
        notice.setOwner(this);
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
