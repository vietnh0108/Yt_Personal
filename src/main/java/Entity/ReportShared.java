package Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReportShared implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Serializable group;
	private String nameSender;
	private String emailSender;
	private String emailReceive;
	private Date dateShare;
	
	

	public String getNameSender() {
		return nameSender;
	}

	public void setNameSender(String nameSender) {
		this.nameSender = nameSender;
	}

	public ReportShared(Serializable group, String nameSender, String emailSender, String emailReceive,
			Date dateShare) {
		this.group = group;
		this.nameSender = nameSender;
		this.emailSender = emailSender;
		this.emailReceive = emailReceive;
		this.dateShare = dateShare;
	}

	public ReportShared() {
		super();
	}

	

	public Serializable getGroup() {
		return group;
	}

	public void setGroup(Serializable group) {
		this.group = group;
	}

	public String getEmailSender() {
		return emailSender;
	}

	public void setEmailSender(String emailSender) {
		this.emailSender = emailSender;
	}

	public String getEmailReceive() {
		return emailReceive;
	}

	public void setEmailReceive(String emailReceive) {
		this.emailReceive = emailReceive;
	}

	public Date getDateShare() {
		return dateShare;
	}

	public void setDateShare(Date dateShare) {
		this.dateShare = dateShare;
	}
	
	
	
	
}
