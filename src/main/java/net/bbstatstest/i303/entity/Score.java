package net.bbstatstest.i303.entity;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "\"Scores\"")
@IdClass(ScoreId.class)
@NamedEntityGraph(name = Score.FETCH_PLAYER_STATS,
                  attributeNodes = {@NamedAttributeNode(value = "playerStats", subgraph = PlayerStat.FETCH_STATS)},
                  subgraphs = @NamedSubgraph(name = PlayerStat.FETCH_STATS, attributeNodes = @NamedAttributeNode("stats"))
)
@XmlRootElement
public class Score implements Serializable
{
    private static final long serialVersionUID = 1L;

    public static final String FETCH_PLAYER_STATS = "Score.fetchPlayerStats";

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
    @XmlTransient
    private Game game;

    @OneToMany(mappedBy = "score")
    @MapKey(name = "jerseyNbr")
    @OrderBy("starter DESC, jerseyNbr")
    @XmlTransient
    private Map<Integer, PlayerStat> playerStats;

    public Score()
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

    public Map<Integer, PlayerStat> getPlayerStats()
    {
        return playerStats;
    }

    public void setPlayerStats(Map<Integer, PlayerStat> playerStats)
    {
        this.playerStats = playerStats;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( (gameId == null) ? 0 : gameId.hashCode() );
        result = prime * result + ( (home == null) ? 0 : home.hashCode() );
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
        Score other = ( Score ) obj;
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
        return true;
    }

    @Override
    public String toString()
    {
        return "[" + gameId + ", " + home + ", " + finalScore + "]";
    }
}
