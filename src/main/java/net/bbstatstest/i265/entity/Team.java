package net.bbstatstest.i265.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Teams")
public class Team implements Serializable
{
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private TeamPk embeddedId;

//    @MapsId("clubId")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "club_id", insertable = false, updatable = false)
    private Club club;

    public Team()
    {
    }

    public TeamPk getEmbeddedId()
    {
        return embeddedId;
    }

    public void setEmbeddedId(TeamPk embeddedId)
    {
        this.embeddedId = embeddedId;
    }

    public Integer getClubId()
    {
        return embeddedId.getClubId();
    }

    public void setClubId(Integer clubId)
    {
        embeddedId.setClubId(clubId);
    }

    public String getTeamTypeCode()
    {
        return embeddedId.getTeamTypeCode();
    }

    public void setTeamTypeCode(String teamTypeCode)
    {
        embeddedId.setTeamTypeCode(teamTypeCode);
    }

    public Integer getOrdinalNbr()
    {
        return embeddedId.getOrdinalNbr();
    }

    public void setOrdinalNbr(Integer ordinalNbr)
    {
        embeddedId.setOrdinalNbr(ordinalNbr);
    }

    public Club getClub()
    {
        return club;
    }

    public void setClub(Club club)
    {
        this.club = club;
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

        Team other = ( Team ) obj;

        return Objects.equals(this.embeddedId, other.embeddedId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.embeddedId);
    }

    @Override
    public String toString()
    {
        return "Team [embeddedId=" + Objects.toString(this.embeddedId) + "]";
    }
}
