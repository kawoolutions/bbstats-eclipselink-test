package net.bbstatstest.i264.entity;

import java.io.Serializable;
import java.util.Objects;

public class NestedIdPlayerStatId implements Serializable
{
    private static final long serialVersionUID = 1L;

    private NestedIdScoreId score;

    private NestedIdTeamMemberId teamMember;

    public NestedIdPlayerStatId()
    {
    }

    public NestedIdScoreId getNestedIdScore()
    {
        return score;
    }

    public void setNestedIdScore(NestedIdScoreId score)
    {
        this.score = score;
    }

    public NestedIdTeamMemberId getNestedIdTeamMember()
    {
        return teamMember;
    }

    public void setNestedIdTeamMember(NestedIdTeamMemberId teamMember)
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

        NestedIdPlayerStatId other = ( NestedIdPlayerStatId ) obj;

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
        return "NestedIdPlayerStatId [score=" + Objects.toString(this.score) + ", teamMember=" + Objects.toString(this.teamMember) + "]";
    }
}
