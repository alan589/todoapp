/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package TodoApp;

import TodoApp.view.LoginScreen;
import TodoApp.view.MainScreen;


public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        //new MainScreen().setVisible(true);
        new LoginScreen().setVisible(true);
    }
}
