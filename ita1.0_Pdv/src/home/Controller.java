package home;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Produto;
import ws.WsUtil;

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

				// give the items some effect

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
		if (actionEvent.getSource() == btnOrders) {
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

	@FXML
	private TableView<Produto> tabelaProdutos;

	@FXML
	private TableColumn<Produto, String> codigoTabelaProdutos;

	@FXML
	private TableColumn<Produto, String> descricaoTabelaProdutos;

	@FXML
	private TableColumn<Produto, String> precoUnitarioTabelaProdutos;

	@FXML
	private RadioButton radioCodigo;

	@FXML
	private RadioButton radioDescricao;

	@FXML
	private Spinner<Integer> spinnerQdt;

	@FXML
	private ToggleGroup tipoPesquisaProduto;

	@FXML
	private TextField textFieldPesquisaProduto;

	@FXML
	public void pesquisaProduto(ActionEvent event) {

		int tipoPesquisaProduto = 0;

		if (radioCodigo.isSelected())
			tipoPesquisaProduto = 1;
		if (radioDescricao.isSelected())
			tipoPesquisaProduto = 2;

		String promptext = textFieldPesquisaProduto.getText();

		if (WsUtil.completeCliente(promptext) != null) {

			codigoTabelaProdutos.setCellValueFactory(new PropertyValueFactory<>("codigo"));

			descricaoTabelaProdutos.setCellValueFactory(new PropertyValueFactory<>("descricao"));

			precoUnitarioTabelaProdutos.setCellValueFactory(new PropertyValueFactory<>("precoUnitario"));

			ObservableList<Produto> lista = FXCollections
					.observableArrayList(WsUtil.completeProduto(tipoPesquisaProduto, promptext));

			tabelaProdutos.setItems(lista);

			if (!tabelaProdutos.getItems().isEmpty()) {
				tabelaProdutos.getSelectionModel().select(0);
				tabelaProdutos.requestFocus();
			}

		}

	}

	@FXML
	public void eventoQtdSpinner(KeyEvent event) {
		System.out.println("teste1");
		if (event.getCode() == KeyCode.ENTER) {
			System.out.println("teste");
			textFieldPesquisaProduto.requestFocus();
		}
	}

	@FXML
	public void selecionaLinhaTabelaProdutos(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			/*
			 * Produto produto = tabelaProdutos.getSelectionModel().getSelectedItem();
			 * 
			 * textFieldPesquisaProduto.setText(null); spinnerQdt.requestFocus();
			 * 
			 * this.adicionarProduto(produto);
			 */
		
			
		}
	}

}
