package net.bbstatstest.i303.entity;

import java.io.Serializable;
import java.util.Objects;

public class StatId implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer gameId;

    private Boolean home;

    private Integer playerId;

    private Integer period;

    public StatId()
    {
    }

    public StatId(StatId s)
    {
        this(s.getGameId(), s.getHome(), s.getPlayerId(), s.getPeriod());
    }

    public StatId(Integer gameId, Boolean home, Integer playerId, Integer period)
    {
        this.gameId = Objects.requireNonNull(gameId);
        this.home = Objects.requireNonNull(home);
        this.playerId = Objects.requireNonNull(playerId);
        this.period = Objects.requireNonNull(period);
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
        StatId other = ( StatId ) obj;
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
        return "[" + gameId + ", " + home + ", " + playerId + ", " + period + "]";
    }
}
