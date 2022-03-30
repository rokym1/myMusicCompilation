package hr.rokym.myMusicCompilation.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, 
property = "id")
@Entity
@Table(name="artist")
public class Artist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="artist_detail_id")
	private ArtistDetail artistDetail;
	
	@OneToMany(mappedBy = "artist", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Album> albums;
	
	@OneToMany(mappedBy = "artist", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Song> songs;

	public Artist() {
	}

	public Artist(String name, ArtistDetail artistDetail) {
		this.name = name;
		this.artistDetail = artistDetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArtistDetail getArtistDetail() {
		return artistDetail;
	}

	public void setArtistDetail(ArtistDetail artistDetail) {
		this.artistDetail = artistDetail;
	}
	
	public List<Album> getAlbums() {
		return albums; 
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
	
	
	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", artistDetail=" + artistDetail + "]";
	}
	
}











