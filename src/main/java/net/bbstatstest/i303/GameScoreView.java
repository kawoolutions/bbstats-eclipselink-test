package net.bbstatstest.i303;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import net.bbstatstest.i303.entity.Game;

@Named
@ViewScoped
public class GameScoreView implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Inject
    private GameService gameService;
    
    private List<Game> games;
    
    @PostConstruct
    public void init()
    {
        System.out.println( GameScoreView.class.getSimpleName() + ": @PostConstruct!" );
    }

    public List<Game> getGames()
    {
        if ( games == null )
        {
            games = loadEntities();
        }
        
        return games;
    }

    public void setGame( List<Game> games )
    {
        this.games = games;
    }

    private List<Game> loadEntities()
    {
        List<Game> games = gameService.findAllWithScores();
        
        return games;
    }
}
