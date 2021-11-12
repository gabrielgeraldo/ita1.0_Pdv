package home;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private VBox pnItems = null;
    @FXML
    private Button btnOverview;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnMenus;

    @FXML
    private Button btnPackages;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;

    @FXML
    private Pane pnlCustomer;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Pane pnlMenus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = 0;
                nodes[0] = FXMLLoader.load(getClass().getResource("Item.fxml"));

                //give the items some effect

                nodes[0].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : White");
                });
                nodes[0].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : White");
                });
                pnItems.getChildren().add(nodes[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnCustomers) {
            pnlCustomer.setStyle("-fx-background-color : White");
            pnlCustomer.toFront();
        }
        if (actionEvent.getSource() == btnMenus) {
            pnlMenus.setStyle("-fx-background-color : White");
            pnlMenus.toFront();
        }
        if (actionEvent.getSource() == btnOverview) {
            pnlOverview.setStyle("-fx-background-color : White");
            pnlOverview.toFront();
        }
        if(actionEvent.getSource()==btnOrders)
        {	
        	// System.out.println("teste");
        	 	
        	pnlOrders.getChildren().clear();
        	
        	try {
				pnlOrders.getChildren().add(FXMLLoader.load(getClass().getResource("Pesquisa.fxml")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        	// pnlOrders.setStyle("-fx-background-color : red");
            pnlOrders.toFront();
        	
			
        
        }
    }
}
