package Utils;
/**
 * This class contains all the strings used in the application so 
 * location and maintenance of strings is made easer
 * 
 * @author Noah, Randy, Ricky
 *
 */
public class Strings
{
	public static final String[] ALL_API_CALLS = {"Exit Application", "Add Client", "Remove Client", "List All Clients", "Add Customer",
												"Remove Customer", "Add Credit Card", "Remove Credit Card",	"List All Customers", 
												"Add a Show or Play", "List All Shows", "Store Data", "Retrieve Data", "Help"};

	/**
	 * Error messages
	 */
	public static final String ERROR_SELECTION_NOT_IN_RANGE =  "ERROR: Selection input not within proper range";
	public static final String ERROR_BAD_INPUT = "ERROR: Input value not within range";
	public static final String ERROR_BAD_INPUT_YES_NO = "ERROR: Input value must be: Y/N";
	public static final String ERROR_BAD_PHONE_NUMBER = "ERROR: Invalid phone number.";
	public static final String ERROR_INPUT_CANNOT_BE_BLANK = "Input cannot be blank";
	public static final String ERROR_BAD_LONG_INPUT = "ERROR: Please enter a long int";
	public static final String ERROR_BAD_INT_INPUT = "ERROR: Value must be an integer";
	public static final String ERROR_CLIENT_ID_NOT_FOUND = "ERROR: Client ID not found";
	public static final String ERROR_CUSTOMER_ID_NOT_FOUND = "ERROR: Customer ID not found";
	public static final String ERROR_CREDIT_CARD_NOT_FOUND = "ERROR: Credit card not found";
	public static final String ERROR_BAD_DATE_INPUT = "ERROR: Invalid date must be: YYYY/MM/DD";
	public static final String ERROR_SHOW_NOT_FOUND = "ERROR: Show not found, invalid date";

	/**
	 * Header messages
	 */
	public static final String HEADER_ADD_CLIENT = "Add a Client:";
	public static final String ERROR_DESERIALIZING_DATA = "Error: Deserialization unsuccessful.";
	public static final String HEADER_ADD_SHOW = "Add a Show:";
	public static final String HEADER_LIST_ALL_CLIENTS = "Listing all Clients:";
	public static final String HEADER_LIST_ALL_SHOWS = "Listing all Shows:";
	public static final String HEADER_ADD_CREDIT_CARD = "Add a Credit Card:";
	public static final String HEADER_LIST_ALL_CUSTOMERS = "Listing all Customers and Cards:";
	public static final String HEADER_REMOVE_CREDIT_CARD = "Remove a Credit Card:";
	public static final String HEADER_ADD_CUSTOMER = "Add a Customer:";
	public static final String HEADER_REMOVE_CUSTOMER = "Remove a Customer:";
	public static final String HEADER_REMOVE_CLIENT = "Remove a Client";
	public static final String MESSAGE_WELCOME = "Welcome";

	/**
	 * Notification messages
	 */
	public static final String NOTIFICATION_NO_CREDIT_CARDS_REMOVED = "No Credit Cards were able to be removed";
	public static final String NOTIFICATION_NO_PREVIOUS_DATA_FOUND = "No previous data found. Loading new session.";
	public static final String NOTIFICATION_CUSTOMER_HAS_ONLY_ONE_CARD = "Customer only has one credit card";
	public static final String NOTIFICATION_SHOW_ADDED_FAILED = "Show added successfully";
	public static final String NOTIFICATION_ADD_CUSTOMER_SUCCESS = "Customer added successfully";
	public static final String NOTIFICATION_ADD_CUSTOMER_FAILED = "Add customer has failed";
	public static final String NOTIFICATION_CLOSING_APPLICATION = "CLOSING APPLICATION";
	public static final String NOTIFICATION_SERIALIZING_DATA = "SERIALIZING DATA";
	public static final String NOTIFICATION_SHOW_ADDED_SUCCESS = "Show successfully added:";
	public static final String NOTIFICATION_CLIENT_ADDED_SUCCESS = "Client Added Successfully";
	public static final String NOTIFICATION_CLIENT_REMOVED_FAILED = "Client not found. Client removal failed.";
	public static final String NOTIFICATION_CLIENT_REMOVED_SUCCESS = "Client removed successfully.";
	public static final String NOTIFICATION_CUSTOMER_REMOVED_SUCCESS = "Customer removed successfully.";
	public static final String NOTIFICATION_CUSTOMER_REMOVED_FAILED = "Customer not found. Customer removal failed.";
	public static final String NOTIFICATION_ADD_CREDIT_CARD_FAILED = "Add customer credit card failed";
	public static final String NOTIFICATION_ADD_CREDIT_CARD_SUCCESS = "Customer credit card added successfully";
	public static final String NOTIFICATION_CREDIT_CARD_EXISTS = "Credit card is already in use";
	public static final String NOTIFICATION_REMOVE_CREDIT_CARD_FAILED = "Remove credit card failed";
	public static final String NOTIFICATION_REMOVE_CREDIT_CARD_SUCCESS = "Remove credit card successful";
	public static final String NOTIFICATION_ADD_SHOW_OR_PLAY_FAILED = "Add show or play failed";
	public static final String NOTIFICATION_ALL_CREDIT_CARDS_REMOVED_SUCCESS = "All customer credit cards removed successfully.";
	public static final String NOTIFICATION_APPLICATION_CLOSED = "Application closed successfully";
	public static final String NOTIFICATION_ADD_CLIENT_FAILED = "Add Client Failed";
	public static final String NOTIFICATION_SERIALIZE_SUCCESS = "Serialization successful";
	public static final String NOTIFICATION_SERIALIZE_FAILED = "Serialization failed";
	public static final String NOTIFICATION_CLOSE_SUCCESS = "SUCCESS CLOSING APPLICATION";
	public static final String NOTIFICATION_SHOW_STILL_ONGOING = "Client's show is still ongoing.";
	public static final String NOTIFICATION_SHOW_OVERLAP = "Show overlaps with another show";
	public static final String NOTIFICATION_CLIENT_DNE = "Client does not exist";
	public static final String NOTIFICATION_CREDIT_CARD_DNE = "Credit Card does not exist";
	public static final String NOTIFICATION_CLOSED_FAILED_TO_SERIALIZE = "Closed application successfully. Failed to Serialize.";
	public static final String NOTIFICATION_EXTRA_MESSAGE = "Must show valid student id.";

	/**
	 * Prompt messages
	 */
	public static final String PROMPT_FOR_NAME = "Please enter a name:";
	public static final String PROMPT_FOR_ADDRESS = "Please enter an address:";	
	public static final String PROMPT_FOR_PHONE_NUMBER = "Please enter a phone number: xxx-xxx-xxxx";
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
	public static final String PROMPT_FOR_DATE = "Please input show data: YYY/MM/DD";
	public static final String PROMPT_MENU_OPTION = "input the numbered option you would like to execute";
	public static final String PROMPT_RETRIEVE_DATA = "Would you like to retrieve previous data? Y/N";
	public static final String PROMPT_FOR_WHOLE_BEGIN_DATE ="Please enter a beginning date: YYYY/MM/DD";
	public static final String PROMPT_FOR_WHOLE_END_DATE = "Please enter an ending date: YYYY/MM/DD";
	public static final String PROMPT_FOR_TICKET_QUANTITY = "Please input ticket quantity: ";
	//Miscellaneous
	public static final String CONTINUE_ON_ENTER = "Press [ENTER] to continue";
	public static final String CINEMA_NAME = "Cinema 10";

	/**
	 * Help messages
	 */
	public static final String HELP_EXIT_APPLICATION = "0. Exit Application - Exits the theater program and saves all information" +
														"from customer list, client list, credit card list, and show list.";
	public static final String HELP_ADD_CLIENT = "1. Add Client - Prompts for name, address, phone number. An id is generated as well.";
	public static final String HELP_REMOVE_CLIENT = "2. Remove Client - Removes client by prompting for client ID. Cannot remove if there is a show ongoing.";
	public static final String HELP_LIST_CLIENT = "3. List All Clients - Lists all client information.";
	public static final String HELP_ADD_CUSTOMER = "4. Add Customer - Prompts for name, address, phone number, credit card number, and expiry date." +
													"An id is generated as well.";
	public static final String HELP_REMOVE_CUSTOMER = "5. Remove Customer - Removes customer by prompting for customer ID.";
	public static final String HELP_ADD_CREDIT_CARD = "6. Add Credit Card - Prompts for credit card number, expiry date, and customer ID. Must be an existing customer. ";
	public static final String HELP_REMOVE_CREDIT_CARD = "7. Remove Credit Card - Removes credit card by prompting for credit card number." +
														"Must not be the only credit card for the customer.";
	public static final String HELP_LIST_CUSTOMER = "8. List All Customers - Lists all customer information.";
	public static final String HELP_ADD_SHOW = "9. Add a Show or Play - Prompts for show name, client ID, start date, and end date. Cannot add overlapping shows.";
	public static final String HELP_LIST_SHOW = "10. List All Shows - Lists all shows.";
	public static final String HELP_STORE_DATA = "11. Store Data - Serializes data to theater.ser";
	public static final String HELP_RETRIEVE_DATA = "12. Retrieve Data - Loads data from theater.ser";
	public static final String[] HELP_MENU = {HELP_EXIT_APPLICATION, HELP_ADD_CLIENT, HELP_REMOVE_CLIENT, 
												HELP_LIST_CLIENT, HELP_ADD_CUSTOMER, HELP_REMOVE_CUSTOMER, 
												HELP_ADD_CREDIT_CARD, HELP_REMOVE_CREDIT_CARD, 
												HELP_LIST_CUSTOMER, HELP_ADD_SHOW, HELP_LIST_SHOW, 
												HELP_STORE_DATA, HELP_RETRIEVE_DATA};









	
}