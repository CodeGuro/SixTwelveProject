package resources;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery( name = "User.findAll", query = "SELECT u FROM User u" )
public class User implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int userid;

	private String birth;

	private String email;

	private String firstname;

	private String lastname;

	private String password;

	private String username;

	// bi-directional many-to-one association to Address
	@ManyToOne( cascade = { CascadeType.ALL } )
	private Address address;

	// bi-directional many-to-many association to Group
	@ManyToMany( cascade = { CascadeType.PERSIST, CascadeType.MERGE,
		CascadeType.REFRESH } )
	@JoinTable( name = "user_has_groups", joinColumns = { @JoinColumn( name = "User_userid" ) }, inverseJoinColumns = { @JoinColumn( name = "Groups_groupid" ) } )
	private List< Group > groups;

	public User()
	{
	}

	public int getUserid()
	{
		return this.userid;
	}

	public void setUserid( int userid )
	{
		this.userid = userid;
	}

	public String getBirth()
	{
		return this.birth;
	}

	public void setBirth( String birth )
	{
		this.birth = birth;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail( String email )
	{
		this.email = email;
	}

	public String getFirstname()
	{
		return this.firstname;
	}

	public void setFirstname( String firstname )
	{
		this.firstname = firstname;
	}

	public String getLastname()
	{
		return this.lastname;
	}

	public void setLastname( String lastname )
	{
		this.lastname = lastname;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword( String password )
	{
		this.password = password;
	}

	public String getUsername()
	{
		return this.username;
	}

	public void setUsername( String username )
	{
		this.username = username;
	}

	public Address getAddress()
	{
		return this.address;
	}

	public void setAddress( Address address )
	{
		this.address = address;
	}

	public List< Group > getGroups()
	{
		return this.groups;
	}

	public void setGroups( List< Group > groups )
	{
		this.groups = groups;
	}

}