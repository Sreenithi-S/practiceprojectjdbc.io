package com.cognizant.moviecruiser.model;

import java.util.Date;

public class Movies {

	private Long id;
	private String title;
	private Long gross;
	private Boolean active;
	private Date dateOfLaunch;
	private String genre;
	private Boolean hasTeaser;

	public Movies(Long id, String title, Long l, Boolean active, Date dateOfLaunch, String genre, Boolean hasTeaser) {
		super();
		this.id = id;
		this.title = title;
		this.gross = l;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.genre = genre;
		this.hasTeaser = hasTeaser;
	}

	public Movies() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getGross() {
		return gross;
	}

	public void setGross(Long gross) {
		this.gross = gross;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Boolean getHasTeaser() {
		return hasTeaser;
	}

	public void setHasTeaser(Boolean hasTeaser) {
		this.hasTeaser = hasTeaser;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movies other = (Movies) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (gross == null) {
			if (other.gross != null)
				return false;
		} else if (!gross.equals(other.gross))
			return false;
		if (dateOfLaunch == null) {
			if (other.dateOfLaunch != null)
				return false;
		} else if (!dateOfLaunch.equals(other.dateOfLaunch))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (hasTeaser == null) {
			if (other.hasTeaser != null)
				return false;
		} else if (!hasTeaser.equals(other.hasTeaser))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movies [id=" + id + "\t" + " title=" + title + "\t" + " gross=$" + gross + "\t" + " active=" + active
				+ "\t" + " dateOfLaunch=" + dateOfLaunch + "\t" + " genre=" + genre + "\t" + " hasTeaser=" + hasTeaser
				+ "\t" + "]";
	}

}
