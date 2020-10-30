package net.bbstatstest.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TeamMembers")
@IdClass(TeamMemberId.class)
public class TeamMember implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "player_id")
    private Integer playerId;

    @Id
    @Column(name = "roster_id")
    private Integer rosterId;

    @OneToMany(mappedBy = "teamMember")
    private List<PlayerStat> playerStats;

    public TeamMember()
    {
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

    public List<PlayerStat> getPlayerStats()
    {
        return playerStats;
    }

    public void setPlayerStats(List<PlayerStat> playerStats)
    {
        this.playerStats = playerStats;
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

        TeamMember other = ( TeamMember ) obj;

        return Objects.equals(this.playerId, other.playerId) && Objects.equals(this.rosterId, other.rosterId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.playerId, this.rosterId);
    }

    @Override
    public String toString()
    {
        return "TeamMember [playerId=" + Objects.toString(this.playerId) + ", rosterId=" + Objects.toString(this.rosterId) + "]";
    }
}
