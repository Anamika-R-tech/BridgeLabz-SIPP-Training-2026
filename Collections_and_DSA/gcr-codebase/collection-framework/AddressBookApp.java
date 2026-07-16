import java.util.*;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

public class AddressBookApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Contact> contacts = new ArrayList<>();
        HashMap<String, Contact> nameMap = new HashMap<>();
        HashSet<String> phoneSet = new HashSet<>();

        while (true) {
            System.out.println("\n1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Sorted Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    if (phoneSet.contains(phone)) {
                        System.out.println("Duplicate phone number not allowed.");
                    } else {
                        Contact c = new Contact(name, phone, email);
                        contacts.add(c);
                        nameMap.put(name, c);
                        phoneSet.add(phone);
                        System.out.println("Contact added successfully.");
                    }
                    break;

                case 2:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();

                    if (nameMap.containsKey(searchName)) {
                        System.out.println(nameMap.get(searchName));
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter name to delete: ");
                    String deleteName = sc.nextLine();

                    if (nameMap.containsKey(deleteName)) {
                        Contact c = nameMap.get(deleteName);
                        contacts.remove(c);
                        phoneSet.remove(c.phone);
                        nameMap.remove(deleteName);
                        System.out.println("Contact deleted successfully.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    Collections.sort(contacts, (a, b) -> a.name.compareToIgnoreCase(b.name));

                    System.out.println("Sorted Contacts:");
                    for (Contact c : contacts) {
                        System.out.println(c);
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}