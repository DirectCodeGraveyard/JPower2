package jpower.irc.rewrite.common;

public class ServerHostname
{

   private String hostname;
   private int port;
   private boolean ssl;

   public ServerHostname(String hostname)
   {
      this.hostname = hostname;
   }

   public String getHostname()
   {
      return hostname;
   }

   public int getPort()
   {
      return port;
   }

   public boolean isSsl()
   {
      return ssl;
   }

   public ServerHostname setPort(int port)
   {
      this.port = port;
      return this;
   }

   public ServerHostname setSSL(boolean ssl)
   {
      this.ssl = ssl;
      return this;
   }

}
