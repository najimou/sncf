package fr.upmc.security;

public class SecurityPattern {
	
	//Standard
	//	^                    # Start of the line
	//	  [a-z]	   			 # Match characters and symbols in the list, a-z
	//	             {3,15}  # Length at least 3 characters and maximum length of 15 
	//	$                    # End of the line
	public static final String STANDARD_PATTERN = "^[a-z][A-Z]{3,30}$"; 
	
	//Password
	//			  (					# Start of group
	//			  (?=.*\d)			# must contains one digit from 0-9
	//			  (?=.*[a-z])		# must contains one lowercase characters
	//			  (?=.*[A-Z])		# must contains one uppercase characters
	//			  (?=.*[@#$%])		# must contains one special symbols in the list "@#$%"
	//			  .					# match anything with previous condition checking
	//			  {6,20}			# length at least 6 characters and maximum of 20	
	//	           )				# End of group
	public static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})";
	
	//Email
	//	^							#		start of the line
	//	  [_A-Za-z0-9-\\+]+			#  		must start with string in the bracket [ ], must contains one or more (+)
	//	  (							#   	start of group #1
	//	    \\.[_A-Za-z0-9-]+		#    	follow by a dot "." and string in the bracket [ ], must contains one or more (+)
	//	  )*						#   	end of group #1, this group is optional (*)
	//	    @						#     	must contains a "@" symbol
	//	     [A-Za-z0-9-]+     		#       follow by string in the bracket [ ], must contains one or more (+)
	//	      (						#       start of group #2 - first level TLD checking
	//	       \\.[A-Za-z0-9]+  	#       follow by a dot "." and string in the bracket [ ], must contains one or more (+)
	//	      )*					#       end of group #2, this group is optional (*)
	//	      (						#       start of group #3 - second level TLD checking
	//	       \\.[A-Za-z]{2,}  	#       follow by a dot "." and string in the bracket [ ], with minimum length of 2
	//	      )						#       end of group #3
	//	$							#		end of the line
	public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	

}
