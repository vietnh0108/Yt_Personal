/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Shares")
@NamedQueries({ @NamedQuery(name = "Share.findAll", query = "SELECT s FROM Share s"),
		@NamedQuery(name = "Share.findById", query = "SELECT s FROM Share s WHERE s.id = :id"),
		@NamedQuery(name = "Share.findByEmail", query = "SELECT s FROM Share s WHERE s.email = :email"),
		@NamedQuery(name = "Share.findByShareDate", query = "SELECT s FROM Share s WHERE s.shareDate = :shareDate") })
public class Share implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer id;
	@Column(name = "Email")
	private String email;
	@Column(name = "ShareDate")
	@Temporal(TemporalType.DATE)
	private Date shareDate;
	@JoinColumn(name = "UserId", referencedColumnName = "Id")
	@ManyToOne
	private User userId;
	@JoinColumn(name = "VideoId", referencedColumnName = "Id")
	@ManyToOne
	private Video videoId;

	public Share() {
	}

	public Share(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getShareDate() {
		return shareDate;
	}

	public void setShareDate(Date shareDate) {
		this.shareDate = shareDate;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Video getVideoId() {
		return videoId;
	}

	public void setVideoId(Video videoId) {
		this.videoId = videoId;
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
		if (!(object instanceof Share)) {
			return false;
		}
		Share other = (Share) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entities.Share[ id=" + id + " ]";
	}

}
