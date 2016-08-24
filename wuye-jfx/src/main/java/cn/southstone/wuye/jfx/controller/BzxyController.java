package cn.southstone.wuye.jfx.controller;

import cn.southstone.wuye.common.dto.QyzyDto;
import cn.southstone.wuye.jfx.configs.BootInitializable;
import cn.southstone.wuye.jfx.model.Bzxy;
import cn.southstone.wuye.jfx.model.Fkgx;
import cn.southstone.wuye.jfx.model.Qyzy;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.stage.Stage;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by fengs on 2016/8/19.
 */
@Component
public class BzxyController implements BootInitializable{
    private ApplicationContext springContext;

    public static final String REST_SERVICE_URI = "http://localhost:8080/rest";

    @FXML
    private TreeTableView<Qyzy> ttvQyzy;


    @FXML
    private TreeTableColumn<Qyzy,Long> ttcId;

    @FXML
    private TreeTableColumn<Qyzy,String> ttcName;

    @FXML
    private TreeTableColumn<Qyzy,String> ttcLb;


    @FXML
    private TableView<Bzxy> tvBzxy;

    @FXML
    private TableColumn<Bzxy,String> tcKhNo;

    @FXML
    private TableColumn<Bzxy,String> tcKhName;

    @FXML
    private TableColumn<Bzxy,String> tcSfxmName;

    @FXML
    private TableColumn<Bzxy,String> tcSfbzName;

    @FXML
    private TableColumn<Bzxy,Boolean> tcSfsf;

    @FXML
    private TableColumn<Bzxy,String> tcKssfrq;

    @FXML
    private TableColumn<Bzxy,String> tcJssfrq;

    @FXML
    private TableColumn<Bzxy,Long> tcFkgxId;

    @FXML
    private TableColumn<Bzxy,Long> tcId;

    @FXML
    private TableColumn<Bzxy,Long> tcSfbzId;



    @Override
    public Node initView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/bzxy.fxml"));
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
    @SuppressWarnings("unchecked")
    public void initialize(URL location, ResourceBundle resources) {

        QyzyDto qyzyDto = getQyzy();

        final TreeItem<Qyzy> rootItem = createTreeItem(qyzyDto);

        rootItem.setExpanded(true);
 /*       rootItem.getChildren().addAll(child1Item, child2Item);
        child1Item.getChildren().addAll(child4Item,child6Item,child7Item);
        child2Item.getChildren().add(child5Item);*/

        ttcId.setCellValueFactory(new TreeItemPropertyValueFactory<Qyzy,Long>("id"));
        ttcName.setCellValueFactory(new TreeItemPropertyValueFactory<Qyzy, String>("name"));
        ttcLb.setCellValueFactory(new TreeItemPropertyValueFactory<Qyzy, String>("lb"));
        ttvQyzy.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        tcKhNo.setCellValueFactory(new PropertyValueFactory<Bzxy, String>("khNo"));
        tcKhName.setCellValueFactory(new PropertyValueFactory<Bzxy, String>("khName"));
        tcSfxmName.setCellValueFactory(new PropertyValueFactory<Bzxy, String>("sfxmName"));
        tcSfbzName.setCellValueFactory(new PropertyValueFactory<Bzxy, String>("sfbzName"));
        tcSfsf.setCellValueFactory(new PropertyValueFactory<Bzxy, Boolean>("sfsf"));

        tcKssfrq.setCellValueFactory(new PropertyValueFactory<Bzxy,String>("kssfrq"));
        tcJssfrq.setCellValueFactory(new PropertyValueFactory<Bzxy, String>("jssfrq"));
        tcFkgxId.setCellValueFactory(new PropertyValueFactory<Bzxy, Long>("fkgxId"));
        tcSfbzId.setCellValueFactory(new PropertyValueFactory<Bzxy, Long>("sfbzId"));
        tcId.setCellValueFactory(new PropertyValueFactory<Bzxy, Long>("id"));

        ttvQyzy.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<Qyzy>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<Qyzy>> observable, TreeItem<Qyzy> oldValue, TreeItem<Qyzy> newValue) {
                tvBzxy.getItems().clear();
                RestTemplate restTemplate = new RestTemplate();
                long id = newValue.getValue().getId();
                String lb=newValue.getValue().getLb();

                List<LinkedHashMap<String, Object>> fkgxesMap = restTemplate.getForObject(REST_SERVICE_URI + "/qyzy/" + id + "/bzxies?lb="+lb, List.class);
                final ObservableList<Bzxy> bzxies=FXCollections.observableArrayList();

                for(LinkedHashMap<String,Object> map:fkgxesMap)
                {
                    Bzxy bzxy = new Bzxy(Long.valueOf((Integer)map.get("id")),Long.valueOf((Integer)map.get("fkgxId")),Long.valueOf((Integer)map.get("sfbzId")));
                    bzxy.setKhNo((String) map.get("khNo"));
                    bzxy.setKhName((String) map.get("khName"));
                    bzxy.setSfxmName((String) map.get("sfxmName"));
                    bzxy.setSfbzName((String) map.get("sfbzName"));

                    bzxy.setSfsf((Boolean) map.get("sfsf"));
                    bzxy.setKssfrq((String) map.get("ksfrq"));
                    bzxy.setJssfrq((String) map.get("jssfrq"));
                    bzxies.add(bzxy);

                }

                tvBzxy.setItems(bzxies);
            }
        });




        ttvQyzy.setRoot(rootItem);


    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.springContext=applicationContext;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {

    }

    private QyzyDto getQyzy() {
        RestTemplate restTemplate=new RestTemplate();
        QyzyDto qyzyDto= restTemplate.getForObject(REST_SERVICE_URI + "/qyzy/root", QyzyDto.class);

        return qyzyDto;
    }

    private TreeItem<Qyzy> createTreeItem(QyzyDto qyzyDto) {
        final TreeItem<Qyzy> rootItem = new TreeItem<Qyzy>(new Qyzy(qyzyDto.getId(),qyzyDto.getName(),qyzyDto.getLb()));
        for (QyzyDto child : qyzyDto.getChildren()) {
            final TreeItem<Qyzy> childItem = createTreeItem(child);
            rootItem.getChildren().add(childItem);
        }
        return rootItem;
    }
}
