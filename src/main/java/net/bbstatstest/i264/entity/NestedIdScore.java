package net.bbstatstest.i264.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "NestedIdScores")
@IdClass(NestedIdScoreId.class)
public class NestedIdScore implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "game_id")
    private Integer gameId;

    @Id
    @Column(name = "is_home")
    private Boolean home;

    @Basic
    @Column(name = "final_score")
    private Integer finalScore;

    @OneToMany(mappedBy = "score")
    private List<NestedIdPlayerStat> playerStats;

    public NestedIdScore()
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

    public Integer getFinalScore()
    {
        return finalScore;
    }

    public void setFinalScore(Integer finalScore)
    {
        this.finalScore = finalScore;
    }

    public List<NestedIdPlayerStat> getPlayerStats()
    {
        return playerStats;
    }

    public void setPlayerStats(List<NestedIdPlayerStat> playerStats)
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

        NestedIdScore other = ( NestedIdScore ) obj;

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
        return "NestedIdScore [gameId=" + Objects.toString(this.gameId) + ", home=" + Objects.toString(this.home) + ", finalScore=" + Objects.toString(this.finalScore) + "]";
    }
}
