package net.bbstatstest.i265.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TeamPk implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Column(name = "club_id")
    private Integer clubId;

    @Column(name = "team_type_code")
    private String teamTypeCode;

    @Column(name = "ordinal_nbr")
    private Integer ordinalNbr;

    public TeamPk()
    {
    }

    public Integer getClubId()
    {
        return clubId;
    }

    public void setClubId(Integer clubId)
    {
        this.clubId = clubId;
    }

    public String getTeamTypeCode()
    {
        return teamTypeCode;
    }

    public void setTeamTypeCode(String teamTypeCode)
    {
        this.teamTypeCode = teamTypeCode;
    }

    public Integer getOrdinalNbr()
    {
        return ordinalNbr;
    }

    public void setOrdinalNbr(Integer ordinalNbr)
    {
        this.ordinalNbr = ordinalNbr;
    }

    @Override
    public boolean equals(Object obj)
    {
        if ( obj == null )
        {
            return false;
        }

        if ( getClass() != obj.getClass() )
        {
            return false;
        }

        TeamPk other = ( TeamPk ) obj;

        return Objects.equals(this.clubId, other.clubId) && Objects.equals(this.teamTypeCode, other.teamTypeCode) && Objects.equals(this.ordinalNbr, other.ordinalNbr);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.clubId, this.teamTypeCode, this.ordinalNbr);
    }

    @Override
    public String toString()
    {
        return "TeamPk [clubId=" + Objects.toString(this.clubId) + ", teamTypeCode=" + Objects.toString(this.teamTypeCode) + ", ordinalNbr=" + Objects.toString(this.ordinalNbr) + "]";
    }
}
