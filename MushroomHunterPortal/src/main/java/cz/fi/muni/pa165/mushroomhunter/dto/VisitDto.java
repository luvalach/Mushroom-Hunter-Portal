/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.mushroomhunter.dto;

import cz.fi.muni.pa165.mushroomhunter.entity.Hunter;
import cz.fi.muni.pa165.mushroomhunter.entity.Location;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Lukáš Valach
 */
public class VisitDto {
    
    /**
     * The ID of the visit.
     */
    private Long id;
    
    /**
     * The hunter who made the visit.
     */
    private Hunter hunter;
    
    /**
     * The date when the visit was made.
     */
    private Date date;
    
    /**
     * The location where the visit was made.
     */
    private Location location;
    
    /**
     * The HashMap containing the ID's of mushrooms and their number of occurences
     * at the visit.
     */
    private Map<Long,Integer> foundMushrooms = new HashMap<Long,Integer>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hunter getHunter() {
        return hunter;
    }

    public void setHunter(Hunter hunter) {
        this.hunter = hunter;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Map<Long,Integer> getFoundMushrooms() {
        return foundMushrooms;
    }

    public void setFoundMushrooms(Map<Long,Integer> foundMushrooms) {
        this.foundMushrooms = foundMushrooms;
    }
}


