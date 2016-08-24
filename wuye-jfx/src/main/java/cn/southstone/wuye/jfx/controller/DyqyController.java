package cn.southstone.wuye.jfx.controller;

import cn.southstone.wuye.common.dto.DyqyDto;
import cn.southstone.wuye.common.dto.ZzjgDto;
import cn.southstone.wuye.jfx.configs.BootInitializable;
import cn.southstone.wuye.jfx.model.Dyqy;
import cn.southstone.wuye.jfx.model.Zzjg;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.stage.Stage;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by fengs on 2016/8/19.
 */
@Component
public class DyqyController implements BootInitializable{
    private ApplicationContext springContext;

    public static final String REST_SERVICE_URI = "http://localhost:8080/rest";

    @FXML
    private TreeTableView<Dyqy> ttvDyqy;

    @FXML
    private TreeTableColumn<Dyqy,String> ttcName;

    @FXML
    private TreeTableColumn<Dyqy,String> ttcQylb;


    @FXML
    private void addDyqy(ActionEvent event) {

    }

    @FXML
    private void delDyqy(ActionEvent event) {

    }

    @Override
    public Node initView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dyqy.fxml"));
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

        ttcName.setCellValueFactory(new TreeItemPropertyValueFactory<Dyqy, String>("name"));
        ttcQylb.setCellValueFactory(new TreeItemPropertyValueFactory<Dyqy, String>("qylb"));

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
