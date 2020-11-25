package net.bbstatstest.i264.entity;

import java.io.Serializable;
import java.util.Objects;

public class NestedIdTeamMemberId implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer playerId;

    private Integer rosterId;

    public NestedIdTeamMemberId()
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

        NestedIdTeamMemberId other = ( NestedIdTeamMemberId ) obj;

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
        return "NestedIdTeamMemberId [playerId=" + Objects.toString(this.playerId) + ", rosterId=" + Objects.toString(this.rosterId) + "]";
    }
}
