package cn.southstone.wuye.jfx.controller;

import cn.southstone.wuye.jfx.configs.BootInitializable;
import cn.southstone.wuye.jfx.jasper.JRViewerMode;
import cn.southstone.wuye.jfx.model.Dyqy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.sf.jasperreports.engine.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * Created by fengs on 2016/8/19.
 */
@Component
public class MainController  implements BootInitializable{
    private ApplicationContext springContext;

    @Autowired
    private ZzjgController zzjgController;

    @Autowired
    private DyqyController dyqyController;

    @Autowired
    private WyzyController wyzyController;

    @Autowired
    private FkgxController fkgxController;

    @Autowired
    private SfxmController sfxmController;

    @Autowired
    private BzxyController bzxyController;

    @Autowired
    private JRViewerController jrViewerController;

    @FXML
    private TabPane mainTabPane;

    @FXML
    private MenuItem mniZzjg;

    @FXML
    private MenuItem mniDyqy;

    @FXML
    private MenuItem mniWyzy;

    @FXML
    private MenuItem minReport;




    @FXML
    private void showZzjg(ActionEvent event) {
        Tab tab = new Tab("组织机构");


        try {
            BorderPane borderPane=(BorderPane)zzjgController.initView();

            tab.setContent(borderPane);

            mainTabPane.getTabs().add(tab);
            mainTabPane.getSelectionModel().select(tab);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void showDyqy(ActionEvent event) {
        Tab tab = new Tab("资源结构");


        try {
            BorderPane borderPane=(BorderPane)dyqyController.initView();

            tab.setContent(borderPane);

            mainTabPane.getTabs().add(tab);
            mainTabPane.getSelectionModel().select(tab);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void showWyzy(ActionEvent event) {
        Tab tab = new Tab("物业资源");


        try {
            BorderPane borderPane=(BorderPane)wyzyController.initView();

            tab.setContent(borderPane);

            mainTabPane.getTabs().add(tab);
            mainTabPane.getSelectionModel().select(tab);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void showFkgx(ActionEvent event) {
        Tab tab = new Tab("房客关系");


        try {
            BorderPane borderPane=(BorderPane)fkgxController.initView();

            tab.setContent(borderPane);

            mainTabPane.getTabs().add(tab);
            mainTabPane.getSelectionModel().select(tab);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void showSfxm(ActionEvent event) {
        Tab tab = new Tab("收费项目和收费标准");


        try {
            BorderPane borderPane=(BorderPane)sfxmController.initView();

            tab.setContent(borderPane);

            mainTabPane.getTabs().add(tab);
            mainTabPane.getSelectionModel().select(tab);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void showBzxy(ActionEvent event) {
        Tab tab = new Tab("收费标准选用");


        try {
            BorderPane borderPane=(BorderPane)bzxyController.initView();

            tab.setContent(borderPane);

            mainTabPane.getTabs().add(tab);
            mainTabPane.getSelectionModel().select(tab);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void showReport(ActionEvent event) {
        Tab tab = new Tab("报表测试");


        try {
            BorderPane borderPane=(BorderPane)jrViewerController.initView();
            tab.setContent(borderPane);
            mainTabPane.getTabs().add(tab);
            mainTabPane.getSelectionModel().select(tab);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Node initView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        loader.setController(springContext.getBean(this.getClass()));
        return loader.load();
    }

    @Override
    public void setStage(Stage stage) {

    }

    @Override
    public void initConstuct() {

    }

    @Override
    public void initIcons() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.springContext=applicationContext;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {

    }
}
