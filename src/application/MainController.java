package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainController implements Initializable{
	@FXML private Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,mute,reset;
	@FXML private Label result;
	private MediaPlayer MP;
	private Media ME;
	private MediaView MV;
	private int count=0,cat=1;
	private boolean done=false;
	private String path="";
	
	public void action(ActionEvent e) {
		if(count==0&&done==false) {
			
			if(((Button)e.getSource()).getText()!="X"&&((Button)e.getSource()).getText()!="O") {
				((Button)e.getSource()).setText("X");
				((Button)e.getSource()).setStyle("-fx-text-fill:red");
				result.setText("O's Move!");
				count=1;
				check();
			}
				else
					result.setText("Invalid Move!");
			
		
		}
		else if(count==1&&done==false){
			
				
					if(((Button)e.getSource()).getText()!="X"&&((Button)e.getSource()).getText()!="O") {
					((Button)e.getSource()).setText("O");
					((Button)e.getSource()).setStyle("-fx-text-fill:blue");
					result.setText("X's Move!");
					count=0;
					check();
				}
				
					else
						result.setText("Invalid Move!");
				
				
			}
		}
		
	
	public void check() {
		if(bt1.getText()==bt2.getText()&&bt2.getText()==bt3.getText()&&bt1.getText()==bt3.getText()) {
			done=true;
			result.setText("The Winner Is: "+bt1.getText()+"!!");
		}
		else if(bt4.getText()==bt5.getText()&&bt5.getText()==bt6.getText()&&bt4.getText()==bt6.getText()) {
			done=true;
			result.setText("The Winner Is: "+bt4.getText()+"!!");
		}
		else if(bt7.getText()==bt8.getText()&&bt8.getText()==bt9.getText()&&bt7.getText()==bt9.getText()) {
			done=true;
			result.setText("The Winner Is: "+bt7.getText()+"!!");
		}
		else if(bt1.getText()==bt5.getText()&&bt5.getText()==bt9.getText()&&bt1.getText()==bt9.getText()) {
			done=true;
			result.setText("The Winner Is: "+bt1.getText()+"!!");
		}
		else if(bt3.getText()==bt5.getText()&&bt5.getText()==bt7.getText()&&bt3.getText()==bt7.getText()) {
			done=true;
			result.setText("The Winner Is: "+bt5.getText()+"!!");
		}
		else if(bt1.getText()==bt4.getText()&&bt4.getText()==bt7.getText()&&bt1.getText()==bt7.getText()) {
			done=true;
			result.setText("The Winner Is: "+bt1.getText()+"!!");
		}
		else if(bt2.getText()==bt5.getText()&&bt5.getText()==bt8.getText()&&bt2.getText()==bt8.getText()) {
			done=true;
			result.setText("The Winner Is: "+bt2.getText()+"!!");
		}
		else if(bt3.getText()==bt6.getText()&&bt6.getText()==bt9.getText()&&bt3.getText()==bt9.getText()) {
			done=true;
			result.setText("The Winner Is: "+bt3.getText()+"!!");
		}
		else {
			if(cat!=9)
				cat++;
			else {
				done=true;
				result.setText("It was a Tie!!");
			}
		}
		
	}
	public void music() {
		if(mute.getText()=="Mute") {
			MP.setMute(true);
			mute.setText("Unmute");
	}
		else if(mute.getText()=="Unmute") {
			MP.setMute(false);
			mute.setText("Mute");
		}
	
	}
	
	public void reset() {
		
		MP.pause();
		FileChooser fc=new FileChooser();
		fc.getExtensionFilters().addAll(new ExtensionFilter("Media Files","*.mp3","*.wav","*.wmv"));
		File path=fc.showOpenDialog(null);		
		if(path!=null) {
		MP.stop();
		ME=new Media(path.toURI().toString());
		MP=new MediaPlayer(ME);
		MV.setMediaPlayer(MP);
		MP.setAutoPlay(true);
		}
		else
			MP.play();
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		path=new File("src\\media\\Start Music.mp3").getAbsolutePath();
		ME=new Media(new File(path).toURI().toString());
		MP=new MediaPlayer(ME);
		MV=new MediaView(MP);
		MP.setAutoPlay(true);
		MP.setMute(false);
		mute.setText("Mute");
		MP.setCycleCount(1000);
		
	}

}