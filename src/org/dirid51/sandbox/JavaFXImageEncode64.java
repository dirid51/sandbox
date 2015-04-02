package org.dirid51.sandbox;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFXImageEncode64 extends Application {

	private HBox pictureRegion = new HBox();
	private int index = 0;
	List<Image> images = new ArrayList<>();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		List<byte[]> images64 = new ArrayList<byte[]>();
		for (int i = 1; i < 10; i++) {
			try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("src/" + Integer.toString(i)
			                + "_iceland.jpg")))) {
				byte[] imageBytes = new byte[0];
				for (byte[] ba = new byte[bis.available()]; bis.read(ba) != -1;) {
					byte[] baTmp = new byte[imageBytes.length + ba.length];
					System.arraycopy(imageBytes, 0, baTmp, 0, imageBytes.length);
					System.arraycopy(ba, 0, baTmp, imageBytes.length, ba.length);
					imageBytes = baTmp;
				}
				images64.add(imageBytes);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Button nextImageButton = new Button("Next");
		nextImageButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				index = (index + 1) % images.size();
				((ImageView) pictureRegion.getChildren().get(0)).setImage(images.get(index));
			}
		});

		Button prevImageButton = new Button("Prev");
		prevImageButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				index = (index == 0 ? index + images.size() : index) - 1;
				((ImageView) pictureRegion.getChildren().get(0)).setImage(images.get(index));
			}
		});

		ImageView imageView = new ImageView();
		for (byte[] imageBytes : images64) {
			images.add(new Image(new ByteArrayInputStream(imageBytes), 800.0, 500.0, true, true));
		}
		imageView.setImage(images.get(index));

		pictureRegion.getChildren().add(imageView);

		StackPane root = new StackPane();

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		grid.add(prevImageButton, 0, 0);
		grid.add(pictureRegion, 1, 0);
		grid.add(nextImageButton, 2, 0);

		root.getChildren().add(grid);

		Scene scene = new Scene(root, 1000, 600);

		primaryStage.setTitle("Iceland");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
