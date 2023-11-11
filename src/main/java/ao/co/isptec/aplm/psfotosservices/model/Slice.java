
package ao.co.isptec.aplm.psfotosservices.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name="slices")
public class Slice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable=false, unique=true)
    private String url;
    
    @ManyToOne
    private User users;
    
    @ManyToOne
    private Album albums;
    
    @OneToMany(mappedBy="slices")
    private List<Photo> photos;

    public Slice() {
    }

    public Slice(int id, String url, User user, Album album) {
        this.id = id;
        this.url = url;
        this.users = user;
        this.albums = album;
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

    public User getUser() {
        return users;
    }

    public void setUser(User user) {
        this.users = user;
    }

    public Album getAlbum() {
        return albums;
    }

    public void setAlbum(Album album) {
        this.albums = album;
    }
    
    
    
}
