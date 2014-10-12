package jpower.irc.rewrite.client;

import jpower.core.Factory;
import jpower.irc.rewrite.common.ServerHostname;

import java.util.Arrays;
import java.util.List;

/**
 * Creates a PowerIrc instance with the defaults of:
 * Username = PowerIrcBot
 * Nickname = PowerIrcBot
 * Realname = PowerIrcBot
 * Hostname = irc.esper.net
 * Port = 6667
 * Initial Channels = ["#PowerIrcBot"]
 */
public class PowerIrcFactory implements Factory<PowerIrc>
{

   /**
    * Username for the PowerIrc instance
    */
   private String username = "PowerIrcBot";

   /**
    * Nickname for the PowerIrc instance
    */
   private String nickname = "PowerIrcBot";

   /**
    * Realname for the PowerIrc instance
    */
   private String realname = "PowerIrcBot";

   /**
    * Hostname for the PowerIrc instance
    */
   private String hostname = "irc.esper.net";

   /**
    * Port for the PowerIrc instance
    */
   private int port = 6667;

   /**
    * Initial channels for the PowerIrc instance
    */
   private List<String> initial_channels = Arrays.asList("#PowerIrcBot");

   /**
    * Create the PowerIrc instance
    *
    * @return PowerIrc instance
    */
   @Override
   public PowerIrc create()
   {
      return new PowerIrc(username, nickname, realname, new ServerHostname(hostname).setPort(port), initial_channels);
   }

   /**
    * Set the username
    * @param username IRC username
    * @return Factory
    */
   public PowerIrcFactory setUsername(String username)
   {
      this.username = username;
      return this;
   }

   /**
    * Set the nickname
    * @param nickname IRC nickname
    * @return Factory
    */
   public PowerIrcFactory setNickname(String nickname)
   {
      this.nickname = nickname;
      return this;
   }

   /**
    * Set the realname
    * @param realname IRC realname
    * @return Factory
    */
   public PowerIrcFactory setRealname(String realname)
   {
      this.realname = realname;
      return this;
   }

   /**
    * Set the hostname
    * @param hostname IRC hostname
    * @return Factory
    */
   public PowerIrcFactory setHostname(String hostname)
   {
      this.hostname = hostname;
      return this;
   }

   /**
    * Set the port
    * @param port IRC port
    * @return Factory
    */
   public PowerIrcFactory setPort(int port)
   {
      this.port = port;
      return this;
   }

   /**
    * Set the initial channels
    * @param initial_channels IRC channels
    * @return Factory
    */
   public PowerIrcFactory setInitialChannels(List<String> initial_channels)
   {
      this.initial_channels = initial_channels;
      return this;
   }

}
