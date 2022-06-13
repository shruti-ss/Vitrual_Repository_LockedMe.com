//inheritance : inheriting the features of Parent Exception class to user-defined exception class
 class UserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	UserException()
	{
		System.out.println("Please enter value from(Y/N)  \n     Y : to proceed, N : not to proceed ");
	}
	
}
