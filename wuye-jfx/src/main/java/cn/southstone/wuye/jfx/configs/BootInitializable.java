package cn.southstone.wuye.jfx.configs;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSourceAware;

import java.io.IOException;

/**
 * Created by fengs on 2016/8/18.
 */
public interface BootInitializable extends Initializable,ApplicationContextAware,MessageSourceAware {
    public Node initView() throws IOException;

    public void setStage(Stage stage);

    public void initConstuct();

    public void initIcons();
}
