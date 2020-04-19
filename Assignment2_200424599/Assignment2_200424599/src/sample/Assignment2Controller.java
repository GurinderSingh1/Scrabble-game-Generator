package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Arrays;

public class Assignment2Controller {
    @FXML
    TextField enteredWord;

    @FXML
    Label yourTotal, myList, displayStatement;

    @FXML
    Pane apoint,bpoint,cpoint,dpoint,epoint,fpoint,gpoint,hpoint,ipoint,jpoint,kpoint,lpoint,mpoint,npoint,opoint,ppoint,qpoint,rpoint,spoint,tpoint,upoint,vpoint,wpoint,xpoint,ypoint,zpoint;

    ArrayList<Pane> labels = new ArrayList<>();


    @FXML
    private void initialize(){
        System.out.println("Project Activated");
        displayStatement.setText("Welcome to the Scrabble points Generator");
    }

    @FXML
    private void submit(ActionEvent event)
    {
        String word = enteredWord.getText();

        if(word == null)
        {
            displayStatement.setText("Blank words not allowed");
        }
        System.out.println("Your word is " + word);
        try {
            Assignment2Model sm = new Assignment2Model(word);
            enteredWord.setText("");
            yourTotal.setText(sm.getScore());
            displayStatement.setText(sm.setTitle());
            myList.setText(sm.getMyList());

            int[] beg = sm.getMyBeg();
            for (int i=0;i<beg.length;i++)
            {
                System.out.printf(beg[i]+ " ");
            }

            labels.addAll(Arrays.asList(apoint,bpoint,cpoint,dpoint,epoint,fpoint,gpoint,hpoint,ipoint,jpoint,kpoint,lpoint,mpoint,npoint,opoint,ppoint,qpoint,rpoint,spoint,tpoint,upoint,vpoint,wpoint,xpoint,ypoint,zpoint));

            for (int i=0; i< beg.length;i++)
            {
                if (beg[i] == 0)
                {
                    labels.get(i).setDisable(true);
                    labels.get(i).setStyle("-fx-background-color: #f4e8d6");
                }
            }

            int sum =0;
            for(int i=0;i<beg.length;i++)
            {
                sum = sum + beg[i];
            }

            if(sum == 1)
            {
                displayStatement.setText("Game Over");
            }

        }
        catch (Exception e)
        {
            System.out.println("Check Input");
        }


    }
}
