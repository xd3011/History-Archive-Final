package Controller;

import Crawl.CrawlData;
import Search.searchCharacter;
import Search.searchDynasty;
import Search.searchEvent;
import Search.searchLeHoi;
import Search.searchRelics;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class screenController {

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private TextField search;

    @FXML
    private TextArea view;

    @FXML
    public void initialize() {
        choiceBox.setValue("--option--");
        ObservableList<String> list = choiceBox.getItems();
        list.add("Triều đại");
        list.add("Nhân vật lịch sử");
        list.add("Lễ hội văn hóa");
        list.add("Sự kiện lịch sử");
        list.add("Di tích lịch sử");
    }
     @FXML
    void btnCrawlData(ActionEvent event) {
        new CrawlData();
        showDialog();

    }

    @FXML
    void btnSearch(ActionEvent event) {
        searchLeHoi lh = new searchLeHoi();
        searchEvent ev = new searchEvent();
        searchCharacter ch = new searchCharacter();
        searchRelics re = new searchRelics();
        searchDynasty dy =new searchDynasty();
        if (search.getText() == null) {
            view.setText("Vui lòng nhập đối tượng muốn tìm\n");
        } else {
            String typeChoice = choiceBox.getSelectionModel().getSelectedItem();
            String outInfor = null;
            if (typeChoice.equals("Triều đại")) {
                outInfor = dy.searchInforTrieuDai(search.getText());
            } else if (typeChoice.equals("Lễ hội văn hóa")) {
                outInfor = lh.searchInforLeHoi(search.getText());
            } else if (typeChoice.equals("Sự kiện lịch sử")) {
                outInfor = ev.searchInforEvent(search.getText());
            } else if (typeChoice.equals("Di tích lịch sử")) {
                outInfor = re.searchInforRelics(search.getText());
            } else if (typeChoice.equals("Nhân vật lịch sử")) {
                outInfor = ch.searchInforCharacter(search.getText());
            }

            if (outInfor == null)
                view.setText("Không có thông tin về " + search.getText() + " trong " + typeChoice);
            else
                view.setText(outInfor);
        }

    }

    public void showDialog() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Crawl Data");
        alert.setHeaderText("Success!");
        alert.setContentText("Crawl Data was completed successfully.");
        alert.showAndWait();
    }

}