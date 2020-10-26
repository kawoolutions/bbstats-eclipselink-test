package net.bbstats.application;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DeploymentContextListener implements ServletContextListener
{
    @Override
    public void contextInitialized( ServletContextEvent sce )
    {
        ZonedDateTime now = ZonedDateTime.now( ZoneId.of( "Europe/Berlin" ) );
        
        sce.getServletContext().setAttribute( "restartDateTime", Date.from( now.toInstant() ) );
    }
    
    @Override
    public void contextDestroyed( ServletContextEvent sce )
    {
        // do nothing
    }
    
}