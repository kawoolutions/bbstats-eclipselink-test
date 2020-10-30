package net.bbstatstest.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.commons.io.IOUtils;

public abstract class NetUtils
{
    public static String encodeUrlParameter( String parameterValue )
    {
        try
        {
            return URLEncoder.encode( parameterValue, "UTF-8" );
        }
        catch ( UnsupportedEncodingException e )
        {
            // UTF-8 ist immer vorhanden
            throw new RuntimeException( e );
        }
    }
    
    public static void checkUrlConnection( URL url ) throws IOException
    {
        URLConnection connection = url.openConnection();
        
        // try-with-resources
        try ( InputStreamReader isr = new InputStreamReader( connection.getInputStream() ); )
        {
            // TODO: doing nothing with the reader?
        }
        finally
        {
            // only HTTP connections closeable
            IOUtils.close( connection );
        }
    }
}
