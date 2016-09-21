package in.rajarshichakrabarty.db.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "URL_TO_QR_CODE")
public class QrCodeImage extends DBEntity {

	private static final long serialVersionUID = -8488453945313301177L;

	@Id
	@Column(name = "UTQC_ID")
	private int id;

	@Column(name = "UTQC_URL")
	private String url;

	@Lob
	@Column(name = "UTQC_CODE_IMAGE")
	private String codeImage;

	@Column(name = "UTQC_CREATED_DT")
	private Date createdDt;

	@Column(name = "UTQC_LAST_USED_DT")
	private Date recentUsedDt;

	@Version
	@Column(name = "UTQC_USED_COUNTER")
	private int version;

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

	public String getCodeImage() {
		return codeImage;
	}

	public void setCodeImage(String codeImage) {
		this.codeImage = codeImage;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public Date getRecentUsedDt() {
		return recentUsedDt;
	}

	public void setRecentUsedDt(Date recentUsedDt) {
		this.recentUsedDt = recentUsedDt;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
