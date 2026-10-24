package com.example.sumaralgoritmos;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GraficasApp extends Application {

    @Override
    public void start(Stage stage){
        ArrayList<Dato> iterativa=Main.correrIterativa();
        ArrayList<Dato> recursiva=Main.correrRecursiva();
        ArrayList<Dato> gauss=Main.correrGauss();

        TabPane tabPane=new TabPane();

        Tab tabComparativa=new Tab("Comparativa",construirComparativa(iterativa,recursiva,gauss));
        Tab tabIterativa=new Tab("Iterativa",construirGraficaConTabla("Iterativa",iterativa));
        Tab tabGauss=new Tab("Gauss",construirGraficaConTabla("Gauss",gauss));
        Tab tabRecursiva=new Tab("Recursiva",construirGraficaConTabla("Recursiva",recursiva));

        tabComparativa.setClosable(false);
        tabIterativa.setClosable(false);
        tabGauss.setClosable(false);
        tabRecursiva.setClosable(false);

        tabPane.getTabs().addAll(tabComparativa,tabIterativa,tabGauss,tabRecursiva);

        stage.setScene(new Scene(tabPane,1200,700));
        stage.setTitle("Sumatoria de n numeros");
        stage.show();
    }

    private HBox construirGraficaConTabla(String titulo,ArrayList<Dato> datos){
        NumberAxis ejeX=new NumberAxis();
        ejeX.setLabel("n");
        NumberAxis ejeY=new NumberAxis();
        ejeY.setLabel("t nanosegundos");

        LineChart<Number,Number> chart=new LineChart<>(ejeX,ejeY);
        chart.setTitle(titulo);
        chart.setLegendVisible(false);
        chart.setCreateSymbols(true);

        XYChart.Series<Number,Number> serie=new XYChart.Series<>();
        for (Dato dato : datos){
            serie.getData().add(new XYChart.Data<>(dato.getN(),dato.getTime()));
        }
        chart.getData().add(serie);
        chart.setPrefWidth(800);

        TableView<Dato> tabla=construirTabla(datos);

        HBox contenedor=new HBox();
        contenedor.setSpacing(20);
        contenedor.setPadding(new Insets(20));
        contenedor.setAlignment(Pos.CENTER);
        contenedor.getChildren().addAll(chart,tabla);
        return contenedor;
    }

    private HBox construirComparativa(ArrayList<Dato> iterativa,ArrayList<Dato> recursiva,ArrayList<Dato> gauss){
        NumberAxis ejeX=new NumberAxis();
        ejeX.setLabel("n");
        NumberAxis ejeY=new NumberAxis();
        ejeY.setLabel("t nanosegundos");

        LineChart<Number,Number> chart=new LineChart<>(ejeX,ejeY);
        chart.setTitle("Comparativa");

        XYChart.Series<Number,Number> serieIterativa=new XYChart.Series<>();
        serieIterativa.setName("Iterativa");
        for (Dato dato : iterativa){
            serieIterativa.getData().add(new XYChart.Data<>(dato.getN(),dato.getTime()));
        }

        XYChart.Series<Number,Number> serieGauss=new XYChart.Series<>();
        serieGauss.setName("Gauss");
        for (Dato dato : gauss){
            serieGauss.getData().add(new XYChart.Data<>(dato.getN(),dato.getTime()));
        }

        XYChart.Series<Number,Number> serieRecursiva=new XYChart.Series<>();
        serieRecursiva.setName("Recursiva");
        for (Dato dato : recursiva){
            serieRecursiva.getData().add(new XYChart.Data<>(dato.getN(),dato.getTime()));
        }

        chart.getData().addAll(serieIterativa,serieGauss,serieRecursiva);
        chart.setPrefWidth(1100);

        HBox contenedor=new HBox();
        contenedor.setPadding(new Insets(20));
        contenedor.setAlignment(Pos.CENTER);
        contenedor.getChildren().add(chart);
        return contenedor;
    }

    private TableView<Dato> construirTabla(ArrayList<Dato> datos){
        TableView<Dato> tabla=new TableView<>();

        TableColumn<Dato,Integer> columnaN=new TableColumn<>("N");
        columnaN.setCellValueFactory(celda->new SimpleObjectProperty<>(celda.getValue().getN()));

        TableColumn<Dato,Long> columnaTiempo=new TableColumn<>("Tiempo (ns)");
        columnaTiempo.setCellValueFactory(celda->new SimpleObjectProperty<>(celda.getValue().getTime()));

        tabla.getColumns().addAll(columnaN,columnaTiempo);

        ObservableList<Dato> lista=FXCollections.observableArrayList(datos);
        tabla.setItems(lista);
        tabla.setPrefWidth(300);
        return tabla;
    }
}