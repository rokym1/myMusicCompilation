package hr.rokym.myMusicCompilation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="artist_detail")
public class ArtistDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id") 
 	private int id;
	
	@Column(name="web_page")
	private String webPage;
	
	@Column(name="facebook")
	private String facebook;
	
	@Column(name="instagram")
	private String instagram;

	public ArtistDetail() {
	}

	public ArtistDetail(String webPage, String facebook, String instagram) {
		this.webPage = webPage;
		this.facebook = facebook;
		this.instagram = instagram;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWebPage() {
		return webPage;
	}

	public void setWebPage(String webPage) {
		this.webPage = webPage;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	@Override
	public String toString() {
		return "ArtistDetail [id=" + id + ", webPage=" + webPage + ", facebook=" + facebook + ", instagram=" + instagram
				+ "]";
	}
	
	
}
