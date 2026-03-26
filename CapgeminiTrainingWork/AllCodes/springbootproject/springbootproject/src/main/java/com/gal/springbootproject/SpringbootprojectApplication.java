package com.gal.springbootproject;

import com.gal.springbootproject.dao.UserDao;
import com.gal.springbootproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringbootprojectApplication implements CommandLineRunner {
    @Autowired
    private UserDao userDao;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootprojectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // -----------------INSERTION----------------
//		User user1 = new User("Aman","aman@gmail.com","male","Delhi");
////		User user2 = new User("Ayush","ayush@gmail.com","male","Pune");
//		boolean status = userDao.insertUser(user1);
//		if(status){
//			System.out.println("User inserted successfully");
//		}
//		else {
//			System.out.println("Error occured");
//		}


        // ---------------UPDATION 1----------------
//		User user = new User("Aman","aman@gmail.com","male","Prayagraj");
//		boolean status = userDao.updateUser(user);
//		if(status){
//			System.out.println("User updation successfully");
//		}
//		else {
//			System.out.println("Error occured");
//		}
        // ---------------UPDATION 2----------------
		User user = userDao.getUserByEmail("aman@gmail.com");
		user.setCity("Prayagraj");
		boolean status = userDao.updateUser(user);
		if(status){
			System.out.println("User updation successfully");
		}
		else {
			System.out.println("Error occured");
		}

        // --------------------DELETION--------------
//		boolean status = userDao.deleteUserByEmail("aman@gmail.com");
//		if(status){
//			System.out.println("Deletion successfully");
//		}
//		else {
//			System.out.println("Error occured");
//		}


        //-------------------SELECT ONE USER-----------------
//		User user = userDao.getUserByEmail("aman@gmail.com");
//		System.out.println("Name : "+user.getName());
//		System.out.println("Email : "+user.getEmail());
//		System.out.println("City : "+user.getCity());
//		System.out.println("Gender : "+user.getGender());

        // ------------------SELECT ALL USERS----------------------
//        List<User> list = userDao.getAllUsers();
//        for (User user : list) {
//            System.out.println("Name : " + user.getName());
//            System.out.println("Email : " + user.getEmail());
//            System.out.println("City : " + user.getCity());
//            System.out.println("Gender : " + user.getGender());
//            System.out.println("-------------------------");
//        }


    }
}
