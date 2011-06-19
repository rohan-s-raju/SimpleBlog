package com.rohan.blog.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.rohan.blog.common.entity.BaseDO;


/**
 * The persistent class for the PERSON database table.
 * 
 */
@Entity
public class Person extends BaseDO {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="PersonSeq")
	@SequenceGenerator(name="PersonSeq",sequenceName="PERSON_SEQ")
	@Column(name="PERSON_ID")
	private long personId;

	private String password;

	private String username;

	//bi-directional many-to-one association to Role
    @ManyToOne
	@JoinColumn(name="ROLE_ID")
	private Role role;

    public Person() {
    }

	public long getPersonId() {
		return this.personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}