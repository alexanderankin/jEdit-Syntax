package org.jedit.syntax;

import javax.swing.text.Segment;

/**
 * Simple XPath Token Marker
 *
 * @author Tom Bradford
 * @version $Id$
 */
public class XPathTokenMarker extends TokenMarker {
   private static final String OPS = "<>=/()[]@*";
   private static final String QUOTES = "\"\'";
   
   public XPathTokenMarker() {
   }
   
   public byte markTokensImpl(byte token, Segment line, int lineIndex) {
      char[] array = line.array;
      int offset = line.offset;
      int lastOffset = offset;
      int length = line.count + offset;
      
      for ( int i = offset; i < length; i++ ) {
         int ip1 = i+1;
         char c = array[i];
         switch ( token ) {
            case Token.NULL: // text
               if ( OPS.indexOf(c) != -1 ) {
                  addToken(i-lastOffset, token);
                  lastOffset = i;
                  token = Token.KEYWORD1;
               }
               else if ( QUOTES.indexOf(c) != -1 ) {
                  addToken(i-lastOffset, token);
                  lastOffset = i;
                  if ( c == '\"' )
                     token = Token.LITERAL2;
                  else
                     token = Token.LITERAL1;
               }
               break;

            case Token.KEYWORD1: // operator
               if ( OPS.indexOf(c) == -1 ) {
                  addToken(i-lastOffset, token);
                  lastOffset = i;
                  if ( QUOTES.indexOf(c) != -1 ) {
                     if ( c == '\"' )
                        token = Token.LITERAL2;
                     else
                        token = Token.LITERAL1;
                  }
                  else
                     token = Token.NULL;
               }
               break;
               
            case Token.LITERAL1:
            case Token.LITERAL2: // strings
               if ( ( token == Token.LITERAL2 && c == '\"' )
                 || ( token == Token.LITERAL1 && c == '\'' ) ) {
                  addToken(ip1-lastOffset, token);
                  lastOffset = ip1;
                  token = Token.NULL;
               }
               break;
               
            default:
               throw new InternalError("Invalid state: " + token);
         }
      }
      
      addToken(length-lastOffset, token);
      return token;
   }
}


