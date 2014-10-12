package fr.upmc.metier;

import java.util.ArrayList;

/***********************************************************************
 * Module:  Trasporteur.java
 * Author:  Nicols Pigeot
 * Purpose: Defines the Class Trasporteur
 ***********************************************************************/




public class Trasporteur {
   public ArrayList<Voyage> voyage;
   public ArrayList<Evaluation> evaluation;
   
   public boolean login() {
      // TODO: implement
      return false;
   }
   
   public boolean logout() {
      // TODO: implement
      return false;
   }
   
   public boolean updateProfile() {
      // TODO: implement
      return false;
   }
   
   public boolean accepterTransport() {
      // TODO: implement
      return false;
   }
   
   public boolean ajouterVoyage() {
      // TODO: implement
      return false;
   }
   
   public boolean supprimerVoyage() {
      // TODO: implement
      return false;
   }
   
   public boolean finaliserTrasport() {
      // TODO: implement
      return false;
   }
   
   public ArrayList<Voyage> getVoyage() {
      if (voyage == null)
         voyage = new ArrayList<Voyage>();
      return voyage;
   }
   
   
   
  
   public void setVoyage(ArrayList<Voyage> newVoyage) {
      removeAllVoyage();
      voyage.addAll(newVoyage);
   }
   
   public void addVoyage(Voyage newVoyage) {
        if (newVoyage != null )this.voyage.add(newVoyage);
   }
   
   public void removeVoyage(Voyage oldVoyage) {
      if (oldVoyage == null)
         return;
      if (this.voyage != null)
         if (this.voyage.contains(oldVoyage))
            this.voyage.remove(oldVoyage);
   }
   
   public void removeAllVoyage() {
      if (voyage != null)
         voyage.clear();
   }

   public ArrayList<Evaluation> getEvaluation() {
      if (evaluation == null)
         evaluation = new ArrayList<Evaluation>();
      return evaluation;
   }

   

   public void setEvaluation(ArrayList<Evaluation> newEvaluation) {
      removeAllEvaluation();
      evaluation.addAll(newEvaluation);
      
   }
   

   public void addEvaluation(Evaluation newEvaluation) {
      if (newEvaluation == null)
         return;
      if (this.evaluation == null)
         this.evaluation = new ArrayList<Evaluation>();
      if (!this.evaluation.contains(newEvaluation))
         this.evaluation.add(newEvaluation);
   }
   

   public void removeEvaluation(Evaluation oldEvaluation) {
      if (oldEvaluation == null)
         return;
      if (this.evaluation != null)
         if (this.evaluation.contains(oldEvaluation))
            this.evaluation.remove(oldEvaluation);
   }
   
   public void removeAllEvaluation() {
      if (evaluation != null)
         evaluation.clear();
   }

}