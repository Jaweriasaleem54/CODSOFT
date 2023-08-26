import java.util.*;

class Node {
    // Data d;
    String name;
    String number;
    String gmail;
    Node prev, next;

    Node(String n, String r, String g) {
        name = n;
        number = r;
        gmail = g;
        next = null;
        prev = null;
    }
}

class list {
    Node head;
    Node temp;
    static Node ptr;
    // Node ptr1, ptr2, dup;
    Scanner so = new Scanner(System.in);
    Scanner sd = new Scanner(System.in);

    list() {

        head = null;
        temp = null;
        ptr = null;
    }

    // ***Inserting contacts in phone book***
    public void insert() {
        String number = null;
        String name;
        String gmail;
        char ans;
        do {
            System.out.println("Enter name");
            name = sd.nextLine();
            System.out.println("Enter number");
            number = sd.nextLine();
            while (number.length() != 11) {
                System.out.println("Enter valid number");
                number = sd.nextLine();
            }
            System.out.println("Enter Gmail: ");
            gmail = sd.nextLine();
            int i = 0;
            temp = new Node(name, number, gmail);
            if (head == null) {
                head = temp;
            } else {
                ptr = head;
                while (ptr.next != null) {
                    ptr = ptr.next;
                }
                ptr.next = temp;
                temp.prev = ptr;
            }
            System.out.println("Do you want to continue??");
            ans = so.next().charAt(0);
        } while (ans == 'y');
    }

    // *****Sorting the contact******
    public void sort() {
        Node i, j;
        int temp;
        String n;
        String k, l;
        for (i = head; i != null; i = i.next) {
            for (j = i.next; j != null; j = j.next) {
                temp = i.name.compareTo(j.name);
                if (temp > 0) {
                    n = i.name;
                    i.name = j.name;
                    j.name = n;
                    k = i.number;
                    i.number = j.number;
                    j.number = k;
                    l = i.gmail;
                    i.gmail = j.gmail;
                    j.gmail = l;
                }
            }
        }
    }

    // *****Display all the contacts*****
    public void display() {
        ptr = head;
        if (ptr == null) {
            System.out.println("No contact Saved");
            System.out.println("Contact list is empty");
        }
        while (ptr != null) {
            System.out.println(ptr.name + "       " + ptr.number + "        " + ptr.gmail);

            ptr = ptr.next;
        }
    }

    // ***Search the contact by number***
    public void searchByNumber() {
        Scanner se = new Scanner(System.in);
        Node searchnode = head;
        String search;
        int count = 0;
        boolean found = false;
        System.out.println("Enter the Number you want to search");
        search = se.nextLine();
        
        while (searchnode != null) {
            if (search.compareTo(searchnode.number) == 0) {
                System.out.println("Contact found ");
                System.out.println("Details are below");
                System.out.println("Name:: " + searchnode.name);
                System.out.println("Number:: " + searchnode.number);
                System.out.println("Gmail:: " + searchnode.gmail);
                found = true;
                break;
            }
            searchnode = searchnode.next;
            count++;
        }
        if (found == false) {
            System.out.println("Desired Contact not found ");
        }
    }

    // _______Search by gmail______
    public void searchBYGmail() {
        Scanner se = new Scanner(System.in);
        Node searchnode = head;
        String search;
        int count = 0;
        boolean found = false;
        System.out.println("Enter the Email you want to search");
        search = se.nextLine();
        // if (ptr == null) {
        // System.out.println("COntact list is empty");
        // }

        while (searchnode != null) {
            if (search.compareTo(searchnode.gmail) == 0) {
                System.out.println("Contact found ");
                System.out.println("Details are below");
                System.out.println("Name:: " + searchnode.name);
                System.out.println("Number:: " + searchnode.number);
                System.out.println("Gmail:: " + searchnode.gmail);
                found = true;
                break;
            }
            searchnode = searchnode.next;
            count++;
        }
        if (found == false) {
            System.out.println("Desired Contact not found ");
        }
    }

    // _______Search by Name______
    public void searchByName() {
        Scanner se = new Scanner(System.in);
        Node searchnode = head;
        String search;
        int count = 0;
        boolean found = false;
        System.out.println("Enter the Name you want to search: ");
        search = se.nextLine();
        
        while (searchnode != null) {
            if (search.compareTo(searchnode.name) == 0) {
                System.out.println("Contact found ");
                System.out.println("Details are below");
                System.out.println("Name:: " + searchnode.name);
                System.out.println("Number:: " + searchnode.number);
                System.out.println("Gmail:: " + searchnode.gmail);
                found = true;
                break;
            }
            searchnode = searchnode.next;
            count++;
        }
        if (found == false) {
            System.out.println("Desired Contact not found ");
        }
    }

    // ******Search contact*****
    public void search_contact() {
        Scanner se = new Scanner(System.in);
        Node searchnode = head;
        String search;
        int count = 0;
        boolean found = false;
        System.out.println("Enter the contact you want to search");
        search = se.nextLine();
        // if (ptr == null) {
        // System.out.println("COntact list is empty");
        // }

        while (searchnode != null) {
            if (search.compareTo(searchnode.name) == 0) {
                System.out.println("Contact found ");
                System.out.println("Details are below");
                System.out.println("Name:: " + searchnode.name);
                System.out.println("Number:: " + searchnode.number);
                System.out.println("Gmail:: " + searchnode.gmail);
                found = true;
                break;
            }
            searchnode = searchnode.next;
            count++;
        }
        if (found == false) {
            System.out.println("Desired Contact not found ");
        }
    }

    // *****DELETE CONTACT******
    public void deletecontact() {
        Node node = head;
        String s;
        System.out.println("Enter the contact you want to search");
        s = sd.nextLine();
        while (node != null) {
            if (s.compareTo(node.name) == 0 && node != head && node.next != null) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                System.out.println("your contact is successfully deleted");
                break;
            }
            if (node == head && s.compareTo(node.name) == 0) {
                head = head.next;
                node.prev = null;
                System.out.println("your contact is successfully deleted");
                break;
            }
            if (s.compareTo(node.name) == 0 && node.next == null) {
                node.prev.next = null;
                node.prev = null;
                node = null;
                System.out.println("your contact is successfully deleted");
                break;
            }
            node = node.next;
        }
    }

    // *******Update******
    public void update() {
        char ans;
        int c;
        Node ptr = head;
        String n;
        System.out.println("Enter the Name of Person Whose Details You Want To Update: ");
        n = sd.nextLine();
        while (ptr != null) {
            if (n.equals(ptr.name)) {
                do {
                    sd.nextLine();
                    System.out.println("What do you want to update");
                    System.out.println("1) Name");
                    System.out.println("2) Phone number");
                    System.out.println("3) Gmail");
                    c = sd.nextInt();
                    switch (c) {
                        case 1:
                            sd.nextLine();
                            System.out.println("Enter Name: ");
                            ptr.name = sd.nextLine();
                            break;
                        case 2:
                            System.out.println("Enter Number: ");
                            ptr.number = so.nextLine();
                            break;
                        case 3:
                            sd.nextLine();
                            System.out.println("Enter Gmail : ");
                            ptr.gmail = sd.nextLine();
                            break;
                    }
                    System.out.println("Do you want to continue ?");
                    ans = so.next().charAt(0);

                } while (ans == 'y');
            }
            ptr = ptr.next;
        }
    }
}

public class AddressBookSystem {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner sp = new Scanner(System.in);
        list l1 = new list();
        String name;
        String n;
        String number;
        String gmail;
        char ans;
        int ch, a;
        System.out.println("**********Phone book***********");
        System.out.println("What is your name");
        name = sp.nextLine();
        System.out.println("!!!!!!!WELCOME " + name + "!!!!!!!!");
        System.out.println("Let's create our phonebook " + name);

        do {
            System.out.println("1)Display Your Phone Book");
            System.out.println("2)Insert New Contact");
            System.out.println("3)Update Details on Existing Contact");
            System.out.println("4)Delete Contact");
            System.out.println("5)Search contact");
            System.out.println("6) search by choice(name,number,gmail)");

            ch = sp.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Name        Phone Number          gmail");
                    l1.display();
                    break;
                case 2:
                    l1.insert();
                    l1.sort();
                    break;

                case 3:
                    l1.update();
                    l1.sort();
                    break;

                case 4:
                    l1.deletecontact();
                    break;
                case 5:
                    l1.search_contact();
                    break;
                case 6:
                    do {
                        System.out.println("1) Search by name ");
                        System.out.println("2) Search by Phone num ");
                        System.out.println("3) Search by Gmail ");
                        a = sp.nextInt();
                        switch (a) {
                            case 1:
                                System.out.println("Enter the name you want to search ");
                                name = sp.nextLine();
                                l1.searchByName();
                                break;
                            case 2:
                                l1.searchByNumber();
                                break;
                            case 3:
                                l1.searchBYGmail();
                                break;

                        }
                        System.out.println("Do you want to continue searching y/n");
                        ans = sp.next().charAt(0);

                    } while (ans == 'y');
                    break;
                default:
                    System.out.println("invalid options");

            }

            System.out.println("Do you want to continue Operations y/n????");
            ans = sp.next().charAt(0);

        } while (ans == 'y');

    }
}