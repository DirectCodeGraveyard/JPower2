package jpower.irc.rewrite.common;

public class Channel implements Sendable
{

   private String channelName;

   public Channel(String channelName)
   {
      this.channelName = channelName;
   }

   @Override
   public String getName()
   {
      return channelName;
   }

   @Override
   public void sendMessage(String message)
   {

   }

   public void op(String nick)
   {

   }

   public void deop(String nick)
   {

   }

   public void voice(String nick)
   {

   }

   public void devoice(String nick)
   {

   }

}
