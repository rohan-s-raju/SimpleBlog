package com.rohan.blog.entity;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.rohan.blog.common.entity.BaseDO;


/**
 * The persistent class for the ROLE database table.
 * 
 */
@Entity
public class Role extends BaseDO {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="RoleSeq")
	@SequenceGenerator(name="RoleSeq",sequenceName="ROLE_SEQ")
	@Column(name="ROLE_ID")
	private long roleId;

	private String name;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="role")
	private Set<Person> persons;

    public Role() {
    }

	public long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}
	
}