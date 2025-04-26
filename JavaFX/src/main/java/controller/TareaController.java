package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Tarea;

public class TareaController {
    @FXML
    private TextField txtTarea;
    @FXML
    private ListView<Tarea> listaTareas;
    @FXML
    private Button btnAgregar, btnEliminar, btnCompletar;

    private final ObservableList<Tarea> tareas = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        listaTareas.setItems(tareas);
        listaTareas.setCellFactory(param -> new ListCell<Tarea>() {
            @Override
            protected void updateItem(Tarea tarea, boolean empty) {
                super.updateItem(tarea, empty);
                if (empty || tarea == null) {
                    setText(null);
                    setStyle(""); // Reset style to default
                } else {
                    setText(tarea.getDescripcion());

                    // Si la tarea está completada, se agrega la clase 'completed' a la celda
                    if (tarea.isCompletada()) {
                        getStyleClass().add("completed");
                        getStyleClass().remove("pending");
                    }
                }
            }
        });

        // Este código habilita o deshabilita el botón "Completar" dependiendo de si hay una tarea seleccionada
        listaTareas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnCompletar.setDisable(newValue == null); // Deshabilita el botón si no hay tarea seleccionada
        });
    }

    @FXML
    private void agregarTarea() {
        String descripcion = txtTarea.getText().trim();
        if (!descripcion.isEmpty()) {
            tareas.add(new Tarea(descripcion));
            txtTarea.clear();
        }
    }

    @FXML
    private void eliminarTarea() {
        Tarea tareaSeleccionada = listaTareas.getSelectionModel().getSelectedItem();
        if (tareaSeleccionada != null) {
            tareas.remove(tareaSeleccionada);
        }
    }

    @FXML
    private void completarTarea() {
        Tarea tareaSeleccionada = listaTareas.getSelectionModel().getSelectedItem();
        if (tareaSeleccionada != null) {
            tareaSeleccionada.marcarCompletada(); // Marca la tarea como completada
            System.out.println("Tarea completada: " + tareaSeleccionada.getDescripcion());
            listaTareas.refresh(); // Refresca la lista para mostrar el cambio visual
        } else {
            System.out.println("No se seleccionó ninguna tarea.");
        }
    }

}
