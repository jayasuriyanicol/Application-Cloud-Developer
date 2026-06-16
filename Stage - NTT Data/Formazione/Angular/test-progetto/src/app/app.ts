import { Component, signal } from '@angular/core';
import {ContactButton} from './contact-button/contact-button';

// @ts-ignore
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [ContactButton],

  template: ` <h1>Il mio negozio online</h1>

 <app-contact-button

   [nomeProdotto] ="'Scarpe'"
   (prodottoSelezionato)="gestisciClick($event)">
 </app-contact-button>


  <app-contact-button

    [nomeProdotto] ="'Asino'"
    (prodottoSelezionato)="gestisciClick($event)">
    </app-contact-button>
   `
})
export class App {

  gestisciClick(nome: String) {

    console.log('Il padre ha ricevuto il segnale per: ',nome);
    alert('Hai scelto: '+nome);
  }

}
