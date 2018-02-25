package Utils;
/**
 * This class contains all the strings used in the application so 
 * location and maintenance of strings is made easer
 * 
 * @author Ricky
 *
 */
public class Strings
{
	public static final String[] ALL_API_CALLS = {"Exit Application", "Add Client", "Remove Client", "List All Clients", "Add Customer",
												"Remove Customer", "Add Credit Card", "Remove Credit Card",	"List All Customers", 
												"Add a Show or Play", "List All Shows", "Store Data", "Retrieve Data", "Help"};
	public static final String[] API_HELP_DETAILS = {
														};
	
	//System Strings
	public static final String ERROR_SELECTION_NOT_IN_RANGE =  "ERROR: Selection input not within proper range";
	public static final String ERROR_BAD_INPUT = "ERROR: Input value not within range";
	public static final String ERROR_BAD_INPUT_YES_NO = "ERROR: Input value must be: Y/N";
	public static final String ERROR_BAD_PHONE_NUMBER = "ERROR: Invalid phone number.";
	public static final String ERROR_INPUT_CANNOT_BE_BLANK = "Input cannot be blank";
	public static final String ERROR_BAD_LONG_INPUT = "ERROR: Please enter a long int";
	public static final String ERROR_BAD_INT_INPUT = "ERROR: Value must be an integer";
	public static final String ERROR_CLIENT_ID_NOT_FOUND = "ERROR: Client ID not found";
	public static final String ERROR_CUSTOMER_ID_NOT_FOUND = "ERROR: Customer ID not found";
	public static final String HEADER_ADD_CLIENT = "ADD CLIENT";
	public static final String HEADER_ADD_SHOW = "ADD SHOW";
	public static final String HEADER_LIST_ALL_CLIENTS = "Listing all Clients";
	public static final String HEADER_LIST_ALL_SHOWS = "Listing all Shows";
	public static final String HEADER_ADD_CREDIT_CARD = "ADD CREDIT CARD";
	public static final String HEADER_LIST_ALL_CUSTOMERS = "Listing all Customers and Cards";
	public static final String HEADER_REMOVE_CREDIT_CARD = "REMOVE CREDIT CARD";
	public static final String HEADER_ADD_CUSTOMER = "ADD CUSTOMER";
	public static final String HEADER_REMOVE_CUSTOMER = "REMOVE CUSTOMER";
	public static final String HEADER_REMOVE_CLIENT = "REMOVE CLIENT";
	public static final String MESSAGE_WELCOME = "Welcome";
	public static final String NOTIFICATION_CUSTOMER_HAS_ONLY_ONE_CARD = "Customer only has one credit card";
	public static final String NOTIFICATION_SHOW_ADDED_FAILED = "Show added successfully";
	public static final String NOTIFICATION_ADD_CUSTOMER_SUCCESS = "Customer Added Successfully";
	public static final String NOTIFICATION_ADD_CUSTOMER_FAILED = "Add Customer Failed";
	public static final String NOTIFICATION_CLOSING_APPLICATION = "CLOSING APPLICATION";
	public static final String NOTIFICATION_SERIALIZING_DATA = "SERIALIZING DATA";
	public static final String NOTIFICATION_SHOW_ADDED_SUCCESS = "Show successfully added:";
	public static final String NOTIFICATION_CLIENT_ADDED_SUCCESS = "Client Added Successfully";
	public static final String NOTIFICATION_CLIENT_REMOVED_SUCCESS = "Client removed successfully.";
	public static final String NOTIFICATION_CUSTOMER_REMOVED_SUCCESS = "Customer removed successfully.";
	public static final String NOTIFICATION_CLIENT_REMOVED_FAILED = "Client not found. Client removal failed.";
	public static final String NOTIFICATION_CUSTOMER_REMOVED_FAILED = "Customer not found. Customer removal failed.";
	public static final String NOTIFICATION_ADD_CREDIT_CARD_FAILED = "Add customer credit card failed";
	public static final String NOTIFICATION_ADD_CREDIT_CARD_SUCCESS = "Customer credit card added successfully";
        public static final String NOTIFICATION_CREDIT_CARD_EXISTS = "Credit card is already in use";
	public static final String NOTIFICATION_REMOVE_CREDIT_CARD_FAILED = "Remove credit card failed";
	public static final String NOTIFICATION_REMOVE_CREDIT_CARD_SUCCESS = "Remove credit card successful";
	public static final String NOTIFICATION_ADD_SHOW_OR_PLAY_FAILED = "Add show or play failed";
	public static final String NOTIFICATION_ALL_CREDIT_CARDS_REMOVED_SUCCESS = "All customer credit cards removed successfully.";
	public static final String NOTIFICATION_APPLICATION_CLOSED = "APPLICATION CLOSED SUCCESSFULLY";
	public static final String NOTIFICATION_ADD_CLIENT_FAILED = "Add Client Failed";
	public static final String NOTIFICATION_SERIALIZE_SUCCESS = "Serialization successful";
	public static final String NOTIFICATION_SERIALIZE_FAILED = "Serialization failed";
	public static final String NOTIFICATION_CLOSE_SUCCESS = "SUCCESS CLOSING APPLICATION";
	public static final String NOTIFICATION_SHOW_STILL_ONGOING = "Client's show is still ongoing.";
	public static final String NOTIFICATION_SHOW_OVERLAP = "Show overlaps with another show";
	public static final String PROMPT_FOR_NAME = "Please enter a name:";
	public static final String PROMPT_FOR_ADDRESS = "Please enter an address:";	
	public static final String PROMPT_FOR_PHONE_NUMBER = "Please enter a phone number:";
	public static final String PROMPT_FOR_SHOW_NAME = "Please enter show name:";
	public static final String PROMPT_FOR_CLIENT_ID = "Please enter the client ID:";
	public static final String PROMPT_FOR_CUSTOMER_ID = "Please enter the customer ID:";
	public static final String PROMPT_FOR_CARD_EXPIRATION = "Please enter the credit cards expiration";
	public static final String PROMPT_FOR_CREDIT_CARD_NUMBER = "Please enter the credit card number";
	public static final String PROMPT_FOR_BEGIN_YEAR = "Please enter starting year:";
	public static final String PROMPT_FOR_BEGIN_MONTH = "Please enter starting month:";
	public static final String PROMPT_FOR_BEGIN_DAY = "Please enter a starting day:";
	public static final String PROMPT_FOR_END_YEAR = "Please enter an ending year";
	public static final String PROMPT_FOR_END_MONTH = "Please enter an ending month";
	public static final String PROMPT_FOR_END_DAY = "Please enter an ending day";
	public static final String PROMPT_MENU_OPTION = "input the numbered option you would like to execute";
	public static final String PROMPT_RETRIEVE_DATA = "Would you like to retrieve previous data? Y/N";

	//Miscellaneous
	public static final String HELP_MENU = "Details of possible user application commands";
	public static final String CONTINUE_ON_ENTER = "Press [ENTER] to continue";
	public static final String CINEMA_NAME = "Cinema 10";







	
}