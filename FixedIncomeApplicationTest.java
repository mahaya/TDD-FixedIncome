import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class FixedIncomeApplicationTest {

    private FixedIncomeApplication app;

    @Before
    public void setUp() {
        app = new FixedIncomeApplication();
    }

    @Test
    public void testAddBond() {
        Bond bond = app.addBond(1000, 5.0, 10); // $1000 principal, 5% rate, 10 years
        assertNotNull("Bond must not be null", bond);
        assertEquals("Principal should be 1000", 1000, bond.getPrincipal(), 0.01);
        assertEquals("Rate should be 5.0", 5.0, bond.getRate(), 0.01);
        assertEquals("Term should be 10", 10, bond.getTerm());
    }

    @Test
    public void testGetBondDetails() {
        Bond bond = app.addBond(1000, 5.0, 10);
        Bond retrievedBond = app.getBondDetails(bond.getId());
        assertEquals("Retrieved bond should match added bond", bond, retrievedBond);
    }

    @Test
    public void testCalculateAnnualIncomeFromBond() {
        Bond bond = app.addBond(1000, 5.0, 10);
        double income = app.calculateAnnualIncome(bond);
        assertEquals("Annual income should be calculated correctly", 50.0, income, 0.01);
    }

    @Test
    public void testCalculateTotalAnnualIncome() {
        app.addBond(1000, 5.0, 10);
        app.addBond(2000, 7.0, 5);
        double totalIncome = app.calculateTotalAnnualIncome();
        assertEquals("Total income should be correct", 190.0, totalIncome, 0.01);
    }
}
