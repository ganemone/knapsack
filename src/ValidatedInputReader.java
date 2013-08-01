// Class: ValidatedInputReader
//
// Authors: Joel Booth, Alyce Brady
//
// Created on Mar 19, 2004 
// Updated on September 3, 2004
//
// License Information:
//   This class is free software; you can redistribute it and/or modify
//   it under the terms of the GNU General Public License as published by
//   the Free Software Foundation.
//
//   This class is distributed in the hope that it will be useful,
//   but WITHOUT ANY WARRANTY; without even the implied warranty of
//   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//   GNU General Public License for more details.

import java.util.zip.DataFormatException;

import javax.swing.JOptionPane;

/**
 *  Kalamazoo College Utility Classes:<br>
 *
 *  This class provides numerous static methods that will put up a dialog
 *  box prompting the user for input and validate the responses.  It
 *  handles all of the primitive Java types including:
 *  <code>byte</code>, <code>short</code>, <code>int</code>,
 *  <code>long</code>, <code>float</code>, <code>double</code>,
 *  <code>char</code>, <code>String</code>, and <code>boolean</code>.
 *
 *  <p>
 *  Each method displays an initial prompt with a suggested value, waits
 *  for the user's response, and validates it.  If the user's response
 *  is invalid, the method prompts the user again using a clarification
 *  prompt until the user enters a valid response or selects Cancel.  If
 *  the user selects Cancel, the input method returns the suggested value
 *  as a default.  Thus, each input method requires an initial prompt, a
 *  suggested value, and a clarification prompt.  Input methods for numeric
 *  values may also provide a range of valid values.
 *  (This input style was inspired by the Java Power Tools package developed
 *  by Richard Rasala, Jeff Raab, and Viera Proulx at Northeastern University.) 
 *
 *  @author Joel Booth
 *  @author Alyce Brady
 *  @version September 3, 2004
 **/
public class ValidatedInputReader
{

    /** Puts up a dialog box displaying the <code>initialPrompt</code>,
     *  waits for the user's response, and validates it (the response must
     *  be a valid byte).
     *  If the user's response is invalid, it prompts the user again
     *  using the <code>clarificationPrompt</code> until the user enters
     *  a valid response or selects Cancel.  If the user selects Cancel,
     *  <code>getByte</code> returns the <code>suggestedValue</code>.
     *    @param initialPrompt  the initial prompt to the user
     *    @param suggestedValue a suggested, valid value that is displayed
     *                          to the user, and is also used as the default
     *                          value if the user selects Cancel
     *    @param clarificationPrompt a follow-up prompt for input after
     *                               the user has input invalid data
     **/
    public static byte getByte(String initialPrompt, byte suggestedValue,
                               String clarificationPrompt) 
    {
        return getByte(initialPrompt, Byte.MIN_VALUE, Byte.MAX_VALUE,
                          suggestedValue, clarificationPrompt);
    }

    /** Puts up a dialog box displaying the <code>initialPrompt</code>,
     *  waits for the user's response, and validates it (the response must
     *  be a valid byte in the range provided).
     *  If the user's response is invalid, it prompts the user again
     *  using the <code>clarificationPrompt</code> until the user enters
     *  a valid response or selects Cancel.  If the user selects Cancel,
     *  <code>getByte</code> returns the <code>suggestedValue</code>.
     *    @param initialPrompt  the initial prompt to the user
     *    @param startOfRange   the smallest value in the range of valid values
     *    @param endOfRange     the largest value in the range of valid values
     *    @param suggestedValue a suggested, valid value that is displayed
     *                          to the user, and is also used as the default
     *                          value if the user selects Cancel
     *    @param clarificationPrompt a follow-up prompt for input after
     *                               the user has input invalid data
     **/
    public static byte getByte(String initialPrompt,
                               byte startOfRange, byte endOfRange,
                               byte suggestedValue, String clarificationPrompt) 
    {
        String suggested = "" + suggestedValue;
        String response = getResponse(initialPrompt, suggested);
        while (response != null)
            try
            {
                byte userEntered = Byte.parseByte(response.trim());
                if ( userEntered < startOfRange || userEntered > endOfRange ) 
                    throw new NumberFormatException();
                return userEntered;
            } 
            catch (NumberFormatException ex)
            {   response = getResponse(clarificationPrompt, suggested);   }
        return suggestedValue;
    }

    /** Puts up a dialog box displaying the <code>initialPrompt</code>,
     *  waits for the user's response, and validates it (the response must
     *  be a valid short).
     *  If the user's response is invalid, it prompts the user again
     *  using the <code>clarificationPrompt</code> until the user enters
     *  a valid response or selects Cancel.  If the user selects Cancel,
     *  <code>getShort</code> returns the <code>suggestedValue</code>.
     *    @param initialPrompt  the initial prompt to the user
     *    @param suggestedValue a suggested, valid value that is displayed
     *                          to the user, and is also used as the default
     *                          value if the user selects Cancel
     *    @param clarificationPrompt a follow-up prompt for input after
     *                               the user has input invalid data
     **/
    public static short getShort(String initialPrompt, short suggestedValue,
                                 String clarificationPrompt) 
    {
        return getShort(initialPrompt, Short.MIN_VALUE, Short.MAX_VALUE,
                          suggestedValue, clarificationPrompt);
    }

    /** Puts up a dialog box displaying the <code>initialPrompt</code>,
     *  waits for the user's response, and validates it (the response must
     *  be a valid short in the range provided).
     *  If the user's response is invalid, it prompts the user again
     *  using the <code>clarificationPrompt</code> until the user enters
     *  a valid response or selects Cancel.  If the user selects Cancel,
     *  <code>getShort</code> returns the <code>suggestedValue</code>.
     *    @param initialPrompt  the initial prompt to the user
     *    @param startOfRange   the smallest value in the range of valid values
     *    @param endOfRange     the largest value in the range of valid values
     *    @param suggestedValue a suggested, valid value that is displayed
     *                          to the user, and is also used as the default
     *                          value if the user selects Cancel
     *    @param clarificationPrompt a follow-up prompt for input after
     *                               the user has input invalid data
     **/
    public static short getShort(String initialPrompt,
                                 short startOfRange, short endOfRange,
                                 short suggestedValue,
                                 String clarificationPrompt) 
    {
        String suggested = "" + suggestedValue;
        String response = getResponse(initialPrompt, suggested);
        while (response != null)
            try
            {
                short userEntered = Short.parseShort(response.trim());
                if ( userEntered < startOfRange || userEntered > endOfRange ) 
                    throw new NumberFormatException();
                return userEntered;
            } 
            catch (NumberFormatException ex)
            {   response = getResponse(clarificationPrompt, suggested);   }
        return suggestedValue;
    }

    /** Puts up a dialog box displaying the <code>initialPrompt</code>,
     *  waits for the user's response, and validates it (the response must
     *  be a valid integer).
     *  If the user's response is invalid, it prompts the user again
     *  using the <code>clarificationPrompt</code> until the user enters
     *  a valid response or selects Cancel.  If the user selects Cancel,
     *  <code>getInteger</code> returns the <code>suggestedValue</code>.
     *    @param initialPrompt  the initial prompt to the user
     *    @param suggestedValue a suggested, valid value that is displayed
     *                          to the user, and is also used as the default
     *                          value if the user selects Cancel
     *    @param clarificationPrompt a follow-up prompt for input after
     *                               the user has input invalid data
     **/
    public static int getInteger(String initialPrompt, int suggestedValue,
                                 String clarificationPrompt) 
    {
        return getInteger(initialPrompt, Integer.MIN_VALUE, Integer.MAX_VALUE,
                          suggestedValue, clarificationPrompt);
    }

    /** Puts up a dialog box displaying the <code>initialPrompt</code>,
     *  waits for the user's response, and validates it (the response must
     *  be a valid integer in the range provided).
     *  If the user's response is invalid, it prompts the user again
     *  using the <code>clarificationPrompt</code> until the user enters
     *  a valid response or selects Cancel.  If the user selects Cancel,
     *  <code>getInteger</code> returns the <code>suggestedValue</code>.
     *    @param initialPrompt  the initial prompt to the user
     *    @param startOfRange   the smallest value in the range of valid values
     *    @param endOfRange     the largest value in the range of valid values
     *    @param suggestedValue a suggested, valid value that is displayed
     *                          to the user, and is also used as the default
     *                          value if the user selects Cancel
     *    @param clarificationPrompt a follow-up prompt for input after
     *                               the user has input invalid data
     **/
    public static int getInteger(String initialPrompt,
                                 int startOfRange, int endOfRange,
                                 int suggestedValue,
                                 String clarificationPrompt) 
    {
        String suggested = "" + suggestedValue;
        String response = getResponse(initialPrompt, suggested);
        while (response != null)
            try
            {
                int userEntered = Integer.parseInt(response.trim());
                if ( userEntered < startOfRange || userEntered > endOfRange ) 
                    throw new NumberFormatException();
                return userEntered;
            } 
            catch (NumberFormatException ex)
            {   response = getResponse(clarificationPrompt, suggested);   }
        return suggestedValue;
    }

    /** Puts up a dialog box displaying the <code>initialPrompt</code>,
     *  waits for the user's response, and validates it (the response must
     *  be a valid long).
     *  If the user's response is invalid, it prompts the user again
     *  using the <code>clarificationPrompt</code> until the user enters
     *  a valid response or selects Cancel.  If the user selects Cancel,
     *  <code>getLong</code> returns the <code>suggestedValue</code>.
     *    @param initialPrompt  the initial prompt to the user
     *    @param suggestedValue a suggested, valid value that is displayed
     *                          to the user, and is also used as the default
     *                          value if the user selects Cancel
     *    @param clarificationPrompt a follow-up prompt for input after
     *                               the user has input invalid data
     **/
    public static long getLong(String initialPrompt, long suggestedValue,
                                 String clarificationPrompt) 
    {
        return getLong(initialPrompt, Long.MIN_VALUE, Long.MAX_VALUE,
                          suggestedValue, clarificationPrompt);
    }

    /** Puts up a dialog box displaying the <code>initialPrompt</code>,
     *  waits for the user's response, and validates it (the response must
     *  be a valid long in the range provided).
     *  If the user's response is invalid, it prompts the user again
     *  using the <code>clarificationPrompt</code> until the user enters
     *  a valid response or selects Cancel.  If the user selects Cancel,
     *  <code>getLong</code> returns the <code>suggestedValue</code>.
     *    @param initialPrompt  the initial prompt to the user
     *    @param startOfRange   the smallest value in the range of valid values
     *    @param endOfRange     the largest value in the range of valid values
     *    @param suggestedValue a suggested, valid value that is displayed
     *                          to the user, and is also used as the default
     *                          value if the user selects Cancel
     *    @param clarificationPrompt a follow-up prompt for input after
     *                               the user has input invalid data
     **/
    public static long getLong(String initialPrompt,
                               long startOfRange, long endOfRange,
                               long suggestedValue, 
                               String clarificationPrompt) 
    {
        String suggested = "" + suggestedValue;
        String response = getResponse(initialPrompt, suggested);
        while (response != null)
            try
            {
                long userEntered = Long.parseLong(response.trim());
                if ( userEntered < startOfRange || userEntered > endOfRange ) 
                    throw new NumberFormatException();
                return userEntered;
            } 
            catch (NumberFormatException ex)
            {   response = getResponse(clarificationPrompt, suggested);   }
        return suggestedValue;
    }

    /** Puts up a dialog box displaying the <code>initialPrompt</code>,
     *  waits for the user's response, and validates it (the response must
     *  be a valid float).
     *  If the user's response is invalid, it prompts the user again
     *  using the <code>clarificationPrompt</code> until the user enters
     *  a valid response or selects Cancel.  If the user selects Cancel,
     *  <code>getFloat</code> returns the <code>suggestedValue</code>.
     *    @param initialPrompt  the initial prompt to the user
     *    @param suggestedValue a suggested, valid value that is displayed
     *                          to the user, and is also used as the default
     *                          value if the user selects Cancel
     *    @param clarificationPrompt a follow-up prompt for input after
     *                               the user has input invalid data
     **/
    public static float getFloat(String initialPrompt, float suggestedValue,
                                 String clarificationPrompt) 
    {
        String suggested = "" + suggestedValue;
        String response = getResponse(initialPrompt, suggested);
        while (response != null)
            try
            {
                float userEntered = Float.parseFloat(response.trim());
                return userEntered;
            } 
            catch (NumberFormatException ex)
            {   response = getResponse(clarificationPrompt, suggested);   }
        return suggestedValue;
    }
    
    /** Puts up a dialog box displaying the <code>initialPrompt</code>,
     *  waits for the user's response, and validates it (the response must
     *  be a valid float in the range provided).
     *  If the user's response is invalid, it prompts the user again
     *  using the <code>clarificationPrompt</code> until the user enters
     *  a valid response or selects Cancel.  If the user selects Cancel,
     *  <code>getFloat</code> returns the <code>suggestedValue</code>.
     *    @param initialPrompt  the initial prompt to the user
     *    @param startOfRange   the smallest value in the range of valid values
     *    @param endOfRange     the largest value in the range of valid values
     *    @param suggestedValue a suggested, valid value that is displayed
     *                          to the user, and is also used as the default
     *                          value if the user selects Cancel
     *    @param clarificationPrompt a follow-up prompt for input after
     *                               the user has input invalid data
     **/
    public static float getFloat(String initialPrompt,
                                 float startOfRange, float endOfRange,
                                 float suggestedValue,
                                 String clarificationPrompt) 
    {
        String suggested = "" + suggestedValue;
        String response = getResponse(initialPrompt, suggested);
        while (response != null)
            try
            {
                float userEntered = Float.parseFloat(response.trim());
                if ( userEntered < startOfRange || userEntered > endOfRange ) 
                    throw new NumberFormatException();
                return userEntered;
            } 
            catch (NumberFormatException ex)
            {   response = getResponse(clarificationPrompt, suggested);   }
        return suggestedValue;
    }
    
    /** Puts up a dialog box displaying the <code>initialPrompt</code>,
     *  waits for the user's response, and validates it (the response must
     *  be a valid double).
     *  If the user's response is invalid, it prompts the user again
     *  using the <code>clarificationPrompt</code> until the user enters
     *  a valid response or selects Cancel.  If the user selects Cancel,
     *  <code>getDouble</code> returns the <code>suggestedValue</code>.
     *  Any valid <code>double</code> value will be accepted.  If the
     *  number is out 
     *  of the range of a <code>double</code> the value will show up as the 
     *  <code>double</code> representation of either positive or negative
     *  inifinity.  
     *    @param initialPrompt  the initial prompt to the user
     *    @param suggestedValue a suggested, valid value that is displayed
     *                          to the user, and is also used as the default
     *                          value if the user selects Cancel
     *    @param clarificationPrompt a follow-up prompt for input after
     *                               the user has input invalid data
     **/
    public static double getDouble(String initialPrompt, double suggestedValue,
                                 String clarificationPrompt) 
    {
        String suggested = "" + suggestedValue;
        String response = getResponse(initialPrompt, suggested);
        while (response != null)
            try
            {
                double userEntered = Double.parseDouble(response.trim());
                return userEntered;
            } 
            catch (NumberFormatException ex)
            {   response = getResponse(clarificationPrompt, suggested);   }
        return suggestedValue;
    }
    
    /** Puts up a dialog box displaying the <code>initialPrompt</code>,
     *  waits for the user's response, and validates it (the response must
     *  be a valid double in the range provided).
     *  If the user's response is invalid, it prompts the user again
     *  using the <code>clarificationPrompt</code> until the user enters
     *  a valid response or selects Cancel.  If the user selects Cancel,
     *  <code>getDouble</code> returns the <code>suggestedValue</code>.
     *    @param initialPrompt  the initial prompt to the user
     *    @param startOfRange   the smallest value in the range of valid values
     *    @param endOfRange     the largest value in the range of valid values
     *    @param suggestedValue a suggested, valid value that is displayed
     *                          to the user, and is also used as the default
     *                          value if the user selects Cancel
     *    @param clarificationPrompt a follow-up prompt for input after
     *                               the user has input invalid data
     **/
    public static double getDouble(String initialPrompt,
                                   double startOfRange, double endOfRange,
                                   double suggestedValue,
                                   String clarificationPrompt) 
    {
        String suggested = "" + suggestedValue;
        String response = getResponse(initialPrompt, suggested);
        while (response != null)
            try
            {
                double userEntered = Double.parseDouble(response.trim());
                if ( userEntered < startOfRange || userEntered > endOfRange ) 
                    throw new NumberFormatException();
                return userEntered;
            } 
            catch (NumberFormatException ex)
            {   response = getResponse(clarificationPrompt, suggested);   }
        return suggestedValue;
    }
    
    /** Puts up a dialog box displaying the <code>initialPrompt</code>,
     *  waits for the user's response, and validates it (the response must
     *  be a valid char).  Special characters are accepted.  Any empty
     *  response will be taken as the null character.
     *  If the user's response is not a valid character, <code>getChar</code>
     *  prompts again using the <code>clarificationPrompt</code> until
     *  the user enters a valid response or selects Cancel.  If the user
     *  selects Cancel, <code>getChar</code> returns the
     *  <code>suggestedValue</code>.
     *    @param initialPrompt  the initial prompt to the user
     *    @param suggestedValue a suggested, valid value that is displayed
     *                          to the user, and is also used as the default
     *                          value if the user selects Cancel
     *    @param clarificationPrompt a follow-up prompt for input after
     *                               the user has input invalid data
     **/
    public static char getChar(String initialPrompt, char suggestedValue,
                               String clarificationPrompt)
    {
        String suggested = "" + suggestedValue;
        String response = getResponse(initialPrompt, suggested);
        while (response != null)
            try
            {
                String userEntered = response.trim();
                if (userEntered.equals(""))
                    return '\u0000';
                else if  (userEntered.length() != 1)
                    throw new DataFormatException();
                return userEntered.charAt(0);
            } 
            catch (DataFormatException ex)
            {   response = getResponse(clarificationPrompt, suggested);   }
        return suggestedValue;
    }
    
    /** Puts up a dialog box displaying the <code>initialPrompt</code>,
     *  waits for the user's response.  Because it is prompting for a 
     *  <code>String</code>, any response will be accepted, including
     *  an empty string.
     *  If the user selects Cancel the <code>suggestedValue</code>.
     *  will be returned.
     *    @param initialPrompt  the initial prompt to the user
     *    @param suggestedValue a suggested, valid value that is displayed
     *                          to the user, and is also used as the default
     *                          value if the user selects Cancel
     **/
    public static String getString(String initialPrompt, String suggestedValue)
    {
        String suggested = "" + suggestedValue;
        String response = getResponse(initialPrompt, suggested);
        return response.trim();
    }
    
    /** Puts up a dialog box displaying the <code>initialPrompt</code>,
     *  waits for the user's response, and validates it.  The response must
     *  be a valid boolean in the form of "true" or "false" (case-insensitive).
     *  If the user's response is invalid, it prompts the user again
     *  using the <code>clarificationPrompt</code> until the user enters
     *  a valid response or selects Cancel.  If the user selects Cancel,
     *  <code>getBoolean</code> returns the <code>suggestedValue</code>.
     *    @param initialPrompt  the initial prompt to the user
     *    @param suggestedValue a suggested, valid value that is displayed
     *                          to the user, and is also used as the default
     *                          value if the user selects Cancel
     *    @param clarificationPrompt a follow-up prompt for input after
     *                               the user has input invalid data
     **/
    public static boolean getBoolean(String initialPrompt,
                                     boolean suggestedValue,
                                     String clarificationPrompt)
    {
        String suggested = "" + suggestedValue;
        String response = getResponse(initialPrompt, suggested);
        while (response != null)
            try
            {
                String userEntered = (response.trim()).toUpperCase();
                if (userEntered.equals("TRUE"))
                    return true;
                else if  (userEntered.equals("FALSE"))
                    return false;
                else
                    throw new DataFormatException();
            } 
            catch (DataFormatException ex)
            {   response = getResponse(clarificationPrompt, suggested);   }
        return suggestedValue;
    }

    /** Displays the appropriate JOptionPane and gets the result. **/
    protected static String getResponse(String prompt,
                                        String suggestedValue)
    {
        return (String)JOptionPane.showInputDialog(null, prompt,
                        "Input", JOptionPane.QUESTION_MESSAGE, null, null,
                        suggestedValue);
    }

}