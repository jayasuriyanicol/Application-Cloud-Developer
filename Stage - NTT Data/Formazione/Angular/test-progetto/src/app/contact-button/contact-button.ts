import {Component, EventEmitter, Input,Output} from '@angular/core';


// @ts-ignore
@Component({
  selector: 'app-contact-button',
  standalone: true,
  template: `

    <div class="box">
      <h3>{{nomeProdotto}}</h3>
      <button (click)="inviaNotifica()">Seleziona</button>
    </div>

  `,
  styles: [`.box { border: 1px solid #605DC8; padding: 15px; }`],
  imports: [],
  styleUrl: './contact-button.css',
})
export class ContactButton {

  //Here how comunicate from child to dad
  @Input() nomeProdotto!: string;

  //There is the logic how to create the communication between the dad and the child, as an updater.
  //And so we create the event, launching that calling it in the method
  @Output() prodottoSelezionato = new EventEmitter<string>();

  inviaNotifica() {

    //Here we launch the child to the father using the name
    this.prodottoSelezionato.emit(this.nomeProdotto);
  }
}
