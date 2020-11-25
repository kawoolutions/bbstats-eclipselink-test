package net.bbstatstest.i264.entity;

import java.io.Serializable;
import java.util.Objects;

public class NestedIdScoreId implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer gameId;

    private Boolean home;

    public NestedIdScoreId()
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

        NestedIdScoreId other = ( NestedIdScoreId ) obj;

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
        return "NestedIdScoreId [gameId=" + Objects.toString(this.gameId) + ", home=" + Objects.toString(this.home) + "]";
    }
}
