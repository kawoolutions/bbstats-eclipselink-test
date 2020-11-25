package net.bbstatstest.i303.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "\"Stats\"")
@IdClass(StatId.class)
@XmlRootElement
public class Stat implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "game_id")
    private Integer gameId;

    @Id
    @Column(name = "is_home")
    private Boolean home;

    @Id
    @Column(name = "player_id")
    private Integer playerId;

    @Id
    @Column
    private Integer period;

    @Basic(optional = false)
    @Column
    private Integer tpm;

    @Basic(optional = false)
    @Column
    private Integer ftm;

    @Basic(optional = false)
    @Column
    private Integer fta;

    @Basic(optional = false)
    @Column
    private Integer pts;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id", referencedColumnName = "game_id", insertable = false, updatable = false)
    @JoinColumn(name = "is_home", referencedColumnName = "is_home", insertable = false, updatable = false)
    @JoinColumn(name = "player_id", referencedColumnName = "player_id", insertable = false, updatable = false)
    @XmlTransient
    private PlayerStat playerStat;

    public Stat()
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

    public Integer getPeriod()
    {
        return period;
    }

    public void setPeriod(Integer period)
    {
        this.period = period;
    }

    public Integer getTpm()
    {
        return tpm;
    }

    public void setTpm(Integer tpm)
    {
        this.tpm = tpm;
    }

    public Integer getFtm()
    {
        return ftm;
    }

    public void setFtm(Integer ftm)
    {
        this.ftm = ftm;
    }

    public Integer getFta()
    {
        return fta;
    }

    public void setFta(Integer fta)
    {
        this.fta = fta;
    }

    public Integer getPts()
    {
        return pts;
    }

    public void setPts(Integer pts)
    {
        this.pts = pts;
    }

    public PlayerStat getPlayerStat()
    {
        return playerStat;
    }

    public void setPlayerStat(PlayerStat playerStat)
    {
        this.playerStat = playerStat;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( (gameId == null) ? 0 : gameId.hashCode() );
        result = prime * result + ( (home == null) ? 0 : home.hashCode() );
        result = prime * result + ( (period == null) ? 0 : period.hashCode() );
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
        Stat other = ( Stat ) obj;
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
        if ( period == null )
        {
            if ( other.period != null )
                return false;
        }
        else if ( !period.equals( other.period ) )
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
        return "[" + gameId + ", " + home + ", " + playerId + ", " + period + ", " + tpm + ", " + ftm + ", " + fta + ", " + pts + "]";
    }
}
