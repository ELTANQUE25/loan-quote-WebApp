package com.github.hansonhsc.loan.bean;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import com.github.hansonhsc.loan.model.Lender;
import com.github.hansonhsc.loan.model.LoanQuote;
import com.github.hansonhsc.loan.quote.InsufficientLendersException;
import com.github.hansonhsc.loan.quote.LoanQuoteCalculator;
import com.github.hansonhsc.loan.quote.LoanQuoteParameterValidationException;
import com.github.hansonhsc.loan.service.LenderServiceInterface;
import com.opencsv.bean.CsvToBeanBuilder;

/**
 * A command line application that reads a CSV file of lenders and provides a quote for the requested loan amount
 * using the lenders with the lowest rates
 */

@ManagedBean
@ViewScoped
public final class LoanQuoteApplication implements Serializable {
    final static int MIN_LOAN_AMOUNT = 1000;
    final static int MAX_LOAN_AMOUNT = 15000;

    final static int LOAN_AMOUNT_INCREMENT = 100;
    public int loan;
    public int loanInsert;
    public LoanQuote quote;
    public  boolean sQuote;
    
    @ManagedProperty(value = "#{LenderService}")
	static
    LenderServiceInterface lenderService;
    
    public static LenderServiceInterface getLenderService() {
		return lenderService;
	}

	public void setLenderService(LenderServiceInterface lenderService) {
		this.lenderService = lenderService;
	}

	public boolean issQuote() {
		return sQuote;
	}

	public void setsQuote(boolean sQuote) {
		this.sQuote = sQuote;
	}

	public LoanQuote getQuote() {
		return quote;
	}

	public void setQuote(LoanQuote quote) {
		this.quote = quote;
	}

	public int getLoanInsert() {
		return loanInsert;
	}

	public void setLoanInsert(int loanInsert) {
		this.loanInsert = loanInsert;
	}

	/**
     * Entry point for the application
     * @param args array of strings representing the user input. Must be of length 2, where <code>args[0]</code>
     *             is a file path to the input CSV file containing lender information; and <code>args[1]</code>
     *             is an integer specifying the loan amount that is between <code>MIN_LOAN_AMOUNT</code> and
     *             <code>MAX_LOAN_AMOUNT</code> inclusive and in increments of <code>LOAN_AMOUNT_INCREMENT</code>.
     */
    
    
   
    
    
    public void loanQuoteCalculator() {
    	sQuote=true;
        // validate and parse the arguments
        final LoanQuoteCalculator loanQuoteCalculator;
        final int loanAmount;
  
        try {
            loanQuoteCalculator = createLoanQuoteCalculator();
            this.loanInsert= loan;
            loanAmount =loan;
        } catch (LoanQuoteParameterValidationException e) {
            printError(e.getMessage());

            return;
        }

        // get the single quote we want
        

        try {
            quote = loanQuoteCalculator.getQuote(loanAmount);
        } catch (InsufficientLendersException e) {
            printError("Insufficient offers from lenders to satisfy the loan. Try a smaller loan amount.");
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            HttpServletResponse response = (HttpServletResponse) context.getResponse();
            response.setStatus(400); 
            return;
         
        }

        // display the quote to the user
        printQuote(quote);
    }

    public int getLoan() {
		return loan;
	}

	public void setLoan(int loan) {
		this.loan = loan;
	}

	/**
     * Creates a loan quote calculator from a market CSV file path
     * @param marketFilePath the file path for a CSV file representing the market lenders
     * @return a <code>LoanQuoteCalculator</code> object that can be reused to create as many quotes as we want
     * @throws LoanQuoteParameterValidationException thrown if the <code>marketFilePath</code> is not a file path to a
     * CSV file or the file is not a valid CSV
     */
	
    static LoanQuoteCalculator createLoanQuoteCalculator() throws LoanQuoteParameterValidationException {

        final List<Lender> lenders;

        lenders=getLenderService().getLenders();
//        try {
//            //noinspection unchecked
//            lenders = new CsvToBeanBuilder(marketFileReader)
//                    .withType(Lender.class)
//                    .withThrowExceptions(true)
//                    .build()
//                    .parse();
//        } catch (RuntimeException e) {
//            throw new LoanQuoteParameterValidationException("Unable to parse invalid market file: " + e.getMessage(), e);
//        }

        return new LoanQuoteCalculator(lenders);
    }



	/**
     * Gets the loan amount from the string input to an integer representation, performing format validation and
     * range validation
     * @param loanAmountAsString a string representing an integer between <code>MIN_LOAN_AMOUNT</code> and
     *                           <code>MAX_LOAN_AMOUNT</code> inclusive and in increments of
     *                           <code>LOAN_AMOUNT_INCREMENT</code>. Must not start with the character <code>0</code> or <code>+</code>.
     * @return an integer representing the loan amount requested
     * @throws LoanQuoteParameterValidationException thrown if the loan amount is not between <code>MIN_LOAN_AMOUNT</code> and
     *                           <code>MAX_LOAN_AMOUNT</code> inclusive or in increments of <code>LOAN_AMOUNT_INCREMENT</code>
     *                           or <code>loanAmountAsString</code> has a leading character of <code>0</code> or <code>+</code>.
     */
    static int getLoanAmount(final String loanAmountAsString) throws LoanQuoteParameterValidationException {
        // validate loan amount
        final int loanAmount;

        try {
            loanAmount = Integer.parseInt(loanAmountAsString);
        } catch (NumberFormatException e) {
            throw new LoanQuoteParameterValidationException("Invalid loan amount format, must be an integer: " + loanAmountAsString, e);
        }

        if (loanAmount < MIN_LOAN_AMOUNT || MAX_LOAN_AMOUNT < loanAmount || loanAmount % LOAN_AMOUNT_INCREMENT != 0) {
            throw new LoanQuoteParameterValidationException("Invalid loan amount, must be any 100 increment between 1000-15000 inclusive: " + loanAmount);
        }

        // parseInt allows leading zero or leading plus, we shouldn't
        final char loanAmountLeadingChar = loanAmountAsString.charAt(0);

        if (loanAmountLeadingChar == '0') {
            throw new LoanQuoteParameterValidationException("Invalid loan amount format, must be an integer without leading zeroes: " + loanAmountAsString);
        } else if (loanAmountLeadingChar == '+') {
            throw new LoanQuoteParameterValidationException("Invalid loan amount format, must be an integer without leading plus: " + loanAmountAsString);
        }

        return loanAmount;
    }

    /**
     * Prints the quote information to the standard output
     * @param quote the <code>LoanQuote</code> object containing the quote information
     */
    private static void printQuote(final LoanQuote quote) {
        print("Requested amount: £" + quote.getLoanAmount());
        print("Rate: " + quote.getRate() + "%");
        print("Monthly repayment: £" + quote.getMonthlyRepayment());
        print("Total repayment: £" + quote.getTotalRepayment());
    
    }

    /**
     * Prints the specified error message to standard output as well as application usage information
     * @param message the error message to print to standard output
     */
    private static void printError(final String message) {
        print(message);
        printUsage();
    }

    /**
     * Prints a single line to the standard output to explain how to use the application
     */
    private static void printUsage() {
        print("Usage: java -jar [loan_quote_jar_file] [market_file] [loan_amount]");
    }

    /**
     * Prints the specified message to standard output. Isolated here, so that if the application ever needs logging,
     * we can integrate it here
     * @param message the message to print to standard output
     */
    private static void print(final String message) {
        System.out.println(message);
    }
}
