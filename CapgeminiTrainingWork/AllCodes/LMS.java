import java.util.Scanner;
class User {
    String username;
    String password;

    User(String u, String p) {
        username = u;
        password = p;
    }

    boolean login(String u, String p) {
        return username.equals(u) && password.equals(p);
    }
}

class Course {
    int courseId;
    String courseName;
    String trainerName;

    Course(int id, String name, String trainer) {
        courseId = id;
        courseName = name;
        trainerName = trainer;
    }

    void display() {
        System.out.println(courseId + " - " + courseName + " (Trainer: " + trainerName + ")");
    }
}

class Trainer extends User {
    Course[] courses = new Course[5];
    int courseCount = 0;

    Trainer(String u, String p) {
        super(u, p);
    }

    void createCourse(Scanner sc) {
        if (courseCount >= courses.length) {
            System.out.println("Course limit reached!");
            return;
        }

        System.out.print("Enter Course ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course Name: ");
        String name = sc.nextLine();

        courses[courseCount] = new Course(id, name, username);
        courseCount++;

        System.out.println("✅ Course Created Successfully");
    }

    void viewCourses() {
        if (courseCount == 0) {
            System.out.println("No courses available.");
            return;
        }

        for (int i = 0; i < courseCount; i++) {
            courses[i].display();
        }
    }
}

class Student extends User {
    Course[] enrolledCourses = new Course[5];
    int[] progress = new int[5];
    int enrollCount = 0;

    Student(String u, String p) {
        super(u, p);
    }

    void enrollCourse(Course c) {
        enrolledCourses[enrollCount] = c;
        progress[enrollCount] = 0;
        enrollCount++;
        System.out.println("✅ Enrolled in " + c.courseName);
    }

    void updateProgress(int index, int value) {
        progress[index] = value;
    }

    void viewProgress() {
        if (enrollCount == 0) {
            System.out.println("No enrolled courses.");
            return;
        }

        for (int i = 0; i < enrollCount; i++) {
            System.out.println(enrolledCourses[i].courseName +
                    " → " + progress[i] + "% completed");
        }
    }

    void generateCertificate() {
        for (int i = 0; i < enrollCount; i++) {
            if (progress[i] == 100) {
                System.out.println("\n🎓 CERTIFICATE OF COMPLETION 🎓");
                System.out.println("Student Name : " + username);
                System.out.println("Course       : " + enrolledCourses[i].courseName);
                System.out.println("Trainer      : " + enrolledCourses[i].trainerName);
                System.out.println("Status       : Completed");
                System.out.println("Congratulations!\n");
            }
        }
    }
}

public class LMS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Trainer Registration ===");
        System.out.print("Set Trainer Username: ");
        String tUser = sc.next();
        System.out.print("Set Trainer Password: ");
        String tPass = sc.next();

        Trainer trainer = new Trainer(tUser, tPass);

        System.out.println("\n=== Student Registration ===");
        System.out.print("Set Student Username: ");
        String sUser = sc.next();
        System.out.print("Set Student Password: ");
        String sPass = sc.next();

        Student student = new Student(sUser, sPass);


        while (true) {
            System.out.println("ONLINE LMS");
            System.out.println("1. Trainer Login");
            System.out.println("2. Student Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                sc.nextLine();
                System.out.print("Username: ");
                String u = sc.nextLine();
                System.out.print("Password: ");
                String p = sc.nextLine();

                if (trainer.login(u, p)) {
                    while (true) {
                        System.out.println("\nTrainer Menu");
                        System.out.println("1. Create Course");
                        System.out.println("2. View Courses");
                        System.out.println("3. Logout");
                        int t = sc.nextInt();

                        if (t == 1) trainer.createCourse(sc);
                        else if (t == 2) trainer.viewCourses();
                        else break;
                    }
                } else {
                    System.out.println("❌ Invalid Trainer Login");
                }

            } else if (choice == 2) {
                sc.nextLine();
                System.out.print("Username: ");
                String u = sc.nextLine();
                System.out.print("Password: ");
                String p = sc.nextLine();

                if (student.login(u, p)) {
                    while (true) {
                        System.out.println("\nStudent Menu");
                        System.out.println("1. Enroll Course");
                        System.out.println("2. Update Progress");
                        System.out.println("3. View Progress");
                        System.out.println("4. Generate Certificate");
                        System.out.println("5. Logout");
                        int s = sc.nextInt();

                        if (s == 1) {
                            trainer.viewCourses();
                            System.out.print("Enter course index (0-based): ");
                            int idx = sc.nextInt();
                            student.enrollCourse(trainer.courses[idx]);

                        } else if (s == 2) {
                            System.out.print("Enter enrolled course index: ");
                            int idx = sc.nextInt();
                            System.out.print("Enter progress %: ");
                            int per = sc.nextInt();
                            student.updateProgress(idx, per);

                        } else if (s == 3) {
                            student.viewProgress();

                        } else if (s == 4) {
                            student.generateCertificate();

                        } else break;
                    }
                } else {
                    System.out.println("❌ Invalid Student Login");
                }

            } else {
                System.out.println("Thank You!");
                break;
            }
        }
        sc.close();
    }
}