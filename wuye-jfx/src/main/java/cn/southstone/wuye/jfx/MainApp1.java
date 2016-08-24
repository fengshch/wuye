package cn.southstone.wuye.jfx;/**
 * Created by fengs on 2016/8/24.
 */

import cn.southstone.wuye.jfx.controller.JRViewerController;
import cn.southstone.wuye.jfx.jasper.JRViewerMode;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.sf.jasperreports.engine.*;

import java.io.IOException;
import java.util.HashMap;

import static com.ibm.icu.impl.PluralRulesLoader.loader;

public class MainApp1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        try {
            //  BorderPane borderPane=(BorderPane)jrViewerController.initView();

            JasperPrint jasperPrint = null;

            JasperReport report = JasperCompileManager
                    .compileReport(getClass().getResource("/jasper/Blank_A4.jrxml").getFile());
            jasperPrint = JasperFillManager.fillReport(report, new HashMap(),  new JREmptyDataSource());

            FXMLLoader loader = new FXMLLoader();
            Parent borderPane=loader.load(getClass().getResourceAsStream("/fxml/JRViewer.fxml"));
            //loader.setController(springContext.getBean(this.getClass()));
            // loader.setController(cn.southstone.wuye.jfx.controller.JRViewerController);


            // BorderPane borderPane=(BorderPane)jrViewerController.initView();

            Object o = loader.getController();
            if(o instanceof JRViewerController){
                JRViewerController jrViewerController = (JRViewerController)   o;
                jrViewerController.setJasperPrint(jasperPrint);
                jrViewerController.setJasperPrint(jasperPrint);
                jrViewerController.setPrintMode(JRViewerMode.REPORT_VIEW);
                jrViewerController.show();
            }

            final Stage stage = new Stage(StageStyle.TRANSPARENT);

            //create root node of scene, i.e. group
            Group rootGroup = new Group();

            //create scene with set width, height and color
            Scene scene = new Scene(borderPane);

            //set scene to stage
            stage.setScene(scene);

            //center stage on screen
            stage.centerOnScreen();

            //show the stage
            stage.show();


        } catch (Exception e) {

        }
    }
}
