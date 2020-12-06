package net.bbstatstest.i303;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Subgraph;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import net.bbstatstest.i303.entity.Game;
import net.bbstatstest.i303.entity.Score;

@Stateless
@LocalBean
@Transactional( TxType.SUPPORTS )
public class GameService
{
    @PersistenceContext
    protected EntityManager em;
    
    public List<Game> findAllWithScores()
    {
        TypedQuery<Game> query = em.createNamedQuery( Game.FIND_ALL, Game.class );
        
        // IAE: entity graph not found
//        query.setHint( "javax.persistence.fetchgraph", Game.FETCH_SCORES );
        
        // only works programmatically
        EntityGraph<Game> graph = em.createEntityGraph( Game.class );
        graph.addAttributeNodes( "scores" );
        Subgraph<Score> playerStats = graph.addSubgraph( "scores", Score.class );
        playerStats.addAttributeNodes( "playerStats" );
        
        query.setHint( "javax.persistence.fetchgraph" , graph );
        
        return query.getResultList();
    }
}
