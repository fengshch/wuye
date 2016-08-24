package cn.southstone.wuye.jfx.controller;

import cn.southstone.wuye.jfx.configs.BootInitializable;
import cn.southstone.wuye.jfx.jasper.JRViewerMode;
import cn.southstone.wuye.jfx.jasper.TransactionResult;
import cn.southstone.wuye.jfx.jasper.WarningToast;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleDocxExporterConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxExporterConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.*;

/**
 * Created by fengs on 2016/8/19.
 */
@Component("jrViewerController")
public class JRViewerController implements BootInitializable {
    private ApplicationContext springContext;
    public static final String REST_SERVICE_URI = "http://localhost:8080/rest";


    private JRViewerMode printMode;
    private String reportFilename;
    private JRDataSource reportDataset;
    @SuppressWarnings("rawtypes")
    private Map reportParameters;
    private ChangeListener<Number> zoomListener;
    private JasperPrint jasperPrint;

    private Stage parentStage;
    private Double zoomFactor;
    private double imageHeight;
    private double imageWidth;
    private List<Integer> pages;
    private Popup popup;
    private Label errorLabel;
    boolean showingToast;


    @FXML
    private BorderPane view;

    @FXML
    private ComboBox<Integer> pageList;

    @FXML
    private Slider zoomLevel;

    @FXML
    private ImageView imageView;

    @FXML
    private Accordion resultAccordion;

    @FXML
    private TitledPane resultPane;

    @FXML
    private Label resultDescription;

    public JRViewerMode getPrintMode() {
        return printMode;
    }

    public void setPrintMode(JRViewerMode printMode) {
        this.printMode = printMode;
    }

    public String getReportFilename() {
        return reportFilename;
    }

    public void setReportFilename(String reportFilename) {
        this.reportFilename = reportFilename;
    }

    public JRDataSource getReportDataset() {
        return reportDataset;
    }

    public void setReportDataset(JRDataSource reportDataset) {
        this.reportDataset = reportDataset;
    }

    public Map getReportParameters() {
        return reportParameters;
    }

    public void setReportParameters(Map reportParameters) {
        this.reportParameters = reportParameters;
    }

    public JasperPrint getJasperPrint() {
        return jasperPrint;
    }

    public void setJasperPrint(JasperPrint jasperPrint) {
        this.jasperPrint = jasperPrint;
    }

    @FXML
    void pageListSelected(ActionEvent event) {
        System.out.println(pageList.getSelectionModel().getSelectedItem() - 1);
        viewPage(pageList.getSelectionModel().getSelectedItem() - 1);
    }

    @FXML
    void print() {

        try {

            JasperPrintManager.printReport(jasperPrint, true);
        } catch (JRException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void save(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Document", Arrays.asList("*.pdf", "*.PDF")));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG image", Arrays.asList("*.png", "*.PNG")));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("DOCX Document", Arrays.asList("*.docx", "*.DOCX")));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XLSX Document", Arrays.asList("*.xlsx", "*.XLSX")));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Document", Arrays.asList("*.html", "*.HTML")));
        File file = fileChooser.showSaveDialog(parentStage);
        if (fileChooser.getSelectedExtensionFilter() != null && fileChooser.getSelectedExtensionFilter().getExtensions() != null) {
            List<String> selectedExtension = fileChooser.getSelectedExtensionFilter().getExtensions();
            if (selectedExtension.contains("*.pdf")) {
                try {
                    JasperExportManager.exportReportToPdfFile(jasperPrint, file.getAbsolutePath());
                } catch (JRException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else if (selectedExtension.contains("*.png")) {
                for (int i = 0; i < jasperPrint.getPages().size(); i++) {
                    String fileNumber = "0000" + Integer.toString(i + 1);
                    fileNumber = fileNumber.substring(fileNumber.length() - 4, fileNumber.length());
                    WritableImage image = getImage(i);
                    String[] fileTokens = file.getAbsolutePath().split("\\.");
                    String filename = "";

                    //add number to filename
                    if (fileTokens.length > 0) {
                        for (int i2 = 0; i2 < fileTokens.length - 1; i2++) {
                            filename = filename + fileTokens[i2] + ((i2 < fileTokens.length - 2) ? "." : "");
                        }
                        filename = filename + fileNumber + "." + fileTokens[fileTokens.length - 1];
                    } else {
                        filename = file.getAbsolutePath() + fileNumber;
                    }
                    System.out.println(filename);
                    File imageFile = new File(filename);
                    try {
                        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", imageFile);
                        System.out.println(imageFile.getAbsolutePath());
                    } catch (IOException e) {
                        TransactionResult t = new TransactionResult();
                        t.setResultNumber(-1);
                        t.setResult("Error Saving Report");
                        t.setResultDescription(e.getMessage());
                        setTransactionResult(t);
                        e.printStackTrace();
                    }

                }

            } else if (selectedExtension.contains("*.html")) {
                try {
                    JasperExportManager.exportReportToHtmlFile(jasperPrint, file.getAbsolutePath());
                } catch (JRException e) {
                    TransactionResult t = new TransactionResult();
                    t.setResultNumber(-1);
                    t.setResult("Error Saving Report");
                    t.setResultDescription(e.getMessage());
                    setTransactionResult(t);
                    e.printStackTrace();
                }
            } else if (selectedExtension.contains("*.docx")) {
                JRDocxExporter exporter = new JRDocxExporter();
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(file.getAbsolutePath()));
                SimpleDocxExporterConfiguration configuration = new SimpleDocxExporterConfiguration();
                exporter.setConfiguration(configuration);
                try {
                    exporter.exportReport();
                } catch (JRException e) {
                    TransactionResult t = new TransactionResult();
                    t.setResultNumber(-1);
                    t.setResult("Error Saving Report");
                    t.setResultDescription(e.getMessage());
                    setTransactionResult(t);
                    e.printStackTrace();
                }
                System.out.println("docx");
            } else if (selectedExtension.contains("*.xlsx")) {
                JRXlsxExporter exporter = new JRXlsxExporter();
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(file.getAbsolutePath()));
                SimpleXlsxExporterConfiguration configuration = new SimpleXlsxExporterConfiguration();
                exporter.setConfiguration(configuration);
                try {
                    exporter.exportReport();
                } catch (JRException e) {
                    TransactionResult t = new TransactionResult();
                    t.setResultNumber(-1);
                    t.setResult("Error Saving Report");
                    t.setResultDescription(e.getMessage());
                    setTransactionResult(t);
                    e.printStackTrace();
                }
                System.out.println("xlsx");
            }
        }

    }


    public void show() {
        if (reportParameters == null) reportParameters = new HashMap();
        if (printMode == null || printMode == JRViewerMode.REPORT_VIEW) {
            //	parentStage = new Stage();
            //Scene scene = new Scene((Parent) view);
//			parentStage.setTitle("Report Viewer");
//			parentStage.setIconified(true);
//			parentStage.initStyle(StageStyle.UNIFIED);
//			parentStage.setScene(scene);
//			parentStage.show();
            popup = new Popup();
            errorLabel = new Label("Error");
            errorLabel.setWrapText(true);
            errorLabel.setMaxHeight(200);
            errorLabel.setMinSize(100, 100);
            errorLabel.setMaxWidth(100);
            errorLabel.setAlignment(Pos.TOP_LEFT);
            errorLabel.getStyleClass().add("errorToastLabel");
            //errorLabel
            //		.setStyle("-fx-border-color: orange; -fx-border-width: 4; -fx-background-color: navajowhite; -fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: black; -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );");
            popup.getContent().add(errorLabel);
            errorLabel.opacityProperty().bind(popup.opacityProperty());
            zoomFactor = 1d;
            zoomLevel.setValue(100d);
            imageView.setX(0);
            imageView.setY(0);
            imageHeight = jasperPrint.getPageHeight();
            imageWidth = jasperPrint.getPageWidth();
            if (zoomListener != null) {
                zoomLevel.valueProperty().removeListener(zoomListener);
            }
            zoomListener = new ChangeListener<Number>() {

                public void changed(ObservableValue<? extends Number> observable,
                                    Number oldValue, Number newValue) {
                    zoomFactor = newValue.doubleValue() / 100;
                    imageView.setFitHeight(imageHeight * zoomFactor);
                    imageView.setFitWidth(imageWidth * zoomFactor);
                }
            };

            zoomLevel.valueProperty().addListener(zoomListener);
            if (jasperPrint.getPages().size() > 0) {
                viewPage(0);
                pages = new ArrayList<Integer>();
                for (int i = 0; i < jasperPrint.getPages().size(); i++)
                    pages.add(i + 1);
            }
            pageList.setItems(FXCollections.observableArrayList(pages));
            pageList.getSelectionModel().select(0);
        } else if (printMode == JRViewerMode.REPORT_PRINT) {
            print();

        }

    }

    @Override
    public Node initView() throws IOException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/JRViewer.fxml"));
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
        System.setProperty("java.awt.headless", "false");
        JasperPrint jasperPrint = null;
        try {
            JasperReport report = JasperCompileManager
                    .compileReport(getClass().getResource("/jasper/Cherry.jrxml").getFile());
            jasperPrint = JasperFillManager.fillReport(report, new HashMap(), new JREmptyDataSource());


        } catch (JRException e) {
            e.printStackTrace();
        }

        this.setJasperPrint(jasperPrint);
        this.setPrintMode(JRViewerMode.REPORT_VIEW);
        this.show();


    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.springContext = applicationContext;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {

    }

    private WritableImage getImage(int pageNumber) {
        BufferedImage image = null;
        try {
            image = (BufferedImage) JasperPrintManager.printPageToImage(jasperPrint, pageNumber, 2);
        } catch (JRException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        WritableImage fxImage = new WritableImage(jasperPrint.getPageWidth(), jasperPrint.getPageHeight());
        return SwingFXUtils.toFXImage(image, fxImage);

    }

    public void setTransactionResult(String result, String description,
                                     int resultNum) {
        TransactionResult t = new TransactionResult();
        t.setResult(result);
        t.setResultDescription(description);
        t.setResultNumber(resultNum);
        t.setTransactionTime(new Date());
        setTransactionResult(t);
    }

    public void setTransactionResult(TransactionResult t) {
        if (t != null) {
            if (t.getTransactionTime() == null) {
                resultPane.setText(t.getResult() + "  Time: " + new Date());
            } else {
                resultPane.setText(t.getResult() + "  Time: "
                        + t.getTransactionTime());
            }

            resultDescription.setText(t.getResultDescription());
            resultPane.setVisible(true);
            resultAccordion.setVisible(true);
        } else {
            resultPane.setText("General Error Occurred" + "  Time: "
                    + new Date());
            resultDescription.setText("No data was returned.");
            resultPane.setVisible(true);
            resultAccordion.setVisible(true);
        }
        if (t.getResultNumber() != 0 && !showingToast) {
            showingToast = true;
            errorLabel.setText(t.getResult());
            popup.show(parentStage);
            popup.setOpacity(1.0d);
            WarningToast task = new WarningToast();
            task.progressProperty().addListener(new ChangeListener<Number>() {


                public void changed(
                        ObservableValue<? extends Number> observable,
                        Number oldValue, Number newValue) {
                    popup.setOpacity(newValue.doubleValue());
                    if (newValue.doubleValue() <= 0.01d) {
                        popup.hide();
                        showingToast = false;
                    }

                }

            });
            popup.setX(view.getScene().getWindow().getX()
                    + view.getScene().getWindow().getWidth() - 100);
            popup.setY(view.getScene().getWindow().getY());
            new Thread(task).start();

        }
    }

    public void clearTransactionResult() {

        resultPane.setText("");
        resultDescription.setText("");
        resultPane.setVisible(false);
        resultAccordion.setVisible(false);
    }

    private void viewPage(int pageNumber) {
        imageView.setFitHeight(imageHeight * zoomFactor);
        imageView.setFitWidth(imageWidth * zoomFactor);
        imageView.setImage(getImage(pageNumber));
    }
}
