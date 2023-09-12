/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Videos")
@NamedQueries({
    @NamedQuery(name = "Video.findAll", query = "SELECT v FROM Video v")
    , @NamedQuery(name = "Video.findById", query = "SELECT v FROM Video v WHERE v.id = :id")
    , @NamedQuery(name = "Video.findByTitle", query = "SELECT v FROM Video v WHERE v.title LIKE :title")
    , @NamedQuery(name = "Video.findByPoster", query = "SELECT v FROM Video v WHERE v.poster = :poster")
    , @NamedQuery(name = "Video.findByViews", query = "SELECT v FROM Video v WHERE v.views = :views")
    , @NamedQuery(name = "Video.findByDescription", query = "SELECT v FROM Video v WHERE v.description = :description")
    , @NamedQuery(name = "Video.findByActive", query = "SELECT v FROM Video v WHERE v.active = :active")
    , @NamedQuery(name = "Video.findByUser", query = "SELECT f.videoId FROM Favorite f WHERE f.userId.id = :userid")})
public class Video implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private String id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Poster")
    private String poster;
    @Column(name = "Views")
    private Integer views = 0;
    @Column(name = "Description")
    private String description;
    @Column(name = "Active")
    private Boolean active;
    @OneToMany(mappedBy = "videoId")
    private Collection<Favorite> favoriteCollection;
    @OneToMany(mappedBy = "videoId")
    private Collection<Share> shareCollection;

    public Video() {
    }

    public Video(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Collection<Favorite> getFavoriteCollection() {
        return favoriteCollection;
    }

    public void setFavoriteCollection(Collection<Favorite> favoriteCollection) {
        this.favoriteCollection = favoriteCollection;
    }

    public Collection<Share> getShareCollection() {
        return shareCollection;
    }

    public void setShareCollection(Collection<Share> shareCollection) {
        this.shareCollection = shareCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Video)) {
            return false;
        }
        Video other = (Video) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Video[ id=" + id + " ]";
    }
    
}
