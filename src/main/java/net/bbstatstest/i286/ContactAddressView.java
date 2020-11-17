package net.bbstatstest.i286;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import net.bbstatstest.i286.entity.Contact;

@Named
@ViewScoped
public class ContactAddressView implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Inject
    private ContactService contactService;
    
    private Contact contact;
    
    @PostConstruct
    public void init()
    {
        System.out.println( ContactAddressView.class.getSimpleName() + ": @PostConstruct!" );
    }

    public Contact getContact()
    {
        if ( contact == null )
        {
            contact = loadEntity();
        }
        
        return contact;
    }

    public void setContact( Contact contact )
    {
        this.contact = contact;
    }

    private Contact loadEntity()
    {
        Contact contact = contactService.findOne( 101 );
        
        return contact;
    }
}
