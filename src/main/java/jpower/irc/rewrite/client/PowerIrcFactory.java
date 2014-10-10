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

   private String username = "PowerIrcBot";
   private String nickname = "PowerIrcBot";
   private String realname = "PowerIrcBot";
   private String hostname = "irc.esper.net";
   private int port = 6667;
   private List<String> initial_channels = Arrays.asList("#PowerIrcBot");

   @Override
   public PowerIrc create()
   {
      return new PowerIrc(username, nickname, realname, new ServerHostname(hostname).setPort(port), initial_channels);
   }

   public PowerIrcFactory setUsername(String username)
   {
      this.username = username;
      return this;
   }

   public PowerIrcFactory setNickname(String nickname)
   {
      this.nickname = nickname;
      return this;
   }

   public PowerIrcFactory setRealname(String realname)
   {
      this.realname = realname;
      return this;
   }

   public PowerIrcFactory setHostname(String hostname)
   {
      this.hostname = hostname;
      return this;
   }

   public PowerIrcFactory setPort(int port)
   {
      this.port = port;
      return this;
   }

   public PowerIrcFactory setInitialChannels(List<String> initial_channels)
   {
      this.initial_channels = initial_channels;
      return this;
   }

}
