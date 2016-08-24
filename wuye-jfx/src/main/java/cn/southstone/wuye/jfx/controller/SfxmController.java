package cn.southstone.wuye.jfx.controller;

import cn.southstone.wuye.jfx.configs.BootInitializable;
import cn.southstone.wuye.jfx.model.Sfbz;
import cn.southstone.wuye.jfx.model.Sfxm;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
public class SfxmController implements BootInitializable{
    private ApplicationContext springContext;

    public static final String REST_SERVICE_URI = "http://localhost:8080/rest";

    @FXML
    private TableView<Sfxm> tvSfxm;


    @FXML
    private TableColumn<Sfxm, Long> tcSfxmId;

    @FXML
    private  TableColumn<Sfxm,String> tcSfxmName;

    @FXML
    private  TableColumn<Sfxm,String> tcSfxmDescription;


    @FXML
    private TableView<Sfbz> tvSfbz;

    @FXML
    private TableColumn<Sfbz,String> tcSfbzName;

    @FXML
    private TableColumn<Sfbz,String> tcFormula;

    @FXML
    private TableColumn<Sfbz,String> tcSfbzDescription;

    @FXML
    private TableColumn<Sfbz,Long> tcSfbzId;



    @Override
    public Node initView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sfxm.fxml"));
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

        RestTemplate restTemplate=new RestTemplate();
        List<LinkedHashMap<String,Object>> sfxmsMap = restTemplate.getForObject(REST_SERVICE_URI + "/sfxms", List.class);

        final ObservableList<Sfxm> sfxms= FXCollections.observableArrayList();

        for (LinkedHashMap<String, Object> map : sfxmsMap) {
            Sfxm sfxm=new Sfxm(Long.valueOf((Integer)map.get("id")),(String)map.get("name"));
            sfxm.setDescription((String) map.get("description"));
            sfxms.add(sfxm);
        }

        tvSfxm.setItems(sfxms);


        tcSfxmId.setCellValueFactory(new PropertyValueFactory<Sfxm,Long>("id"));
        tcSfxmName.setCellValueFactory(new PropertyValueFactory<Sfxm, String>("name"));
        tcSfxmDescription.setCellValueFactory(new PropertyValueFactory<Sfxm, String>("description"));

        tvSfxm.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        tcSfbzId.setCellValueFactory(new PropertyValueFactory<Sfbz, Long>("id"));
        tcSfbzName.setCellValueFactory(new PropertyValueFactory<Sfbz, String>("name"));
        tcFormula.setCellValueFactory(new PropertyValueFactory<Sfbz,String>("formula"));
        tcSfbzDescription.setCellValueFactory(new PropertyValueFactory<Sfbz,String>("description"));
        tvSfxm.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Sfxm>() {
            @Override
            public void changed(ObservableValue<? extends Sfxm> observable, Sfxm oldValue, Sfxm newValue) {
                RestTemplate restTemplateSfbz = new RestTemplate();
                tvSfbz.getItems().clear();
                Long sfxmId=newValue.getId();
                final ObservableList<Sfbz> sfbzs=FXCollections.observableArrayList();
                List<LinkedHashMap<String,Object>> sfbzsMap=restTemplateSfbz.getForObject(REST_SERVICE_URI + "/sfxm/" + sfxmId+ "/sfbzs", List.class);
                for (LinkedHashMap<String, Object> map : sfbzsMap) {
                    Sfbz sfbz = new Sfbz(Long.valueOf((Integer) map.get("id")), (String) map.get("name"), Long.valueOf((Integer)map.get("sfxmId")));
                    sfbz.setFormula((String) map.get("formula"));
                    sfbz.setDescription((String) map.get("description"));
                    sfbzs.add(sfbz);
                }
                tvSfbz.setItems(sfbzs);
            }
        });




    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.springContext=applicationContext;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {

    }


}
