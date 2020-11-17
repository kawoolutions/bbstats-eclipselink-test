package net.bbstatstest.i286;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import net.bbstatstest.i286.entity.Contact;

@Stateless
@LocalBean
@Transactional( TxType.SUPPORTS )
public class ContactService
{
    @PersistenceContext
    protected EntityManager em;
    
    public Contact findOne( Integer id )
    {
        Contact contact = em.find( Contact.class, id );
        
        System.out.println( "Contact with ID " + id + " is " + contact );
        
        return contact;
    }
}
