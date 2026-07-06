/*Frontend Implementation (TypeScript)

 1. On-Demand Step Interception (`GraduatoriaCreateComponent.ts`)

Instead of flooding the server with HTTP requests on every single keystroke, the frontend check triggers exclusively when the user clicks the action button to leave Step 1. Concurrent double-clicks are completely blocked by a loading flag.
*/

isCheckingCodice = false;

goNextStep1(stepper: any): void {
  const codiceControl = this.step1Form.get('codice');
  if (this.step1Form.invalid || !codiceControl?.value) {
    this.step1Form.markAllAsTouched();
    return;
  }

  this.isCheckingCodice = true;
  const rawValue = String(codiceControl.value);

  this.graduatorieService.checkCodiceUnivoco(rawValue).subscribe({
    next: (isDuplicate) => {
      this.isCheckingCodice = false;
      if (isDuplicate) {
        codiceControl.setErrors({ codiceDuplicato: true });
        codiceControl.markAsTouched();
      } else {
        codiceControl.setErrors(null);
        stepper.next(); // Seamlessly advances to Step 2
      }
    },
    error: () => {
      this.isCheckingCodice = false;
      alert('SERVICE TEMPORARILY UNAVAILABLE. PLEASE TRY AGAIN.');
    }
  });
}

