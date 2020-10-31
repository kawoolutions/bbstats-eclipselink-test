package net.bbstatstest.i265;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import net.bbstatstest.i265.entity.Club;

@Stateless
@LocalBean
@Transactional( TxType.SUPPORTS )
public class ClubService
{
    @PersistenceContext
    protected EntityManager em;
    
    public Club findOne( Integer id )
    {
        Club club = em.find( Club.class, id );
        
        System.out.println( "Club with ID " + id + " is " + club );
        
        return club;
    }
}
