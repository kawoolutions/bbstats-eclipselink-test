package net.bbstats.entity;

import java.io.Serializable;
import java.util.Objects;

public class TeamMemberId implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer playerId;

    private Integer rosterId;

    public TeamMemberId()
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

        TeamMemberId other = ( TeamMemberId ) obj;

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
        return "TeamMemberId [playerId=" + Objects.toString(this.playerId) + ", rosterId=" + Objects.toString(this.rosterId) + "]";
    }
}
