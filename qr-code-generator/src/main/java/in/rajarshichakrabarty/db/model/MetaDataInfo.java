package in.rajarshichakrabarty.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "METADATA_INFO")
public class MetaDataInfo extends DBEntity {

	private static final long serialVersionUID = -6615810984837759111L;

	@Id
	@Column(name = "MDI_ID")
	private int id;

	@Column(name = "MDI_IP")
	private String ip;

	@Column(name = "MDI_TYPE_OF_BROWSER")
	private String typeOfBrowser;

	@Column(name = "MDI_REGION")
	private String region;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getTypeOfBrowser() {
		return typeOfBrowser;
	}

	public void setTypeOfBrowser(String typeOfBrowser) {
		this.typeOfBrowser = typeOfBrowser;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}
