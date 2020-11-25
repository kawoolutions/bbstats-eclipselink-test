package net.bbstatstest.i303;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import net.bbstatstest.i303.entity.Game;
import net.bbstatstest.i303.entity.Score;

public class NamingUtils
{
    public static String getGameLabelFor( Game game )
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd HH:mm" );
        LocalDateTime scheduledTipoff = game.getScheduledTipoff();
        String isoDate = scheduledTipoff.format( formatter );
        
        Map<Boolean, Score> scores = game.getScores();
        
        String label = isoDate + ": " + scores.get( Boolean.TRUE ).getRosterId() + " vs. " + scores.get( Boolean.FALSE ).getRosterId();
        
        return label;
    }
}
