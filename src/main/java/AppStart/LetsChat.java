package AppStart;

import com.myapp.hellothere.LoginPage;
import javafx.application.Application;
import javafx.stage.Stage;

public class LetsChat extends Application{

  public void start(Stage stage) throws  Exception{
      LoginPage loginPage = new LoginPage();
      loginPage.start(stage);
  }
}
