package day13;

public class Task1 {
    public static void main(String[] args) {

        User user1 = new User("Us1");
        User user2 = new User("Us2");
        User user3 = new User("Us3");

        user1.sendMessage(user2, "Hello, Us2!");
        user1.sendMessage(user2, "How are you?");

        user2.sendMessage(user1, "Hi, Us1!");
        user2.sendMessage(user1, "I'm Us2. Nice to meet you.");
        user2.sendMessage(user1, "I'm fine, and you?");

        user3.sendMessage(user1, "Hey! My name is Us3.");
        user3.sendMessage(user1, "Do you remember me?");
        user3.sendMessage(user1, "We went to the same school.");

        user1.sendMessage(user3, "Hey, Us3. Of course I remember you;");
        user1.sendMessage(user3, "So nice to meet you again.");
        user1.sendMessage(user3, "Let's meet up. Are you free tomorrow?");

        user3.sendMessage(user1, "Yes, I'm free tomorrow. Let's go.");

        MessageDatabase.showDialog(user1, user3);
    }
}
