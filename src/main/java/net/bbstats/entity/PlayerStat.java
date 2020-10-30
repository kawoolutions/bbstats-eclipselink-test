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

    @Basic(optional = false)
    @Column(name = "jersey_nbr")
    private Integer jerseyNbr;

    @Id
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id", referencedColumnName = "game_id")
    @JoinColumn(name = "is_home", referencedColumnName = "is_home")
    private Score score;

    @Id
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id", referencedColumnName = "player_id")
    @JoinColumn(name = "roster_id", referencedColumnName = "roster_id")
    private TeamMember teamMember;

    public PlayerStat()
    {
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

        return Objects.equals(this.score, other.score) && Objects.equals(this.teamMember, other.teamMember);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.score, this.teamMember);
    }

    @Override
    public String toString()
    {
        return "PlayerStat [jerseyNbr=" + Objects.toString(this.jerseyNbr) + "]";
    }
}
