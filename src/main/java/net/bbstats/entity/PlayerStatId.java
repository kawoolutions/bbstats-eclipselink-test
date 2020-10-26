package net.bbstats.entity;

import java.io.Serializable;
import java.util.Objects;

public class PlayerStatId implements Serializable
{
    private static final long serialVersionUID = 1L;

    private ScoreId scoreId;

    private TeamMemberId teamMemberId;

    public PlayerStatId()
    {
    }

    public Integer getGameId()
    {
        return scoreId.getGameId();
    }

    public void setGameId(Integer gameId)
    {
        scoreId.setGameId(gameId);
    }

    public Boolean getHome()
    {
        return scoreId.getHome();
    }

    public void setHome(Boolean home)
    {
        scoreId.setHome(home);
    }

    public Integer getPlayerId()
    {
        return teamMemberId.getPlayerId();
    }

    public void setPlayerId(Integer playerId)
    {
        teamMemberId.setPlayerId(playerId);
    }

    public Integer getRosterId()
    {
        return teamMemberId.getRosterId();
    }

    public void setRosterId(Integer rosterId)
    {
        teamMemberId.setRosterId(rosterId);
    }

    public ScoreId getScoreId()
    {
        return scoreId;
    }

    public void setScoreId(ScoreId scoreId)
    {
        this.scoreId = scoreId;
    }

    public TeamMemberId getTeamMemberId()
    {
        return teamMemberId;
    }

    public void setTeamMemberId(TeamMemberId teamMemberId)
    {
        this.teamMemberId = teamMemberId;
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

        return Objects.equals(this.scoreId, other.scoreId) && Objects.equals(this.teamMemberId, other.teamMemberId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.scoreId, this.teamMemberId);
    }

    @Override
    public String toString()
    {
        return "PlayerStatId [scoreId=" + Objects.toString(this.scoreId) + ", teamMemberId=" + Objects.toString(this.teamMemberId) + "]";
    }
}
