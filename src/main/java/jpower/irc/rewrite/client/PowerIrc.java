package jpower.irc.rewrite.client;

import jpower.core.utils.IOUtils;
import jpower.event.EventBus;
import jpower.irc.rewrite.common.Channel;
import jpower.irc.rewrite.common.ServerHostname;
import jpower.irc.rewrite.common.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class PowerIrc
{

   private static final Pattern PATTERN = Pattern.compile("^(:(?<prefix>\\S+) )?(?<command>\\S+)( (?!:)(?<params>.+?))?( :(?<trail>.+))?$");
   private static final Pattern HOSTMASK = Pattern.compile("[!@]");

   private EventBus eventBus;
   private Socket socket;
   private PrintWriter writer;
   private BufferedReader reader;
   private Thread worker;
   private String username;
   private String nickname;
   private String realname;
   private ServerHostname server;
   private User me;
   private boolean ready;
   private List<String> motd;
   private Map<String, User> users;
   private Map<String, Channel> channels;
   private List<String> initial_channels;

   protected PowerIrc(String username, String nickname, String realname, ServerHostname server, List<String> initial_channels)
   {
      this.username = username;
      this.nickname = nickname;
      this.realname = realname;
      this.server = server;

      //me = new User(this, username, nickname);

      eventBus = new EventBus();
      eventBus.register(this);

      motd = new ArrayList<>();
      users = new HashMap<>();
      channels = new HashMap<>();
      this.initial_channels = initial_channels;
   }

   private void connect()
   {
      try
      {
         socket = new Socket(server.getHostname(), server.getPort());
         writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
         reader = IOUtils.createBufferedReader(socket.getInputStream());
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      //worker = new Reader();
      //worker.start();
      nick(nickname);
      user(username, realname);
   }

   public EventBus getEventBus()
   {
      return eventBus;
   }

   public void writeline(String line)
   {
      writer.write(line + "\r\n");
      writer.flush();
   }

   public String readline()
   {
      try
      {
         return reader.readLine();
      }
      catch (IOException e)
      {
         e.printStackTrace();
         return null;
      }
   }

   private void nick(String nick)
   {
      writeline("NICK " + nick);
      nickname = nick;
   }

   private void user(String username, String realname)
   {
      writeline("USER " + username + " 8 * :" + realname);
   }

}
