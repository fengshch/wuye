package cn.southstone.wuye.jfx.controller;

import cn.southstone.wuye.common.dto.ZzjgDto;
import cn.southstone.wuye.jfx.configs.BootInitializable;
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
public class ZzjgController implements BootInitializable{
    private ApplicationContext springContext;

    public static final String REST_SERVICE_URI = "http://localhost:8080/rest";

    @FXML
    private TreeTableView<Zzjg> ttvZzjg;

    @FXML
    private TreeTableColumn<Zzjg,String> ttcName;

    @FXML
    private TreeTableColumn<Zzjg,String> ttcJglb;


    @FXML
    private void addZzjg(ActionEvent event) {

    }

    @FXML
    private void delZzjg(ActionEvent event) {

    }

    @Override
    public Node initView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/zzjg.fxml"));
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

        ZzjgDto zzjgDto = getZzjg();

         /*   final TreeItem<Zzjg> rootItem=new TreeItem<>(new Zzjg("南石集团","公司"));
        final TreeItem<Zzjg> child1Item=new TreeItem<>(new Zzjg("广东分公司","公司"));
        final TreeItem<Zzjg> child2Item=new TreeItem<>(new Zzjg("湖北分公司","公司"));
        final TreeItem<Zzjg> child3Item=new TreeItem<>(new Zzjg("广州公司","公司"));
        final TreeItem<Zzjg> child4Item=new TreeItem<>(new Zzjg("深圳公司","公司"));
        final TreeItem<Zzjg> child5Item=new TreeItem<>(new Zzjg("武汉公司","公司"));
        final TreeItem<Zzjg> child6Item=new TreeItem<>(new Zzjg("佛山公司","公司"));
        final TreeItem<Zzjg> child7Item=new TreeItem<>(new Zzjg("东莞公司","公司"));*/
      //  final TreeItem<Zzjg> rootItem = new TreeItem<>(new Zzjg(zzjgDto.getName(), zzjgDto.getQylb()));

        final TreeItem<Zzjg> rootItem = createTreeItem(zzjgDto);

        rootItem.setExpanded(true);
 /*       rootItem.getChildren().addAll(child1Item, child2Item);
        child1Item.getChildren().addAll(child4Item,child6Item,child7Item);
        child2Item.getChildren().add(child5Item);*/

        ttcName.setCellValueFactory(new TreeItemPropertyValueFactory<Zzjg, String>("name"));
        ttcJglb.setCellValueFactory(new TreeItemPropertyValueFactory<Zzjg, String>("jglb"));

        ttvZzjg.setRoot(rootItem);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.springContext=applicationContext;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {

    }

    private ZzjgDto getZzjg() {
        RestTemplate restTemplate=new RestTemplate();
        ZzjgDto zzjgDto = restTemplate.getForObject(REST_SERVICE_URI + "/zzjg/root", ZzjgDto.class);

        return zzjgDto;
    }

    private TreeItem<Zzjg> createTreeItem(ZzjgDto zzjgDto) {
        final TreeItem<Zzjg> rootItem = new TreeItem<>(new Zzjg(zzjgDto.getName(), zzjgDto.getJglb()));
        for (ZzjgDto child : zzjgDto.getChildren()) {
            final TreeItem<Zzjg> childItem = createTreeItem(child);
            rootItem.getChildren().add(childItem);
        }
        return rootItem;
    }
}
