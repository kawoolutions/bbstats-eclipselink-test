package net.bbstatstest.i264.entity;

import java.io.Serializable;
import java.util.Objects;

public class PlayerStatId implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer gameId;

    private Boolean home;

    private Integer playerId;

    private Integer rosterId;

    public PlayerStatId()
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

        PlayerStatId other = ( PlayerStatId ) obj;

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
        return "PlayerStatId [gameId=" + Objects.toString(this.gameId) + ", home=" + Objects.toString(this.home) + ", playerId=" + Objects.toString(this.playerId) + ", rosterId=" + Objects.toString(this.rosterId) + "]";
    }
}
