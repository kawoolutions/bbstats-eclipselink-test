package net.bbstatstest.i265;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import net.bbstatstest.i265.entity.Club;

@Named
@ViewScoped
public class ClubTeamView implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Inject
    private ClubService clubService;
    
    private Club club;
    
    @PostConstruct
    public void init()
    {
        System.out.println( ClubTeamView.class.getSimpleName() + ": @PostConstruct!" );
    }

    public Club getClub()
    {
        if ( club == null )
        {
            club = loadEntity();
        }
        
        return club;
    }

    public void setClub( Club club )
    {
        this.club = club;
    }

    private Club loadEntity()
    {
        Club club = clubService.findOne( 101 );
        
        return club;
    }
}
