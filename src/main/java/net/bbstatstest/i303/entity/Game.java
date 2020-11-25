package net.bbstatstest.i303.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "\"Games\"")
@NamedQuery(name = Game.FIND_ALL, query = "SELECT ga FROM Game ga")
@NamedEntityGraph(name = Game.FETCH_SCORES, attributeNodes = {@NamedAttributeNode("scores")})
public class Game implements Serializable
{
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Game.findAll";
    public static final String FETCH_SCORES = "Game.fetchScores";

    @Id
    @Column
    private Integer id;

    @Basic(optional = false)
    @Column(name = "scheduled_tipoff")
    private LocalDateTime scheduledTipoff;

    @OneToMany(mappedBy = "game")
    @MapKeyColumn(name = "is_home", insertable = false, updatable = false)
    private Map<Boolean, Score> scores;

    public Game()
    {
    }

    public Game(Integer id)
    {
        this(id, null);
    }

    public Game(LocalDateTime scheduledTipoff)
    {
        this(null, scheduledTipoff);
    }

    public Game(Integer id, LocalDateTime scheduledTipoff)
    {
        this.id = id;
        this.scheduledTipoff = scheduledTipoff;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public LocalDateTime getScheduledTipoff()
    {
        return scheduledTipoff;
    }

    public void setScheduledTipoff(LocalDateTime scheduledTipoff)
    {
        this.scheduledTipoff = scheduledTipoff;
    }

    public Map<Boolean, Score> getScores()
    {
        return scores;
    }

    public void setScores(Map<Boolean, Score> scores)
    {
        this.scores = scores;
    }
}
