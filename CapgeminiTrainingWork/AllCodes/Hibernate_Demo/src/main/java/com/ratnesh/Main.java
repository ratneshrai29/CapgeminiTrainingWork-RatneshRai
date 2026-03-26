package com.ratnesh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        //-------------------------------------------------------------------------------
        // To store data

        Student s1 = new Student();
        s1.setId(4);
        s1.setName("Ratnesh");
        s1.setTech("Cloud");

        //        Hey Hiberante save thi s1 object
        // -------------------------------------------------------------------------------------



//        Configuration config = new Configuration();
//        config.addAnnotatedClass(com.ratnesh.Student.class);
//        config.configure("hibernate.cfg.xml");  // to  load the file
//        SessionFactory factory = config.buildSessionFactory();

        SessionFactory factory = new Configuration()
                .addAnnotatedClass(com.ratnesh.Student.class)
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();  // It needed while updating, saving and deleting but for not fetching

        session.persist(s1);     //   persist = save , to insert , to save the data

//        Student s1 = session.find(Student.class,3);   // get = find   // Eager fetching
//        Student s1 = session.byId(Student.class).load(103); // Eager fetching
//        Student s1 = session.byId(Student.class).getReference(103);  // lazy fetching


//        session.merge(s1);  // to update

//        Student s2 = session.find(Student.class,4);
//        session.remove(s2);

        transaction.commit();

//        System.out.println(s1);

        session.close();
        factory.close();
    }
}