package net.bbstatstest.entity;

import java.io.Serializable;
import java.util.Objects;

public class PlayerStatId implements Serializable
{
    private static final long serialVersionUID = 1L;

    private ScoreId score;

    private TeamMemberId teamMember;

    public PlayerStatId()
    {
    }

    public Integer getGameId()
    {
        return score.getGameId();
    }

    public void setGameId(Integer gameId)
    {
        score.setGameId(gameId);
    }

    public Boolean getHome()
    {
        return score.getHome();
    }

    public void setHome(Boolean home)
    {
        score.setHome(home);
    }

    public Integer getPlayerId()
    {
        return teamMember.getPlayerId();
    }

    public void setPlayerId(Integer playerId)
    {
        teamMember.setPlayerId(playerId);
    }

    public Integer getRosterId()
    {
        return teamMember.getRosterId();
    }

    public void setRosterId(Integer rosterId)
    {
        teamMember.setRosterId(rosterId);
    }

    public ScoreId getScoreId()
    {
        return score;
    }

    public void setScoreId(ScoreId scoreId)
    {
        this.score = scoreId;
    }

    public TeamMemberId getTeamMemberId()
    {
        return teamMember;
    }

    public void setTeamMemberId(TeamMemberId teamMemberId)
    {
        this.teamMember = teamMemberId;
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
        return "PlayerStatId [score=" + Objects.toString(this.score) + ", teamMember=" + Objects.toString(this.teamMember) + "]";
    }
}
