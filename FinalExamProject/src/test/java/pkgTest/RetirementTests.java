package pkgTest;
import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Retirement;

public class RetirementTests {

		@Test
		public void TestPVPMT() {
			
			double dAnnualReturnWorking = 0.07;
			
			double dAnnualReturnRetired = 0.02;
			double dRequiredIncome = 10000;
			double dMonthlySSI = 2642;
			
			int iYearsToWork = 40;
			int iYearsRetired = 20; 

			double GivenPay = -554.13;
			double GivenTotal = 1454485.55;

			Retirement Ret = new Retirement(iYearsToWork, dAnnualReturnWorking, 
					iYearsRetired, dAnnualReturnRetired, dRequiredIncome, dMonthlySSI);
			
			double PV = Ret.TotalAmountSaved();
			double PMT = Ret.AmountToSave();
			
			assertEquals(GivenTotal, PV, 0.01);
			assertEquals(GivenPay, PMT, 0.01);
			
			System.out.println(PV);
			System.out.println(PMT);
		}
}