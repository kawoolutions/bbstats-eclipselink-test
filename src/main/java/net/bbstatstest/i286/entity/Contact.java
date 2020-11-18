package net.bbstatstest.i286.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "\"Contacts\"")
@SecondaryTable(name = "\"Addresses\"", pkJoinColumns = @PrimaryKeyJoinColumn(name = "contact_id", referencedColumnName = "id"))
public class Contact implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

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

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
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
}
