package com.example.echo;

import java.util.List;
import javax.persistence.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class ManageEquipos {


   private EntityManagerFactory emf;
   private EntityManager entity;


/*
   public static void main(String[] args) {
      try{
         factory = new Configuration().configure().buildSessionFactory();
      }catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
      ManageEmployee ME = new ManageEmployee();

      Integer empID1 = ME.addEmployee("Zara", "Ali", 1000);
      Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
      Integer empID3 = ME.addEmployee("John", "Paul", 10000);

      ME.listEmployees();

      ME.updateEmployee(empID1, 5000);

      ME.deleteEmployee(empID2);

      ME.listEmployees();
   }
   */

   public ManageEquipos(){
      emf = Persistence.createEntityManagerFactory("com.mycompany_mavenproject1_jar_1.0-SNAPSHOTPU");
      entity = emf.createEntityManager();
   }
   /*
   public Integer addEquipo(String nombre, Date anioFundacion, int titulosGanados){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer equipoID = null;
      try{
         tx = session.beginTransaction();
         Equipo eq = new Equipo(nombre, anioFundacion, titulosGanados);
         equipoID = (Integer) session.save(eq); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return equipoID;
   }
   */
   /* Method to  READ all the employees */
   public List<Equipos> listEquipo(){
	   List<Equipos> equipos = null;
      try{

      CriteriaBuilder cb = entity.getCriteriaBuilder();
      CriteriaQuery<Equipos> crit = cb.createQuery(Equipos.class);
      equipos = entity.createQuery(crit).getResultList();
      

      }catch (Exception e) {
         e.printStackTrace(); 
      }finally {

      }
      return equipos;
   }
   /*
   public void updateEquipo(Integer equipoID, int titulosGanados ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Equipo eq = 
                    (Equipo)session.get(Equipo.class, equipoID); 
         eq.setTitulosDeLiga(titulosGanados);
		 session.update(eq); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   public void deleteEquipo(Integer EquipoID){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Equipo eq = 
                   (Equipo)session.get(Equipo.class, EquipoID); 
         session.delete(eq); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   */
}