package cn.southstone.wuye.jfx.controller;

import cn.southstone.wuye.common.dto.QyzyDto;
import cn.southstone.wuye.jfx.configs.BootInitializable;
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
public class FkgxController implements BootInitializable{
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
    private TableView<Fkgx> tvFkgx;

    @FXML
    private TableColumn<Fkgx,String> tcKhNo;

    @FXML
    private TableColumn<Fkgx,String> tcKhName;

    @FXML
    private TableColumn<Fkgx,Boolean> tcSfsf;

    @FXML
    private TableColumn<Fkgx,String> tcKssfrq;

    @FXML
    private TableColumn<Fkgx,String> tcJssfrq;

    @Override
    public Node initView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/fkgx.fxml"));
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

        tcKhNo.setCellValueFactory(new PropertyValueFactory<Fkgx, String>("khNo"));
        tcKhName.setCellValueFactory(new PropertyValueFactory<Fkgx, String>("khName"));
        tcSfsf.setCellValueFactory(new PropertyValueFactory<Fkgx,Boolean>("sfsf"));
        tcKssfrq.setCellValueFactory(new PropertyValueFactory<Fkgx,String>("kssfrq"));
        tcJssfrq.setCellValueFactory(new PropertyValueFactory<Fkgx, String>("jssfrq"));

        ttvQyzy.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<Qyzy>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<Qyzy>> observable, TreeItem<Qyzy> oldValue, TreeItem<Qyzy> newValue) {
                tvFkgx.getItems().clear();
                RestTemplate restTemplate = new RestTemplate();
                long id = newValue.getValue().getId();
                String lb=newValue.getValue().getLb();

                List<LinkedHashMap<String, Object>> fkgxesMap = restTemplate.getForObject(REST_SERVICE_URI + "/qyzy/" + id + "/fkgxes?lb="+lb, List.class);
                final ObservableList<Fkgx> fkgxes=FXCollections.observableArrayList();

                for(LinkedHashMap<String,Object> map:fkgxesMap)
                {
                    Fkgx fkgx = new Fkgx(Long.valueOf((Integer)map.get("id")),(String)map.get("khNo"),(String) map.get("khName"));
                    fkgx.setSfsf((Boolean) map.get("sfsf"));
                    fkgx.setKssfrq((String) map.get("ksfrq"));
                    fkgx.setJssfrq((String) map.get("jssfrq"));
                    fkgxes.add(fkgx);

                }

                tvFkgx.setItems(fkgxes);
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
