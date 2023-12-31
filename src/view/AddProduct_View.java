package view;

import controller.DeleteProductController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Product;

public class AddProduct_View{

    private TextField searchField;
    private Button searchButton;
    private Label titleLabel;
    private TextField productNameField;
    private ComboBox<String> categoryComboBox;
    private TextField priceField;
    private TextField quantityField;

    private Button submitButton;
    private TableView<Product> productTableView;
    private Stage primaryStage;
    private ComboBox<String> supplierComboBox;
    private TableColumn<Product, Integer> quantityColumn;
    private TableColumn<Product, String> productNameColumn;
    private TableColumn<Product, Integer> productIdColumn;

    public AddProduct_View(Stage primaryStage){
    	this.primaryStage = primaryStage;

    }

    public void ShowAddProductScene() {

        primaryStage.setTitle("FreshFind Inventory Management System");
        // Create menu bar and menus
        Menu menuProduct = new Menu("Product Management");
        MenuItem addProductItem = new MenuItem("Add New Product");
        MenuItem updateProductItem = new MenuItem("Update or Remove Product");
        menuProduct.getItems().addAll(addProductItem, updateProductItem);

        Menu menuSupplier = new Menu("Supplier Management");
        MenuItem addSupplierItem = new MenuItem("Add New Supplier");
        MenuItem updateSupplierItem = new MenuItem("Update or Remove Supplier");
        menuSupplier.getItems().addAll(addSupplierItem, updateSupplierItem);

        Menu menuProfile = new Menu("Profile");

        MenuBar menuBar = new MenuBar(menuProduct, menuSupplier, menuProfile);

        // Create center content
        productTableView = createProductTableView();

        // Create top content
        HBox searchBox = createSearchBox();

        // Create right content
        VBox addProductBox = createAddProductBox();

        // Create layout
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(searchBox);
        BorderPane.setAlignment(searchBox, Pos.CENTER);
        BorderPane.setMargin(productTableView, new Insets(0, 10, 10, 10)); // Add margin
        borderPane.setCenter(productTableView);
        borderPane.setRight(addProductBox);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(menuBar,borderPane);
        vbox.setPrefSize(640, 400);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        EventHandler<ActionEvent> deleteProductMenuHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleDeleteProductMenuItemClick();
            }
        };

        // Attach the event handler to the "Add New Product" menu item
        updateProductItem.setOnAction(deleteProductMenuHandler);
    }

    private HBox createSearchBox() {
        searchField = new TextField();
        searchField.setPromptText("Search");
        searchButton = new Button("Search");
        HBox searchBox = new HBox(searchField, searchButton);
        searchBox.setAlignment(Pos.CENTER_LEFT);
        searchBox.setSpacing(10);
        searchBox.setPadding(new Insets(14, 0, 14, 28));
        return searchBox;
    }

    private TableView<Product> createProductTableView() {
        TableView<Product> tableView = new TableView<>();
        productIdColumn = new TableColumn<>("Product ID");
        productNameColumn = new TableColumn<>("Product Name");
        quantityColumn = new TableColumn<>("Price");
        tableView.getColumns().addAll(productIdColumn, productNameColumn, quantityColumn);
        tableView.setPrefHeight(310);
        tableView.setPrefWidth(281);
        return tableView;
    }

    private VBox createAddProductBox() {
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPadding(new Insets(0, 20, 0, 20));
        vbox.setSpacing(10);
        Label titleLabel = new Label("Add New Product");
        titleLabel.setPadding(new Insets(10, 0, 0, 0));
        GridPane grid = createAddProductForm();
        vbox.getChildren().addAll(titleLabel, grid);
        return vbox;
    }

    private GridPane createAddProductForm(){
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label productNameLabel = new Label("Product Name:");
        Label categoryLabel = new Label("Category:");
        Label priceLabel = new Label("Price:");
        Label quantityLabel = new Label("Quantity:");
        Label supplierLabel = new Label("Supplier:");

        productNameField = new TextField();
        categoryComboBox = new ComboBox<>();
        categoryComboBox.setPromptText("Pick Category");

        priceField = new TextField();
        quantityField = new TextField();
        supplierComboBox = new ComboBox<>();
        supplierComboBox.setPromptText("Pick Supplier");
        submitButton = new Button("Submit");

        grid.add(productNameLabel, 0, 0);
        grid.add(categoryLabel, 0, 1);
        grid.add(priceLabel, 0, 2);
        grid.add(quantityLabel, 0, 3);
        grid.add(supplierLabel, 0, 4);
        grid.add(productNameField, 1, 0);
        grid.add(categoryComboBox, 1, 1);
        grid.add(priceField, 1, 2);
        grid.add(quantityField, 1, 3);
        grid.add(supplierComboBox, 1, 4);
        grid.add(submitButton, 1, 5);

        return grid;
    }

    
    private void handleDeleteProductMenuItemClick() {
    	DeleteProductController deleteProductController = new DeleteProductController(primaryStage);
    }

    public ComboBox<String> getCategoryComboBox() {
        return categoryComboBox;
    }

    public ComboBox<String> getSupplierComboBox() {
        return supplierComboBox;
    }

    public TableColumn<Product, Integer> getQuantityColumn() {
        return quantityColumn;
    }

    public TableColumn<Product, String> getProductNameColumn() {
        return productNameColumn;
    }

    public TableColumn<Product, Integer> getProductIdColumn() {
        return productIdColumn;
    }

    public TableView<Product> getProductTableView() {
        return productTableView;
    }

    public TextField getProductNameField() {
        return productNameField;
    }

    public TextField getPriceField() {
        return priceField;
    }

    public TextField getQuantityField() {
        return quantityField;
    }

    public Button getSubmitButton() {
        return submitButton;
    }
}
