import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Cargar el archivo FXML
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/tarea_view.fxml"));

        // Cargar el contenedor raíz desde el FXML
        Scene scene = new Scene(fxmlLoader.load(), 300, 400);

        // Cargar y aplicar el archivo CSS (correcta ruta, desde la raíz del directorio resources)
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        // Configuración de la ventana
        stage.setTitle("Lista de tareas");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
