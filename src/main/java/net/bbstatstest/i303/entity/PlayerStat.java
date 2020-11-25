package net.bbstatstest.i303.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "\"PlayerStats\"")
@IdClass(PlayerStatId.class)
@NamedQuery(name = PlayerStat.FIND_BY_INTERVAL_AND_TEAM, query = "SELECT ps FROM PlayerStat ps JOIN ps.teamMember tm JOIN tm.player pl JOIN pl.person pe JOIN ps.score sc JOIN sc.game ga JOIN sc.roster ro JOIN ro.team te JOIN te.teamType tt JOIN te.club cl WHERE CASE WHEN ga.actualTipoff IS NOT NULL THEN ga.actualTipoff ELSE ga.scheduledTipoff END >= :begin AND CASE WHEN ga.actualTipoff IS NOT NULL THEN ga.actualTipoff ELSE ga.scheduledTipoff END <= :end AND pe.id = :playerId AND cl.id = :clubId AND tt.code = :teamTypeCode AND te.ordinalNbr = :ordinalNbr ORDER BY CASE WHEN ga.actualTipoff IS NOT NULL THEN ga.actualTipoff ELSE ga.scheduledTipoff END DESC")
@XmlRootElement
public class PlayerStat implements Serializable
{
    private static final long serialVersionUID = 1L;

    public static final String FIND_BY_INTERVAL_AND_TEAM = "PlayerStat.findByIntervalAndTeam";
    public static final String FETCH_STATS = "PlayerStat.fetchStats";

    @Id
    @Column(name = "game_id")
    private Integer gameId;

    @Id
    @Column(name = "is_home")
    private Boolean home;

    @Id
    @Column(name = "player_id")
    private Integer playerId;

    @Basic(optional = false)
    @Column(name = "jersey_nbr")
    private Integer jerseyNbr;

    @Basic(optional = false)
    @Column(name = "has_played")
    private Boolean hasPlayed = Boolean.TRUE;

    @Basic
    @Column(name = "is_starter")
    private Boolean starter;

    @Basic(optional = false)
    @Column
    private Integer pf;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id", referencedColumnName = "game_id", insertable = false, updatable = false)
    @JoinColumn(name = "is_home", referencedColumnName = "is_home", insertable = false, updatable = false)
    @XmlTransient
    private Score score;

    @OneToMany(mappedBy = "playerStat")
    @OrderBy("period")
    @XmlTransient
    private List<Stat> stats;

    public PlayerStat()
    {
    }

    public Integer getGameId()
    {
        return gameId;
    }

    public void setGameId(Integer gameId)
    {
        this.gameId = gameId;
    }

    public Boolean getHome()
    {
        return home;
    }

    public void setHome(Boolean home)
    {
        this.home = home;
    }

    public Integer getPlayerId()
    {
        return playerId;
    }

    public void setPlayerId(Integer playerId)
    {
        this.playerId = playerId;
    }

    public Integer getJerseyNbr()
    {
        return jerseyNbr;
    }

    public void setJerseyNbr(Integer jerseyNbr)
    {
        this.jerseyNbr = jerseyNbr;
    }

    public Boolean getHasPlayed()
    {
        return hasPlayed;
    }

    public void setHasPlayed(Boolean hasPlayed)
    {
        this.hasPlayed = hasPlayed;
    }

    public Boolean getStarter()
    {
        return starter;
    }

    public void setStarter(Boolean starter)
    {
        this.starter = starter;
    }

    public Integer getPf()
    {
        return pf;
    }

    public void setPf(Integer pf)
    {
        this.pf = pf;
    }

    public Score getScore()
    {
        return score;
    }

    public void setScore(Score score)
    {
        this.score = score;
    }

    public List<Stat> getStats()
    {
        return stats;
    }

    public void setStats(List<Stat> stats)
    {
        this.stats = stats;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( (gameId == null) ? 0 : gameId.hashCode() );
        result = prime * result + ( (home == null) ? 0 : home.hashCode() );
        result = prime * result + ( (playerId == null) ? 0 : playerId.hashCode() );
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
        PlayerStat other = ( PlayerStat ) obj;
        if ( gameId == null )
        {
            if ( other.gameId != null )
                return false;
        }
        else if ( !gameId.equals( other.gameId ) )
            return false;
        if ( home == null )
        {
            if ( other.home != null )
                return false;
        }
        else if ( !home.equals( other.home ) )
            return false;
        if ( playerId == null )
        {
            if ( other.playerId != null )
                return false;
        }
        else if ( !playerId.equals( other.playerId ) )
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "[" + gameId + ", " + home + ", " + playerId + ", " + jerseyNbr + ", " + hasPlayed + ", " + starter + ", " + pf + "]";
    }
}
