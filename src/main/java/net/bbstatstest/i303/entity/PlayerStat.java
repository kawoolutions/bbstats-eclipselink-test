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

@Entity
@Table(name = "\"PlayerStats\"")
@IdClass(PlayerStatId.class)
public class PlayerStat implements Serializable
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

    @Basic(optional = false)
    @Column(name = "jersey_nbr", insertable = false, updatable = false)
    private Integer jerseyNbr;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id", referencedColumnName = "game_id", insertable = false, updatable = false)
    @JoinColumn(name = "is_home", referencedColumnName = "is_home", insertable = false, updatable = false)
    private Score score;

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

    public Score getScore()
    {
        return score;
    }

    public void setScore(Score score)
    {
        this.score = score;
    }
}
