package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
    private TextField txtYearsToWork;
	@FXML
	private Label lblSaveEachMonth;	
	@FXML
	private Label lblWhatToSaveTotal;
    @FXML
    private TextField txtAnnualReturnWorking;
    @FXML
    private TextField txtYearsRetired;
    @FXML
    private TextField txtAnnualReturnRetired;
    @FXML
    private TextField txtRequiredIncome;
    @FXML
    private TextField txtMonthlySSI;
    @FXML
    private TextField txtTotalAmountSaved;
    @FXML
    private TextField txtAmountToSave;
    
	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		//Clears the text		
	System.out.println("Clear Pressed");
	
	lblSaveEachMonth.setText("");
	lblWhatToSaveTotal.setText("");
	
	txtYearsToWork.setText("");
	txtAnnualReturnWorking.setText("");
	txtYearsRetired.setText("");
	txtAnnualReturnRetired.setText("");
	txtRequiredIncome.setText("");
	txtMonthlySSI.setText("");
			
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		
		//	TODO: Call AmountToSave and TotalAmountSaved and populate
		try {
			
			int iYTW = Integer.parseInt(txtYearsToWork.getText());
			int iYR = Integer.parseInt(txtYearsRetired.getText());
			
			double dARW = Double.parseDouble(txtAnnualReturnWorking.getText());
			double dARR = Double.parseDouble(txtAnnualReturnRetired.getText());
			double dRI = Double.parseDouble(txtRequiredIncome.getText());
			double dMSSI = Double.parseDouble(txtMonthlySSI.getText());
		
			Retirement R= new Retirement(iYTW,dARW,iYR,dARR,dRI,dMSSI);
			
			lblSaveEachMonth.setText(Double.toString(R.AmountToSave()));
			lblWhatToSaveTotal.setText(Double.toString(R.TotalAmountSaved()));
		}
		
		catch(Exception NumberformatException) {
			System.out.println("Make sure years are in whole numbers and all required fields contain numbers.");
			throw NumberformatException;
		}
		
		
	}
	
}