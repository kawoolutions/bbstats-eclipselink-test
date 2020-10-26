package net.bbstats.entity;

import java.io.Serializable;
import java.util.Objects;

public class ScoreId implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer gameId;

    private Boolean home;

    public ScoreId()
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

        ScoreId other = ( ScoreId ) obj;

        return Objects.equals(this.gameId, other.gameId) && Objects.equals(this.home, other.home);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.gameId, this.home);
    }

    @Override
    public String toString()
    {
        return "ScoreId [gameId=" + Objects.toString(this.gameId) + ", home=" + Objects.toString(this.home) + "]";
    }
}
