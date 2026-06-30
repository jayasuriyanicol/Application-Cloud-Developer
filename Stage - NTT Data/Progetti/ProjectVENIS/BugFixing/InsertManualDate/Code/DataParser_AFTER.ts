/*
? Purpose
 * The following implementation represents the optimized and refactored parsing logic designed to resolve Bug Report TC-017.
 * The updated architecture introduces a preprocessing normalization layer that intercepts raw string structures—specifically targeting manual delimiters and lazy numeric sequence ambiguities—and standardizes them into fully-compliant tokens before handing validation over to Day.js.
 * This maintains the safety net of the strict parsing mode (true) to prevent calendar overflowing (e.g., rejecting invalid dates like February 30th) while maximizing user input flexibility.
*/

import dayjs from 'dayjs';

/**
 * NTT DATA - ANONYMIZED KNOWLEDGE BASE
 * 
 * OPTIMIZED LOGIC (SOLVED):
 * Structural Preprocessing & Dynamic Token Component Normalization.
 * Dynamically sanitizes keyboard inputs, handles length ambiguities, 
 * and applies automated zero-padding to manual delimiters.
 */
export function normalizeDateParser(value: string): dayjs.Dayjs | null {
  if (!value) {
    return null;
  }

  // 1. Sanitize input string and homogenize minor separators
  let cleanValue = value.trim().replace(/[-\s.]/g, '/');

  // ? Case 1: Numeric-Only Sequence (Lazy Entry e.g., "3062026")
  if (/^\d+$/.test(cleanValue)) {
    const len = cleanValue.length;

    if (len === 5 || len === 7) {
      // Resolve corporate precedence: handle double-digit days starting with 10-31
      const primoBloccoGiorno = parseInt(cleanValue.substring(0, 2), 10);
      
      if (primoBloccoGiorno >= 10 && primoBloccoGiorno <= 31) {
        // Map as GG M AAAA (e.g., 3062026 -> 30/06/2026)
        cleanValue = len === 7
          ? cleanValue.substring(0, 2) + '/' + cleanValue.substring(2, 3) + '/' + cleanValue.substring(3, 7)
          : cleanValue.substring(0, 2) + '/' + cleanValue.substring(2, 3) + '/' + cleanValue.substring(3, 5);
      } else {
        // Map as G MM AAAA (e.g., 5062026 -> 5/06/2026)
        cleanValue = len === 7
          ? cleanValue.substring(0, 1) + '/' + cleanValue.substring(1, 3) + '/' + cleanValue.substring(3, 7)
          : cleanValue.substring(0, 1) + '/' + cleanValue.substring(1, 3) + '/' + cleanValue.substring(3, 5);
      }
    } else if (len === 6) {
      cleanValue = cleanValue.substring(0, 2) + '/' + cleanValue.substring(2, 4) + '/' + cleanValue.substring(4, 6);
    } else if (len === 8) {
      cleanValue = cleanValue.substring(0, 2) + '/' + cleanValue.substring(2, 4) + '/' + cleanValue.substring(4, 8);
    } else {
      return null;
    }
  } 
  // ? Case 2: Explicit Delimiters Found (Manual Entry with Slashes e.g., "3/11/2026")
  else if (cleanValue.includes('/')) {
    const parti = cleanValue.split('/');
    if (parti.length === 3) {
      let giorno = parti[0];
      let mese = parti[1];
      const anno = parti[2];

      // Automated zero-padding injection for single-digit components
      if (giorno.length === 1) giorno = '0' + giorno;
      if (mese.length === 1) mese = '0' + mese;
      
      // Reassemble the normalized Italian string layout
      cleanValue = `${giorno}/${mese}/${anno}`;
    }
  }

  // Standardized parsing formats, explicitly supporting lazy fallbacks
  const formatiDateAccettate = ['DD/MM/YYYY', 'DD/MM/YY', 'D/M/YY', 'D/MM/YYYY', 'DD/M/YYYY'];
  
  // Safe validation execution with strict token matching enabled
  const dataNormalizzata = dayjs(cleanValue, formatiDateAccettate, true);

  return dataNormalizzata.isValid() ? dataNormalizzata : null;
}