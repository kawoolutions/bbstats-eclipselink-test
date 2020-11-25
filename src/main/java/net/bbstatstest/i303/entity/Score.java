package net.bbstatstest.i303.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "\"Scores\"")
@IdClass(ScoreId.class)
public class Score implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "game_id")
    private Integer gameId;

    @Id
    @Column(name = "is_home")
    private Boolean home;

    @Basic(optional = false)
    @Column(name = "roster_id")
    private Integer rosterId;

    @Basic
    @Column(name = "final_score")
    private Integer finalScore;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id", insertable = false, updatable = false)
    private Game game;

    public Score()
    {
    }

    public Score(Integer gameId, Boolean home)
    {
        this(gameId, home, null);
    }

    public Score(Integer rosterId, Integer finalScore)
    {
        this(null, null, rosterId, finalScore);
    }

    public Score(Integer gameId, Boolean home, Integer rosterId)
    {
        this(gameId, home, rosterId, null);
    }

    public Score(Integer gameId, Boolean home, Integer rosterId, Integer finalScore)
    {
        this.gameId = gameId;
        this.home = home;
        this.rosterId = rosterId;
        this.finalScore = finalScore;

        this.game = new Game(gameId);
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

    public Integer getRosterId()
    {
        return rosterId;
    }

    public void setRosterId(Integer rosterId)
    {
        this.rosterId = rosterId;
    }

    public Integer getFinalScore()
    {
        return finalScore;
    }

    public void setFinalScore(Integer finalScore)
    {
        this.finalScore = finalScore;
    }

    public Game getGame()
    {
        return game;
    }

    public void setGame(Game game)
    {
        this.game = game;
    }
}
