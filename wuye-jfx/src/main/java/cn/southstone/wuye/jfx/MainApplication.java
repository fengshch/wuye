package cn.southstone.wuye.jfx;

import cn.southstone.wuye.jfx.controller.MainController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

/**
 * Created by fengs on 2016/8/19.
 */
@SpringBootApplication
public class MainApplication extends Application{
    private ConfigurableApplicationContext springContext;
    private static String[] args;

    @Bean
    public Stage getStage(){
        Stage newStage = new Stage(StageStyle.DECORATED);
        newStage.setTitle("物业管理系统");
        return  newStage;
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        Platform.exit();
        springContext.close();
    }

    public static void main(String[] args) {
        MainApplication.args=args;
        launch(MainApplication.class,args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Task<Object> worker=new Task<Object>() {

            @Override
            protected Object call() throws Exception {
                springContext = SpringApplication.run(MainApplication.class, MainApplication.args);
                return null;
            }
        };

        worker.run();

        worker.setOnSucceeded((WorkerStateEvent)->{
            Stage stage = springContext.getBean(Stage.class);

            MainController mainController = springContext.getBean(MainController.class);

            Parent parent= null;
            try {
                parent = (Parent) mainController.initView();
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setScene(new Scene(parent));
            stage.show();
        });
    }

}
