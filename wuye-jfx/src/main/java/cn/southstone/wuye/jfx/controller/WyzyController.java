package cn.southstone.wuye.jfx.controller;

import cn.southstone.wuye.common.dto.DyqyDto;
import cn.southstone.wuye.jfx.configs.BootInitializable;
import cn.southstone.wuye.jfx.model.Dyqy;
import cn.southstone.wuye.jfx.model.Wyzy;
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
import java.util.ResourceBundle;
import java.util.Set;

/**
 * Created by fengs on 2016/8/19.
 */
@Component
public class WyzyController implements BootInitializable{
    private ApplicationContext springContext;

    public static final String REST_SERVICE_URI = "http://localhost:8080/rest";

    @FXML
    private TreeTableView<Dyqy> ttvDyqy;


    @FXML
    private TreeTableColumn<Dyqy,String> ttcId;

    @FXML
    private TreeTableColumn<Dyqy,String> ttcName;

    @FXML
    private TreeTableColumn<Dyqy,String> ttcQylb;


    @FXML
    private TableView<Wyzy> tvWyzy;

    @FXML
    private TableColumn<Wyzy,String> tcNo;

    @FXML
    private TableColumn<Wyzy,String> tcName;

    @FXML
    private TableColumn<Wyzy,String> tcZylb;


    @FXML
    private TableColumn<Wyzy,Double> tcJzmj;

    @FXML
    private TableColumn<Wyzy,Double> tcSfmj;

    @Override
    public Node initView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/wyzy.fxml"));
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

        DyqyDto dyqyDto = getDyqy();

         /*   final TreeItem<Zzjg> rootItem=new TreeItem<>(new Zzjg("南石集团","公司"));
        final TreeItem<Zzjg> child1Item=new TreeItem<>(new Zzjg("广东分公司","公司"));
        final TreeItem<Zzjg> child2Item=new TreeItem<>(new Zzjg("湖北分公司","公司"));
        final TreeItem<Zzjg> child3Item=new TreeItem<>(new Zzjg("广州公司","公司"));
        final TreeItem<Zzjg> child4Item=new TreeItem<>(new Zzjg("深圳公司","公司"));
        final TreeItem<Zzjg> child5Item=new TreeItem<>(new Zzjg("武汉公司","公司"));
        final TreeItem<Zzjg> child6Item=new TreeItem<>(new Zzjg("佛山公司","公司"));
        final TreeItem<Zzjg> child7Item=new TreeItem<>(new Zzjg("东莞公司","公司"));*/
      //  final TreeItem<Zzjg> rootItem = new TreeItem<>(new Zzjg(zzjgDto.getName(), zzjgDto.getQylb()));

        final TreeItem<Dyqy> rootItem = createTreeItem(dyqyDto);

        rootItem.setExpanded(true);
 /*       rootItem.getChildren().addAll(child1Item, child2Item);
        child1Item.getChildren().addAll(child4Item,child6Item,child7Item);
        child2Item.getChildren().add(child5Item);*/

        ttcId.setCellValueFactory(new TreeItemPropertyValueFactory<Dyqy, String>("id"));
        ttcName.setCellValueFactory(new TreeItemPropertyValueFactory<Dyqy, String>("name"));
        ttcQylb.setCellValueFactory(new TreeItemPropertyValueFactory<Dyqy, String>("qylb"));
        ttvDyqy.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        tcNo.setCellValueFactory(new PropertyValueFactory<Wyzy, String>("no"));
        tcName.setCellValueFactory(new PropertyValueFactory<Wyzy, String>("name"));
        tcZylb.setCellValueFactory(new PropertyValueFactory<Wyzy, String>("zylb"));
        tcJzmj.setCellValueFactory(new PropertyValueFactory<Wyzy, Double>("jzmj"));
        tcSfmj.setCellValueFactory(new PropertyValueFactory<Wyzy, Double>("sfmj"));

        ttvDyqy.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<Dyqy>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<Dyqy>> observable, TreeItem<Dyqy> oldValue, TreeItem<Dyqy> newValue) {
                tvWyzy.getItems().clear();

                RestTemplate restTemplate = new RestTemplate();

                long dyqyId=newValue.getValue().getId();

                Set<LinkedHashMap<String,Object>> wyziesMap = restTemplate.getForObject(REST_SERVICE_URI + "/dyqy/" + dyqyId + "/wyzies", Set.class);

                final ObservableList<Wyzy> wyzies= FXCollections.observableArrayList();


                if (wyzies != null) {
                    for (LinkedHashMap<String,Object> map: wyziesMap) {
                        Wyzy wyzy = new Wyzy(Long.valueOf((Integer)map.get("id")),(String)map.get("no"),(String)map.get("name"),(String)map.get("zylb"));
                        wyzy.setDescription((String)map.get("description"));
                        wyzy.setJzmj((double)map.get("jzmj"));
                        wyzy.setSfmj((double)map.get("sfmj"));
                        wyzy.setDyqyId(Long.valueOf((Integer)map.get("dyqyId")));

                        wyzies.add(wyzy);

                    }

                    tvWyzy.setItems(wyzies);
                }

            }
        });
        ttvDyqy.setRoot(rootItem);


    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.springContext=applicationContext;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {

    }

    private DyqyDto getDyqy() {
        RestTemplate restTemplate=new RestTemplate();
        DyqyDto dyqyDto = restTemplate.getForObject(REST_SERVICE_URI + "/dyqy/root", DyqyDto.class);

        return dyqyDto;
    }

    private TreeItem<Dyqy> createTreeItem(DyqyDto dyqyDto) {
        final TreeItem<Dyqy> rootItem = new TreeItem<Dyqy>(new Dyqy(dyqyDto.getId(),dyqyDto.getName(), dyqyDto.getQylb()));
        for (DyqyDto child : dyqyDto.getChildren()) {
            final TreeItem<Dyqy> childItem = createTreeItem(child);
            rootItem.getChildren().add(childItem);
        }
        return rootItem;
    }
}
