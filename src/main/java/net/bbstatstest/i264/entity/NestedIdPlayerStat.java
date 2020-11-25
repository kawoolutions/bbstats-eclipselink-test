package net.bbstatstest.i264.entity;

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
@Table(name = "NestedIdPlayerStats")
@IdClass(NestedIdPlayerStatId.class)
public class NestedIdPlayerStat implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "jersey_nbr")
    private Integer jerseyNbr;

    @Id
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id", referencedColumnName = "game_id")
    @JoinColumn(name = "is_home", referencedColumnName = "is_home")
    private NestedIdScore score;

    @Id
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id", referencedColumnName = "player_id")
    @JoinColumn(name = "roster_id", referencedColumnName = "roster_id")
    private NestedIdTeamMember teamMember;

    public NestedIdPlayerStat()
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

    public NestedIdScore getScore()
    {
        return score;
    }

    public void setScore(NestedIdScore score)
    {
        this.score = score;
    }

    public NestedIdTeamMember getTeamMember()
    {
        return teamMember;
    }

    public void setTeamMember(NestedIdTeamMember teamMember)
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

        NestedIdPlayerStat other = ( NestedIdPlayerStat ) obj;

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
        return "NestedIdPlayerStat [jerseyNbr=" + Objects.toString(this.jerseyNbr) + "]";
    }
}
