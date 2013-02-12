// =================================================================                                                                   
// Copyright (C) 2011-2013 Pierre Lison (plison@ifi.uio.no)                                                                            
//                                                                                                                                     
// This library is free software; you can redistribute it and/or                                                                       
// modify it under the terms of the GNU Lesser General Public License                                                                  
// as published by the Free Software Foundation; either version 2.1 of                                                                 
// the License, or (at your option) any later version.                                                                                 
//                                                                                                                                     
// This library is distributed in the hope that it will be useful, but                                                                 
// WITHOUT ANY WARRANTY; without even the implied warranty of                                                                          
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU                                                                    
// Lesser General Public License for more details.                                                                                     
//                                                                                                                                     
// You should have received a copy of the GNU Lesser General Public                                                                    
// License along with this program; if not, write to the Free Software                                                                 
// Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA                                                                           
// 02111-1307, USA.                                                                                                                    
// =================================================================                                                                   

package opendial.domains.rules.conditions.checks;


import opendial.arch.Logger;
import opendial.bn.Assignment;
import opendial.bn.values.DoubleVal;
import opendial.bn.values.Value;

public class GreaterThanCheck extends AbstractCheck {

	// logger
	public static Logger log = new Logger("BasicEqualCheck",
			Logger.Level.NORMAL);
	
	DoubleVal expectedVal;
	String variable;
	
	
	public GreaterThanCheck(String variable, DoubleVal expectedVal) {
		this.variable = variable;
		this.expectedVal = expectedVal;
	}
	
	
	@Override
	public boolean isSatisfied(Assignment input) {
		if (input.containsVar(variable)) {
			Value actualVal = input.getValue(variable);
			if (actualVal instanceof DoubleVal) {
				DoubleVal actualVal2 = (DoubleVal)actualVal;
				return actualVal2.getDouble() > expectedVal.getDouble();
			}
 		}
		return false;
	}
	
	

}

