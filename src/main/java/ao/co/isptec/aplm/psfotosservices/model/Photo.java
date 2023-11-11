/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.co.isptec.aplm.psfotosservices.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable=false, unique=true)
    private String url;
    
    @ManyToOne
    private Slice slices;

    public Photo() {
    }

    public Photo(int id, String url, Slice slices) {
        this.id = id;
        this.url = url;
        this.slices = slices;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Slice getSlice_id() {
        return slices;
    }

    public void setSlice_id(Slice slices) {
        this.slices = slices;
    }
    
    
    
}
