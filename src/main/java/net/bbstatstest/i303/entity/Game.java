package net.bbstatstest.i303.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQuery;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "\"Games\"")
@NamedQuery(name = Game.FIND_BY_PK, query = "SELECT ga FROM Game ga WHERE ga.id = :gameId")
@NamedQuery(name = Game.FIND_ALL, query = "SELECT ga FROM Game ga")
@NamedEntityGraph(name = Game.FETCH_SCORES, attributeNodes = {@NamedAttributeNode("arena"), @NamedAttributeNode("scores")})
@NamedEntityGraph(name = Game.FETCH_SCORES_AND_PLAYER_STATS,
    attributeNodes = {
        @NamedAttributeNode("arena"),
        @NamedAttributeNode(value = "scores", subgraph = Score.FETCH_PLAYER_STATS)},
    subgraphs = {@NamedSubgraph(name = Score.FETCH_PLAYER_STATS, attributeNodes = @NamedAttributeNode("playerStats"))}
)
@NamedEntityGraph(name = Game.FETCH_SCORES_PLAYER_STATS_AND_STATS,
    attributeNodes = {
        @NamedAttributeNode("arena"),
        @NamedAttributeNode(value = "scores", subgraph = Score.FETCH_PLAYER_STATS)},
    subgraphs = {
        @NamedSubgraph(name = Score.FETCH_PLAYER_STATS, attributeNodes = @NamedAttributeNode(value = "playerStats", subgraph = PlayerStat.FETCH_STATS)),
        @NamedSubgraph(name = PlayerStat.FETCH_STATS, attributeNodes = @NamedAttributeNode("stats"))}
)
@XmlRootElement
public class Game implements Serializable
{
    private static final long serialVersionUID = 1L;

    public static final String FIND_BY_PK = "Game.findByPk";
    public static final String FIND_ALL = "Game.findAll";
    public static final String FETCH_SCORES = "Game.fetchScores";
    public static final String FETCH_SCORES_AND_PLAYER_STATS = "Game.fetchScoresAndPlayerStats";
    public static final String FETCH_SCORES_PLAYER_STATS_AND_STATS = "Game.fetchScoresPlayerStatsAndStats";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Basic(optional = false)
    @Column(name = "scheduled_tipoff")
    private LocalDateTime scheduledTipoff;

    @Basic
    @Column(name = "actual_tipoff")
    private LocalDateTime actualTipoff;

    @Basic
    @Column(name = "matchday_nbr")
    private Integer matchdayNbr;

    @Basic
    @Column(name = "official_nbr")
    private String officialNbr;

    @Basic
    @Column
    private Integer attendance;

    @Basic
    @Column
    private String recap;

    @OneToMany(mappedBy = "game")
    @MapKeyColumn(name = "is_home", insertable = false, updatable = false)
//    @MapKey(name = "home")
    private Map<Boolean, Score> scores;

    public Game()
    {
    }

    public LocalDateTime getScheduledTipoff()
    {
        return scheduledTipoff;
    }

    public void setScheduledTipoff(LocalDateTime scheduledTipoff)
    {
        this.scheduledTipoff = scheduledTipoff;
    }

    public LocalDateTime getActualTipoff()
    {
        return actualTipoff;
    }

    public void setActualTipoff(LocalDateTime actualTipoff)
    {
        this.actualTipoff = actualTipoff;
    }

    public Integer getMatchdayNbr()
    {
        return matchdayNbr;
    }

    public void setMatchdayNbr(Integer matchdayNbr)
    {
        this.matchdayNbr = matchdayNbr;
    }

    public String getOfficialNbr()
    {
        return officialNbr;
    }

    public void setOfficialNbr(String officialNbr)
    {
        this.officialNbr = officialNbr;
    }

    public Integer getAttendance()
    {
        return attendance;
    }

    public void setAttendance(Integer attendance)
    {
        this.attendance = attendance;
    }

    public String getRecap()
    {
        return recap;
    }

    public void setRecap(String recap)
    {
        this.recap = recap;
    }

    public Map<Boolean, Score> getScores()
    {
        return scores;
    }

    public void setScores(Map<Boolean, Score> scores)
    {
        this.scores = scores;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( (id == null) ? 0 : id.hashCode() );
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
        Game other = ( Game ) obj;
        if ( id == null )
        {
            if ( other.id != null )
                return false;
        }
        else if ( !id.equals( other.id ) )
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "[" + id + ", " + scheduledTipoff + ", " + actualTipoff + ", " + matchdayNbr + ", " + officialNbr + ", " + attendance + ", " + recap + "]";
    }
}
