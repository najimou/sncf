package fr.upmc.metier;

import java.util.ArrayList;

/***********************************************************************
 * Module:  Voyage.java
 * Author:  Nicolas Pigeot
 * Purpose: Defines the Class Voyage
 ***********************************************************************/


public class Voyage {
	
   public ArrayList<Transport> transport;
   

   public boolean accepterTransport() {
      // TODO: implement
      return false;
   }
   
   public boolean refuserTransport() {
      // TODO: implement
      return false;
   }
   
   public boolean finaliserTrasport() {
      // TODO: implement
      return false;
   }
   
   
   public ArrayList<Transport> getTransport() {
      if (transport == null)
         transport = new ArrayList<Transport>();
      return transport;
   }
   
   public ArrayList<Transport> getIteratorTransport() {
      if (transport == null)
         transport = new ArrayList<Transport>();
      return transport;
   }
   
   public void setTransport(ArrayList<Transport> newTransport) {
      this.transport = newTransport;
   }
   
   public void addTransport(Transport newTransport) {
      transport.add(newTransport);
   }
   

   public void removeTransport(Transport oldTransport) {
      if (oldTransport == null)
         return;
      if (this.transport != null)
         if (this.transport.contains(oldTransport))
            this.transport.remove(oldTransport);
   }
   
   public void removeAllTransport() {
      if (transport != null)
         transport.clear();
   }

}