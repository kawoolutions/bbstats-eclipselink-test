package net.bbstats.entity;

import java.io.Serializable;
import java.util.Objects;

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
@Table(name = "PlayerStats")
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

    @Id
    @Column(name = "roster_id")
    private Integer rosterId;

    @Basic(optional = false)
    @Column(name = "jersey_nbr")
    private Integer jerseyNbr;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id", referencedColumnName = "game_id", insertable = false, updatable = false)
    @JoinColumn(name = "is_home", referencedColumnName = "is_home", insertable = false, updatable = false)
    private Score score;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id", referencedColumnName = "player_id", insertable = false, updatable = false)
    @JoinColumn(name = "roster_id", referencedColumnName = "roster_id", insertable = false, updatable = false)
    private TeamMember teamMember;

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

    public Integer getRosterId()
    {
        return rosterId;
    }

    public void setRosterId(Integer rosterId)
    {
        this.rosterId = rosterId;
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

    public TeamMember getTeamMember()
    {
        return teamMember;
    }

    public void setTeamMember(TeamMember teamMember)
    {
        this.teamMember = teamMember;
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

        PlayerStat other = ( PlayerStat ) obj;

        return Objects.equals(this.gameId, other.gameId) && Objects.equals(this.home, other.home) && Objects.equals(this.playerId, other.playerId) && Objects.equals(this.rosterId, other.rosterId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.gameId, this.home, this.playerId, this.rosterId);
    }

    @Override
    public String toString()
    {
        return "PlayerStat [gameId=" + Objects.toString(this.gameId) + ", home=" + Objects.toString(this.home) + ", playerId=" + Objects.toString(this.playerId) + ", rosterId=" + Objects.toString(this.rosterId) + ", jerseyNbr=" + Objects.toString(this.jerseyNbr) + "]";
    }
}
