package net.bbstatstest.i286.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "\"Contacts\"")
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@SecondaryTable(name = "\"Addresses\"", pkJoinColumns = @PrimaryKeyJoinColumn(name = "contact_id", referencedColumnName = "id"))
@XmlRootElement
public class Contact implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Basic(optional = false)
    @Column
    @Enumerated(EnumType.STRING)
    private Type type;

    @Basic
    @Column(name = "country_code", table = "\"Addresses\"")
    private String countryCode;

    @Basic
    @Column(name = "zip_code", table = "\"Addresses\"")
    private String zipCode;

    @Basic
    @Column(name = "city_name", table = "\"Addresses\"")
    private String cityName;

    @Basic
    @Column(name = "street_name", table = "\"Addresses\"")
    private String streetName;

    @Basic
    @Column(name = "house_nbr", table = "\"Addresses\"")
    private String houseNbr;

    public Contact()
    {
    }

    public Contact(Contact c)
    {
        this(c.getType(), c.getCountryCode(), c.getZipCode(), c.getCityName(), c.getStreetName(), c.getHouseNbr());

        this.id = Objects.requireNonNull(c.getId());
    }

    public Contact(Type type)
    {
        this(type, null, null, null, null, null);
    }

    public Contact(Type type, String countryCode, String zipCode, String cityName, String streetName, String houseNbr)
    {
        this.type = type;
        this.countryCode = countryCode;
        this.zipCode = zipCode;
        this.cityName = cityName;
        this.streetName = streetName;
        this.houseNbr = houseNbr;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Type getType()
    {
        return type;
    }

    public void setType(Type type)
    {
        this.type = type;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public void setCountryCode(String countryCode)
    {
        this.countryCode = countryCode;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    public String getCityName()
    {
        return cityName;
    }

    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }

    public String getStreetName()
    {
        return streetName;
    }

    public void setStreetName(String streetName)
    {
        this.streetName = streetName;
    }

    public String getHouseNbr()
    {
        return houseNbr;
    }

    public void setHouseNbr(String houseNbr)
    {
        this.houseNbr = houseNbr;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( (id == null) ? 0 : id.hashCode() );
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        Contact other = ( Contact ) obj;
        if ( id == null )
        {
            if ( other.id != null )
                return false;
        }
        else if ( !id.equals( other.id ) )
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "[" + id + ", " + type + ", " + countryCode + ", " + zipCode + ", " + cityName + ", " + streetName + ", " + houseNbr + "]";
    }
}
