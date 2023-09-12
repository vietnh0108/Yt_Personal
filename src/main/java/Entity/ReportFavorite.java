package Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(
		name = "Report.favoriteByYear", 
		procedureName = "spFavoriteByYear", 
		resultClasses = ReportFavorite.class, parameters = {
		@StoredProcedureParameter(name = "year", type = Integer.class)}
	) 
})
public class ReportFavorite implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Serializable group;
	private Long likes;
	private Date newest;
	private Date oldest;

	public ReportFavorite() {
		super();
	}

	public ReportFavorite(Serializable group, Long likes, Date newest, Date oldest) {
		this.group = group;
		this.likes = likes;
		this.newest = newest;
		this.oldest = oldest;
	}

	public Serializable getGroup() {
		return group;
	}

	public void setGroup(Serializable group) {
		this.group = group;
	}

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}

	public Date getNewest() {
		return newest;
	}

	public void setNewest(Date newest) {
		this.newest = newest;
	}

	public Date getOldest() {
		return oldest;
	}

	public void setOldest(Date oldest) {
		this.oldest = oldest;
	}

}

