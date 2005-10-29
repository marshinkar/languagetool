/* JLanguageTool, a natural language style checker 
 * Copyright (C) 2005 Daniel Naber (http://www.danielnaber.de)
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
package de.danielnaber.languagetool.tagging.de;

import java.io.IOException;

import junit.framework.TestCase;

/**
 * @author Daniel Naber
 */
public class GermanTaggerTest extends TestCase {

  public void testTagger() throws IOException {
    GermanTagger tagger = new GermanTagger();
    AnalyzedGermanToken aToken = tagger.lookup("Haus", 0);
    assertEquals("Haus[Nomen/Nom/Sin/Neu, Nomen/Dat/Sin/Neu, " +
            "Nomen/Akk/Sin/Neu]", aToken.toString());
    aToken = tagger.lookup("Hauses", 0);
    assertEquals("Hauses[Nomen/Gen/Sin/Neu]", aToken.toString());
    aToken = tagger.lookup("hauses", 0);
    assertNull(aToken);
    aToken = tagger.lookup("Groß", 0);
    assertNull(aToken);
    aToken = tagger.lookup("großer", 0);
    assertEquals("großer[Adjektiv/Nom/Sin/Mas, Adjektiv/Gen/Plu/Mas, " +
            "Adjektiv/Gen/Sin/Fem, Adjektiv/Dat/Sin/Fem, " +
            "Adjektiv/Gen/Plu/Fem, Adjektiv/Gen/Plu/Neu]", aToken.toString());
  }
  
}
