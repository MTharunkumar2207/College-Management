package CollegeManage;
import java.util.*;

class College {
    private int collegeId;
    private String collegeName;
    private String location;

    College(int collegeId, String collegeName, String location) {
        this.collegeId = collegeId;
        this.collegeName = collegeName;
        this.location = location;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getLocation() {
        return location;
    }

    public String toString() {
        return collegeId + " " + collegeName + " " + location;
    }
}

public class CollegeManage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<College> colleges = new ArrayList<College>();
	        try (Scanner Scanner = new Scanner(System.in);
					Scanner Scanner1 = new Scanner(System.in)) {
				int choice;
				
				do {
				    System.out.println("1 INSERT");
				    System.out.println("2 DISPLAY");
				    System.out.println("3 SEARCH");
				    System.out.println("4 DELETE");
				    System.out.println("5 UPDATE");
				    System.out.print("Enter your choice: ");
				    choice = Scanner.nextInt();

				    switch (choice) {
				        case 1:
				            System.out.print("Enter college ID: ");
				            int collegeId = Scanner.nextInt();
				            Scanner.nextLine(); // Clear buffer
				            System.out.print("Enter college name: ");
				            String collegeName = Scanner1.nextLine();
				            System.out.print("Enter college location: ");
				            String location = Scanner1.nextLine();
				            colleges.add(new College(collegeId, collegeName, location));
				            System.out.println("-----------------------");
				            System.out.println("College Inserted successfully");
				            System.out.println("-----------------------");
				            break;

				        case 2:
				            System.out.println("-----------------------");
				            Iterator<College> iterator = colleges.iterator();
				            while (iterator.hasNext()) {
				                College c = iterator.next();
				                System.out.println(c);
				            }
				            System.out.println("-----------------------");
				            break;

				        case 3:
				            boolean found = false;
				            System.out.print("Enter college ID: ");
				            collegeId = Scanner.nextInt();
				            iterator = colleges.iterator();
				            while (iterator.hasNext()) {
				                College c = iterator.next();
				                if (c.getCollegeId() == collegeId) {
				                    found = true;
				                    System.out.println("-----------------------");
				                    System.out.println(c);
				                }
				            }
				            if (!found) {
				                System.out.println("-----------------------");
				                System.out.println("College not found");
				            }
				            System.out.println("-----------------------");
				            break;

				        case 4:
				            found = false;
				            System.out.print("Enter college ID to delete: ");
				            collegeId = Scanner.nextInt();
				            iterator = colleges.iterator();
				            while (iterator.hasNext()) {
				                College c = iterator.next();
				                if (c.getCollegeId() == collegeId) {
				                    iterator.remove();
				                    found = true;
				                }
				            }
				            if (!found) {
				                System.out.println("-----------------------");
				                System.out.println("College not found");
				            } else {
				                System.out.println("-----------------------");
				                System.out.println("College Deleted successfully");
				            }
				            System.out.println("-----------------------");
				            break;

				        case 5:
				            found = false;
				            System.out.print("Enter college ID to update: ");
				            collegeId = Scanner.nextInt();
				            ListIterator<College> listIterator = colleges.listIterator();
				            while (listIterator.hasNext()) {
				                College c = listIterator.next();
				                if (c.getCollegeId() == collegeId) {
				                    Scanner.nextLine(); // Clear buffer
				                    System.out.print("Enter new college name: ");
				                    collegeName = Scanner1.nextLine();
				                    System.out.print("Enter new college location: ");
				                    location = Scanner1.nextLine();
				                    listIterator.set(new College(collegeId, collegeName, location));
				                    found = true;
				                }
				            }
				            if (!found) {
				                System.out.println("-----------------------");
				                System.out.println("College Record not found");
				            } else {
				                System.out.println("College Updated successfully");
				            }
				            System.out.println("-----------------------");
				            break;
				    }
				} while (choice != 0);
			}

	}

}
